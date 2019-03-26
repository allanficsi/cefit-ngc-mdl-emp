package br.com.aptare.cefit.profissional.service;

import java.util.Date;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.aptare.cadastroUnico.entidade.CadastroUnico;
import br.com.aptare.cadastroUnico.servico.CadastroUnicoService;
import br.com.aptare.cefit.profissional.entity.Profissional;
import br.com.aptare.cefit.profissional.entity.ProfissionalQualificacao;
import br.com.aptare.fda.crud.service.AptareService;
import br.com.aptare.fda.exception.AptareException;
import br.com.aptare.fda.exception.TratamentoPadraoErro;
import br.com.aptare.fda.hibernate.CatalogoRestricoes;

public class ProfissionalService extends AptareService<Profissional>
{
   private static ProfissionalService instancia;
   
   public static int JOIN_CADASTRO_UNICO = 1;
   
   
   public static int SITUACAO_PENDENTE = 1;
   public static int SITUACAO_ATIVA = 2;
   public static int SITUACAO_INATIVA = 3;

   public static ProfissionalService getInstancia()
   {
      if (instancia == null)
      {
         instancia = new ProfissionalService();
      }
      return instancia;
   }

   private ProfissionalService()
   {
      adicionarFiltro("cadastroUnico.nome", CatalogoRestricoes.FAZ_PARTE_SEM_ACENTO, "cadastroUnico.nome");
   }
   
   @Override
   public Profissional inserir(Session session, Profissional entity) throws AptareException
   {
      this.validarInserir(session, entity);
      
      // INSERINDO CADASTRO UNICO
      CadastroUnico cadastroUnico = entity.getCadastroUnico();
      
      if(cadastroUnico.getCodigo() != null)
      {
         cadastroUnico = CadastroUnicoService.getInstancia().alterar(session, cadastroUnico);
      }
      else 
      {
         cadastroUnico = CadastroUnicoService.getInstancia().inserir(session, cadastroUnico);
      }
      
      session.flush();
      
      //INSERINDO TRABALHADOR
      entity.setCodigoCadastroUnico(cadastroUnico.getCodigo());
      session.save(entity);
      
      //INSERINDO QUALIFICACOES
      if(entity.getListaProfissionalQualificacao() != null
            && entity.getListaProfissionalQualificacao().size() > 0)
      {
         for (ProfissionalQualificacao profissionalQualificacao : entity.getListaProfissionalQualificacao())
         {
            profissionalQualificacao.setCodigoProfissional(entity.getCodigo());
            ProfissionalQualificacaoService.getInstancia().inserir(session, profissionalQualificacao);
         }
      }
      
      return entity;
   }
   
   @Override
   protected void validarInserir(Session session, Profissional entity) throws AptareException
   {
      if(entity.getCodigoCadastroUnico() != null) 
      {
         Profissional profissional = new Profissional();
         profissional.setCodigoCadastroUnico(entity.getCodigoCadastroUnico());
         
         profissional = this.get(session, profissional, null, null);
         
         if(profissional != null)
         {
            throw new AptareException("Este profissional já existe em nossa base de dados.");
         }
      }
   }
   
   @Override
   public Profissional alterar(Session session, Profissional entity) throws AptareException
   {
      this.validarAlterar(session, entity);
      
      CadastroUnico cadastroUnico = entity.getCadastroUnico();
      cadastroUnico = CadastroUnicoService.getInstancia().alterar(session, cadastroUnico);
      session.flush();
      
      session.update(entity);
      
      return entity;
   }
   
   @Override
   protected void validarAlterar(Session session, Profissional entity) throws AptareException
   {
      CadastroUnico cadastroUnico = new CadastroUnico();
      cadastroUnico.setCpfCnpj(entity.getCadastroUnico().getCpfCnpj());
      cadastroUnico.setTipoPessoa("F");
      
      cadastroUnico = CadastroUnicoService.getInstancia().get(cadastroUnico, null, null);
      
      if(cadastroUnico != null
            && cadastroUnico.getCodigo().intValue() != entity.getCodigoCadastroUnico().intValue())
      {
         throw new AptareException("Este CPF já existe em nossa base de dados.");
      }
   }
   
   public Profissional ativarInativar(Profissional entity) throws AptareException
   {
       Session session = getSession();
       session.setFlushMode(FlushMode.COMMIT);
       Transaction tx = session.beginTransaction();
       try
       {
           Profissional retorno = this.ativarInativar(session, entity);
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

   public Profissional ativarInativar(Session session, Profissional profissional) throws AptareException
   {
      Profissional objInativar = new Profissional();
      objInativar.setCodigo(profissional.getCodigo());
      
      objInativar = this.get(objInativar, null, null);
      
      if(objInativar != null) 
      {
         objInativar.setFlagAtivo("S");
         objInativar.getAuditoria().setDataAlteracao(new Date());
         objInativar.getAuditoria().setCodigoUsuarioAlteracao(profissional.getAuditoria().getCodigoUsuarioAlteracao());
         
         session.update(objInativar);
      }
      
      return objInativar;
   }

}
