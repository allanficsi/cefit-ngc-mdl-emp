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
import br.com.aptare.fda.hibernate.CatalogoRestricoes;
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
      adicionarFiltro("cadastroUnico.nome", CatalogoRestricoes.FAZ_PARTE_SEM_ACENTO, "cadastroUnico.nome");
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
      Empregador empregador = new Empregador();
      empregador.setNumeroCei(entity.getNumeroCei());
      empregador.setCadastroUnico(new CadastroUnico());
      empregador.getCadastroUnico().setCpfCnpj(entity.getCadastroUnico().getCpfCnpj());
      
      empregador = this.get(session, empregador, new String[] { "cadastroUnico" }, null);
      
//      CadastroUnico cadastroUnico = new CadastroUnico();
//      cadastroUnico.set
//      cadastroUnico.setCpfCnpj(entity.getCadastroUnico().getCpfCnpj());
//      
//      cadastroUnico = CadastroUnicoService.getInstancia().get(cadastroUnico, null, null);
      
      if(empregador != null)
      {
         if(empregador.getCadastroUnico().getTipoPessoa().equals("J"))
         {
            throw new AptareException("Este empregador já existe em nossa base de dados.");
         }
         else
         {
            throw new AptareException("Este CPF já existe em nossa base de dados.");
         }
      }
   }
   
   @Override
   public Empregador alterar(Session session, Empregador empregador) throws AptareException
   {
      this.validarAlterar(session, empregador);
      
      CadastroUnico cadastroUnico = empregador.getCadastroUnico();
      empregador.setCadastroUnico(null);

      cadastroUnico.setAuditoria(empregador.getAuditoria());
      cadastroUnico = CadastroUnicoService.getInstancia().alterarSemValidacao(session, cadastroUnico);
      //empregador.setCodigoCadastroUnico(cadastroUnico.getCodigo());

      session.flush();
      
      session.merge(empregador);
      
      empregador.setCadastroUnico(cadastroUnico);
         
      return empregador;
   }
   
   @Override
   protected void validarAlterar(Session session, Empregador empregador) throws AptareException
   {
      if(empregador.getCadastroUnico() != null 
            && empregador.getCadastroUnico().getCpfCnpj() != null
            && empregador.getCadastroUnico().getCpfCnpj().intValue() > 0)
      {
         CadastroUnico cadastroUnico = new CadastroUnico();
         cadastroUnico.setCpfCnpj(empregador.getCadastroUnico().getCpfCnpj());
         
         cadastroUnico = CadastroUnicoService.getInstancia().get(session, cadastroUnico, null, null);
         
         if(cadastroUnico != null
               && cadastroUnico.getCodigo() != null
               && cadastroUnico.getCodigo().intValue() != empregador.getCodigoCadastroUnico().intValue()) 
         {
            if(cadastroUnico.getTipoPessoa().equals("J"))
            {
               throw new AptareException("Este empregador já existe em nossa base de dados.");
            }
            else
            {
               throw new AptareException("Este CPF já existe em nossa base de dados.");
            }
         }
      }
      else 
      {
         if(empregador.getNumeroCei() != null && empregador.getNumeroCei().intValue() > 0)
         {
            Empregador objEmp = new Empregador();
            objEmp.setNumeroCei(empregador.getNumeroCei());
            
            objEmp = this.get(session, objEmp, null, null);
            
            if(objEmp != null
                  && objEmp.getCodigo() != null
                  && objEmp.getCodigo().intValue() != empregador.getCodigo().intValue())
            {
               throw new AptareException("Este empregador já existe em nossa base de dados.");
            }
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
