package br.com.aptare.cefit.usuarioExtends.service;

import br.com.aptare.cadastroUnico.entidade.CadastroUnico;
import br.com.aptare.cadastroUnico.servico.CadastroUnicoService;
import br.com.aptare.cefit.email.service.EmailService;
import br.com.aptare.cefit.email.service.SenhaService;
import br.com.aptare.cefit.empregador.entity.Empregador;
import br.com.aptare.cefit.empregador.service.EmpregadorService;
import br.com.aptare.fda.crud.service.AptareService;
import br.com.aptare.fda.exception.AptareException;
import br.com.aptare.fda.exception.TratamentoPadraoErro;
import br.com.aptare.seguranca.entidade.Auditoria;
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

//    public Empregador inserirUsuario(Empregador entity) throws AptareException
//    {
//        Session session = getSession();
//        session.setFlushMode(FlushMode.COMMIT);
//        Transaction tx = session.beginTransaction();
//
//        try
//        {
//            Empregador retorno = this.inserirNovoUsuario(session, entity);
//            tx.commit();
//            return retorno;
//        }
//        catch (Exception ae)
//        {
//            throw TratamentoPadraoErro.getInstancia().catchHBEdicaoSession(ae, tx);
//        }
//        finally
//        {
//            session.close();
//        }
//    }
//
//
//    public Empregador inserirNovoUsuario(Session session, Empregador entity) throws AptareException {
//        this.validarInserir(session, entity);
//
//        CadastroUnico cadastroUnico = entity.getCadastroUnico();
//        CadastroUnico objCadastroUnico = new CadastroUnico();
//
//        objCadastroUnico.setEmail(entity.getCadastroUnico().getEmail());
//
//        objCadastroUnico = CadastroUnicoService.getInstancia().get(session,objCadastroUnico,null,null);
//
//        if(objCadastroUnico != null){
//            throw new AptareException("Um empregador com esse E-Mail já existe em nossa base de dados.");
//        }
//
//        if (cadastroUnico.getCodigo() != null) {
//            cadastroUnico = CadastroUnicoService.getInstancia().alterar(session, cadastroUnico);
//        } else {
//            cadastroUnico = CadastroUnicoService.getInstancia().inserir(session, cadastroUnico);
//        }
//
//        session.flush();
//
//        entity.setCodigoCadastroUnico(cadastroUnico.getCodigo());
//
//        Usuario usuario = new Usuario();
//        String senhaGeradaAleatoria = SenhaService.getInstancia().gerarSenhaAleatoria();// GERANDO SENHA 8 DIGITOS
//
//
//        //VERIFICA TIPO DE PESSOA SE É 'J' OU 'F'
//        if (entity.getCadastroUnico().getTipoPessoa().equals("F")) {
//            usuario.setLogin(entity.getCadastroUnico().getCpf());
//
//        } else {
//            if (entity.getCadastroUnico().getCnpj() != null) {
//                usuario.setLogin(entity.getCadastroUnico().getCnpj());
//            } else
//                usuario.setLogin(entity.getNumeroCei().toString());//todo getNumeroCei é um Long e nao uma string
//        }
//
//        //POPULANDO USUSARIO
//        usuario.setNome(entity.getCadastroUnico().getNome());
//        usuario.setSenha(senhaGeradaAleatoria);
//        usuario.setCodigoCadastroUnico(entity.getCodigoCadastroUnico());
//        usuario.setSituacao(UsuarioService.SITUACAO_ATIVO);
//        usuario.setFlagAdministrador("N");
//        usuario.setAuditoria(new Auditoria());
//        usuario.getAuditoria().setCodigoUsuarioInclusao(1L);
//        usuario.getAuditoria().setDataInclusao(new Date());
//        usuario.getAuditoria().setDataInclusao(new Date());
//        usuario.setCadastroUnico(entity.getCadastroUnico());
//
//
//        Usuario usuariocadastrado = UsuarioService.getInstancia().inserir(session, usuario);
//
//        session.save(entity);
//
//        EmailService.getInstancia()
//                .enviarEmailNotificacao(entity.getCadastroUnico().getEmail(),usuario.getLogin(),senhaGeradaAleatoria,false);
//        return entity;
//
//    }
//
//
//    protected void validarInserir(Session session, Empregador entity) throws AptareException {
//        Empregador empregador = new Empregador();
//        empregador.setNumeroCei(entity.getNumeroCei());
//        empregador.setCadastroUnico(new CadastroUnico());
//        empregador.getCadastroUnico().setCpfCnpj(entity.getCadastroUnico().getCpfCnpj());
//
//        empregador = EmpregadorService.getInstancia().get(session, empregador, new String[]{"cadastroUnico"}, null);
//
//        if (empregador != null) {
//            if (empregador.getCadastroUnico().getTipoPessoa().equals("J")) {
//                throw new AptareException("Este empregador já existe em nossa base de dados.");
//            } else {
//                throw new AptareException("Este CPF já existe em nossa base de dados.");
//            }
//        }
//    }



    public Empregador resetarSenha(Empregador entity) throws AptareException
    {
        Session session = getSession();
        session.setFlushMode(FlushMode.COMMIT);
        Transaction tx = session.beginTransaction();

        try
        {
            Empregador retorno = this.resetarSenha(session, entity);
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

    private Empregador resetarSenha(Session session, Empregador entity) throws AptareException {
        CadastroUnico cadastroUnico = new CadastroUnico();
        cadastroUnico.setEmail(entity.getCadastroUnico().getEmail());

        if(entity.getCadastroUnico().getTipoPessoa().equals("F")){
            cadastroUnico.setTipoPessoa(entity.getCadastroUnico().getTipoPessoa());
            cadastroUnico.setCpfCnpj(Long.parseLong(entity.getCadastroUnico().getCpf()));
        }else{
            cadastroUnico.setTipoPessoa("J");
            cadastroUnico.setCpfCnpj(Long.parseLong(entity.getCadastroUnico().getCnpj()));
        }

        CadastroUnico entyCadastroUnico = CadastroUnicoService.getInstancia().get(session,cadastroUnico,null,null);

        if (entyCadastroUnico == null)
        {
            throw new AptareException("Usuário não encontrado.");
        }

        Usuario usuario = new Usuario();
        usuario.setCodigoCadastroUnico(entyCadastroUnico.getCodigo());

        //GET USUARIO
        Usuario entityUsuario = UsuarioService.getInstancia().get(usuario,new String[] {"cadastroUnico.pessoaJuridica*.listaContato*.cargo*",
                "cadastroUnico.pessoaJuridica*.listaContato*.listaTelefone*.auditoria*",
                "cadastroUnico.pessoaFisica*.listaTelefone*.auditoria*",
                "cadastroUnico.listaEndereco.correio*",
                "cadastroUnico.listaEndereco.extensaoEndereco*",
                "auditoria.usuarioInclusao","listaUsuarioGrupo*"},null);


        if (entityUsuario == null)
        {
            throw new AptareException("Não possui Usuário cadastrado.");
        }

        this.completarResetarSenha(entityUsuario,session,entyCadastroUnico.getEmail());

        return entity;
    }

    private void completarResetarSenha(Usuario entityUsuario, Session session, String email) throws AptareException {

        String novaSenha = SenhaService.getInstancia().gerarSenhaAleatoria();
        String senhaAntiga = entityUsuario.getSenha();

        //CRIANDO FILTRO
//      FiltroUsuario filtroUsuario = new FiltroUsuario();
//      filtroUsuario.setSenhaAntiga(senhaAntiga);

        entityUsuario.setSenha(novaSenha);
        entityUsuario.getAuditoria().setCodigoUsuarioAlteracao(entityUsuario.getCodigo());
        entityUsuario.getAuditoria().setDataAlteracao(new Date());

        UsuarioService.getInstancia().alterar(session,entityUsuario);

        EmailService.getInstancia().enviarEmailNotificacao(email,entityUsuario.getLogin(),novaSenha,true);

    }
}
