package br.com.aptare.cefit.usuarioExtends.service;

import br.com.aptare.cadastroUnico.entidade.CadastroUnico;
import br.com.aptare.cadastroUnico.servico.CadastroUnicoService;
import br.com.aptare.cefit.email.service.EmailService;
import br.com.aptare.cefit.email.service.SenhaService;
import br.com.aptare.cefit.util.CriptoMD5;
import br.com.aptare.fda.crud.service.AptareService;
import br.com.aptare.fda.exception.AptareException;
import br.com.aptare.fda.exception.TratamentoPadraoErro;
import br.com.aptare.seguranca.entidade.Usuario;
import br.com.aptare.seguranca.servico.UsuarioService;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class UsuarioServiceCefit extends AptareService<Usuario> {

    private static UsuarioServiceCefit instancia;


    public static UsuarioServiceCefit getInstancia()
    {
        if (instancia == null)
        {
            instancia = new UsuarioServiceCefit();
        }
        return instancia;
    }

    public Usuario resetarSenha(Usuario entity) throws AptareException
    {
        Session session = getSession();
        session.setFlushMode(FlushMode.COMMIT);
        Transaction tx = session.beginTransaction();

        try
        {
            Usuario retorno = this.resetarSenha(session, entity);
            tx.commit();
            return retorno;
        }
        catch (Exception ae)
        {
            throw TratamentoPadraoErro.getInstancia().catchHBEdicaoSession(ae, tx);
        }
        finally
        {
            session.close();
        }
    }

    private Usuario resetarSenha(Session session, Usuario entity) throws AptareException {
        Usuario usuario = new Usuario();
        usuario.setLogin(entity.getLogin());

        Usuario entityUsuario =  UsuarioService.getInstancia().get(usuario,new String[] {
                "cadastroUnico.pessoaJuridica*.listaContato*.cargo*",
                "cadastroUnico.pessoaJuridica*.listaContato*.listaTelefone*.auditoria*",
                "cadastroUnico.pessoaFisica*.listaTelefone*.auditoria*",
                "cadastroUnico.listaEndereco.correio*",
                "cadastroUnico.listaEndereco.extensaoEndereco*",
                "auditoria.usuarioInclusao","listaUsuarioGrupo*"},null);

        //VERIFICA SE EXISTE O USUARIO NO BANCO
        if (entityUsuario == null)
        {
            throw new AptareException("Usuário não Encontrado.");
        }

        //BUSCA CADASTRO UNICO DO USUARIO
        CadastroUnico cadastroUnico = new CadastroUnico();
        cadastroUnico.setCodigo(entityUsuario.getCodigoCadastroUnico());

        CadastroUnico entityCadastroUnico = CadastroUnicoService.getInstancia().get(session,cadastroUnico,null,null);

        this.completarResetarSenha(entityUsuario,session,entityCadastroUnico.getEmail());

        return entity;
    }

    private void completarResetarSenha(Usuario entityUsuario, Session session, String email) throws AptareException {

        String novaSenha = SenhaService.getInstancia().gerarSenhaAleatoria();
        String senhaAntiga = entityUsuario.getSenha();

        //DEFININDO NOVA SENHA DO USUAARIO
        entityUsuario.setSenha(CriptoMD5.stringHexa(novaSenha));
        entityUsuario.getAuditoria().setCodigoUsuarioAlteracao(entityUsuario.getCodigo());
        entityUsuario.getAuditoria().setDataAlteracao(new Date());

        //SALVANDO ALTERAÇOES DO USUARIO
        session.merge(entityUsuario);

        //ENVIANDO EMAIL
        EmailService.getInstancia().enviarEmailNotificacao(email,entityUsuario.getLogin(),novaSenha,true);

    }
}
