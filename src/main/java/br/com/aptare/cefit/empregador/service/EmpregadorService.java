package br.com.aptare.cefit.empregador.service;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.aptare.cadastroUnico.entidade.CadastroUnico;
import br.com.aptare.cadastroUnico.servico.CadastroUnicoService;
import br.com.aptare.cefit.empregador.entity.Empregador;
import br.com.aptare.fda.crud.service.AptareService;
import br.com.aptare.fda.exception.AptareException;
import br.com.aptare.fda.exception.TratamentoPadraoErro;
import br.com.aptare.seguranca.entidade.Auditoria;

public class EmpregadorService extends AptareService<Empregador>
{
   private static EmpregadorService instancia;
   
   public static int JOIN_CADASTRO_UNICO = 1;
   
   
   public static int SITUACAO_PENDENTE = 1;
   public static int SITUACAO_ATIVA = 2;
   public static int SITUACAO_INATIVA = 3;

   public static EmpregadorService getInstancia()
   {
      if (instancia == null)
      {
         instancia = new EmpregadorService();
      }
      return instancia;
   }

   private EmpregadorService()
   {
   }
   
   @Override
   public Empregador inserir(Session session, Empregador entity) throws AptareException
   {
      this.validarInserir(session, entity);
      
      CadastroUnico cadastroUnico = entity.getCadastroUnico();
      cadastroUnico = CadastroUnicoService.getInstancia().inserir(session, cadastroUnico);
      session.flush();
      
      entity.setCodigoCadastroUnico(cadastroUnico.getCodigo());
      session.save(entity);
         
      return entity;
   }
   
   @Override
   protected void validarInserir(Session session, Empregador entity) throws AptareException
   {
      CadastroUnico cadastroUnico = new CadastroUnico();
      cadastroUnico.setCpfCnpj(entity.getCadastroUnico().getCpfCnpj());
      //cadastroUnico.setTipoPessoa("J");
      
      cadastroUnico = CadastroUnicoService.getInstancia().get(cadastroUnico, null, null);
      
      if(cadastroUnico != null)
      {
         if(cadastroUnico.getTipoPessoa().equals("J"))
         {
            throw new AptareException("Este CNPJ já existe em nossa base de dados.");
         }
         else
         {
            throw new AptareException("Este CPF já existe em nossa base de dados.");
         }
      }
   }
   
   @Override
   public Empregador alterar(Session session, Empregador entity) throws AptareException
   {
      this.validarAlterar(session, entity);
      
      CadastroUnico cadastroUnico = entity.getCadastroUnico();
      cadastroUnico = CadastroUnicoService.getInstancia().alterar(session, cadastroUnico);
      session.flush();
      
      session.update(entity);
         
      return entity;
   }
   
   @Override
   protected void validarAlterar(Session session, Empregador entity) throws AptareException
   {
      CadastroUnico cadastroUnico = new CadastroUnico();
      cadastroUnico.setCpfCnpj(entity.getCadastroUnico().getCpfCnpj());
      //cadastroUnico.setTipoPessoa("J");
      
      cadastroUnico = CadastroUnicoService.getInstancia().get(cadastroUnico, null, null);
      
      if(cadastroUnico != null
            && cadastroUnico.getCodigo().intValue() != entity.getCodigoCadastroUnico().intValue())
      {
         if(cadastroUnico.getTipoPessoa().equals("J"))
         {
            throw new AptareException("Este CNPJ já existe em nossa base de dados.");
         }
         else
         {
            throw new AptareException("Este CPF já existe em nossa base de dados.");
         }
      }
   }
   
   public Empregador ativarInativar(Empregador entity) throws AptareException
   {
       Session session = getSession();
       session.setFlushMode(FlushMode.COMMIT);
       Transaction tx = session.beginTransaction();
       try
       {
           Empregador retorno = this.ativarInativar(session, entity);
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

   public Empregador ativarInativar(Session session, Empregador entity) throws AptareException
   {
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
