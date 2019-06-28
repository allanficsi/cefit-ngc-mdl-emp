package br.com.aptare.cefit.empregador.service;

import br.com.aptare.cadastroUnico.entidade.CadastroUnico;
import br.com.aptare.cadastroUnico.servico.CadastroUnicoService;
import br.com.aptare.cefit.email.service.EmailService;
import br.com.aptare.cefit.email.service.SenhaService;
import br.com.aptare.cefit.empregador.entity.Empregador;
import br.com.aptare.cefit.utilNgc.CriptoMD5;
import br.com.aptare.fda.crud.service.AptareService;
import br.com.aptare.fda.exception.AptareException;
import br.com.aptare.fda.exception.TratamentoPadraoErro;
import br.com.aptare.fda.hibernate.CatalogoRestricoes;
import br.com.aptare.seguranca.entidade.Auditoria;
import br.com.aptare.seguranca.entidade.Usuario;
import br.com.aptare.seguranca.servico.UsuarioService;
import org.apache.commons.codec.digest.Md5Crypt;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class EmpregadorService extends AptareService<Empregador> {
   private static EmpregadorService instancia;

   public static int JOIN_CADASTRO_UNICO = 1;


   public static int SITUACAO_PENDENTE = 1;
   public static int SITUACAO_ATIVA = 2;
   public static int SITUACAO_INATIVA = 3;

   public static EmpregadorService getInstancia() {
      if (instancia == null) {
         instancia = new EmpregadorService();
      }
      return instancia;
   }

   private EmpregadorService() {
      adicionarFiltro("cadastroUnico.nome", CatalogoRestricoes.FAZ_PARTE_SEM_ACENTO, "cadastroUnico.nome");
      adicionarFiltro("filtroGenerico", CatalogoRestricoes.FAZ_PARTE, "filtroGenerico");
   }

   @Override
   public Empregador inserir(Session session, Empregador entity) throws AptareException {
      this.validarInserir(session, entity);


     // CadastroUnico objCadastroUnico = new CadastroUnico();

      // objCadastroUnico.setEmail(entity.getCadastroUnico().getEmail());

//      objCadastroUnico = CadastroUnicoService.getInstancia().get(session,objCadastroUnico,null,null);
//
////      if(objCadastroUnico != null){
////         throw new AptareException("Um empregador Com esse E-Mail já existe em nossa base de dados.");
////      }
      CadastroUnico cadastroUnico = entity.getCadastroUnico();

      if (cadastroUnico.getCodigo() != null) {
         cadastroUnico = CadastroUnicoService.getInstancia().alterar(session, cadastroUnico);
      } else {
         cadastroUnico = CadastroUnicoService.getInstancia().inserir(session, cadastroUnico);
      }

      session.flush();

      entity.setCodigoCadastroUnico(cadastroUnico.getCodigo());
      session.save(entity);

      //CRIANDO NOVO USUARIO
      Usuario usuario = new Usuario();

      // GERANDO SENHA 8 DIGITOS
      String senhaGeradaAleatoria = SenhaService.getInstancia().gerarSenhaAleatoria();

      //VERIFICA TIPO DE PESSOA SE É 'J' OU 'F'
      if (entity.getCadastroUnico().getTipoPessoa().equals("F")) {
         usuario.setLogin(entity.getCadastroUnico().getCpf());

      } else {
         if (entity.getCadastroUnico().getCnpj() != null) {
            usuario.setLogin(entity.getCadastroUnico().getCnpj());
         } else {
            usuario.setLogin(entity.getNumeroCei().toString());//todo getNumeroCei é um Long e nao uma string
         }
      }


      //POPULANDO USUSARIO
      usuario.setNome(entity.getCadastroUnico().getNome());
      usuario.setSenha(CriptoMD5.stringHexa(senhaGeradaAleatoria));
      usuario.setCodigoCadastroUnico(entity.getCodigoCadastroUnico());
      usuario.setSituacao(UsuarioService.SITUACAO_ATIVO);
      usuario.setFlagAdministrador("N");
      usuario.setAuditoria(new Auditoria());
      usuario.getAuditoria().setCodigoUsuarioInclusao(1L);
      usuario.getAuditoria().setDataInclusao(new Date());
     // usuario.getAuditoria().setDataInclusao(new Date());
//      usuario.setCadastroUnico(entity.getCadastroUnico());

      session.save(usuario);

      //Usuario usuariocadastrado = UsuarioService.getInstancia().inserir(session, usuario);

      EmailService.getInstancia()
              .enviarEmailNotificacao(entity.getCadastroUnico().getEmail(),usuario.getLogin(),senhaGeradaAleatoria,false);

      return entity;
   }

   @Override
   protected void validarInserir(Session session, Empregador entity) throws AptareException {
      Empregador empregador = new Empregador();
      empregador.setNumeroCei(entity.getNumeroCei());
      empregador.setCadastroUnico(new CadastroUnico());
      empregador.getCadastroUnico().setCpfCnpj(entity.getCadastroUnico().getCpfCnpj());

      empregador = this.get(session, empregador, new String[]{"cadastroUnico"}, null);

      if (empregador != null) {
         if (empregador.getCadastroUnico().getTipoPessoa().equals("J")) {
            throw new AptareException("Este empregador já existe em nossa base de dados.");
         } else {
            throw new AptareException("Este CPF já existe em nossa base de dados.");
         }
      }
   }

   @Override
   public Empregador alterar(Session session, Empregador empregador) throws AptareException {
      this.validarAlterar(session, empregador);

      CadastroUnico cadastroUnico = empregador.getCadastroUnico();
      empregador.setCadastroUnico(null);

      cadastroUnico.setAuditoria(empregador.getAuditoria());
      cadastroUnico = CadastroUnicoService.getInstancia().alterarSemValidacao(session, cadastroUnico);

      session.flush();

      session.merge(empregador);

      empregador.setCadastroUnico(cadastroUnico);

      return empregador;
   }

   @Override
   protected void validarAlterar(Session session, Empregador empregador) throws AptareException {
      if (empregador.getCadastroUnico() != null
              && empregador.getCadastroUnico().getCpfCnpj() != null
              && empregador.getCadastroUnico().getCpfCnpj().intValue() > 0) {
         CadastroUnico cadastroUnico = new CadastroUnico();
         cadastroUnico.setCpfCnpj(empregador.getCadastroUnico().getCpfCnpj());

         cadastroUnico = CadastroUnicoService.getInstancia().get(session, cadastroUnico, null, null);

         if (cadastroUnico != null
                 && cadastroUnico.getCodigo() != null
                 && cadastroUnico.getCodigo().intValue() != empregador.getCodigoCadastroUnico().intValue()) {
            if (cadastroUnico.getTipoPessoa().equals("J")) {
               throw new AptareException("Este empregador já existe em nossa base de dados.");
            } else {
               throw new AptareException("Este CPF já existe em nossa base de dados.");
            }
         }
      } else {
         if (empregador.getNumeroCei() != null && empregador.getNumeroCei().intValue() > 0) {
            Empregador objEmp = new Empregador();
            objEmp.setNumeroCei(empregador.getNumeroCei());

            objEmp = this.get(session, objEmp, null, null);

            if (objEmp != null
                    && objEmp.getCodigo() != null
                    && objEmp.getCodigo().intValue() != empregador.getCodigo().intValue()) {
               throw new AptareException("Este empregador já existe em nossa base de dados.");
            }
         }
      }
   }

   public Empregador ativarInativar(Empregador entity) throws AptareException {
      Session session = getSession();
      session.setFlushMode(FlushMode.COMMIT);
      Transaction tx = session.beginTransaction();
      try {
         Empregador retorno = this.ativarInativar(session, entity);
         tx.commit();
         return retorno;
      } catch (Exception ae) {
         throw TratamentoPadraoErro.getInstancia().catchHBEdicaoSession(ae, tx);
      } finally {
         session.close();
      }
   }

   public Empregador ativarInativar(Session session, Empregador entity) throws AptareException {
      // Get cargo somente com o codigo
      Empregador empregador = new Empregador();
      empregador.setCodigo(entity.getCodigo());

      empregador = this.get(session, empregador, null, null);

      empregador.setSituacao(entity.getSituacao());
      empregador.setAuditoria(new Auditoria());
      empregador.getAuditoria().setDataAlteracao(entity.getAuditoria().getDataAlteracao());
      empregador.getAuditoria().setCodigoUsuarioAlteracao(entity.getAuditoria().getCodigoUsuarioAlteracao());

      session.merge(empregador);

      return empregador;
   }

}
