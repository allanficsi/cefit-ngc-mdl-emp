package br.com.aptare.cefit.acao.service;

import java.util.HashMap;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.aptare.cefit.acao.entity.Acao;
import br.com.aptare.fda.crud.service.AptareService;
import br.com.aptare.fda.exception.AptareException;
import br.com.aptare.fda.exception.TratamentoPadraoErro;
import br.com.aptare.fda.hibernate.CatalogoRestricoes;
import br.com.aptare.seguranca.entidade.Auditoria;

public class AcaoService extends AptareService<Acao>
{

   private static AcaoService instancia;

   public static AcaoService getInstancia()
   {
      if (instancia == null)
      {
         instancia = new AcaoService();
      }
      return instancia;
   }

   private AcaoService()
   {
      adicionarFiltro("descricao", CatalogoRestricoes.IGUAL, "filtro.descricao");
   }
   
   @Override
   protected void validarInserir(Session session, Acao entity) throws AptareException
   {
      Acao acao = new Acao();
      acao.setFiltro(new HashMap<Object, String>());
      acao.getFiltro().put("descricao", entity.getNome());
      
      acao = this.get(session, acao, null, null);
      
      if(acao != null && !entity.getNome().equals(acao.getNome()))
      {
         throw new AptareException("Esta Ação já existe em nossa base de dados.");
      }
   }

   @Override
   protected void validarAlterar(Session session, Acao entity) throws AptareException
   {
      Acao acao = new Acao();
      acao.setFiltro(new HashMap<Object, String>());
      acao.getFiltro().put("descricao", entity.getNome());
      
      acao = this.get(session, acao, null, null);
      
      if(acao != null 
            && !entity.getNome().equals(acao.getNome())
            && acao.getCodigo().longValue() != entity.getCodigo().longValue())
      {
         throw new AptareException("Esta Ação já existe em nossa base de dados.");
      }
   }
   
   public Acao ativarInativar(Acao entity) throws AptareException
   {
       Session session = getSession();
       session.setFlushMode(FlushMode.COMMIT);
       Transaction tx = session.beginTransaction();
       
       try
       {
           Acao retorno = this.ativarInativar(session, entity);
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

   public Acao ativarInativar(Session session, Acao entity) throws AptareException
   {
      // Get tipoacao somente com o codigo
      Acao acao = new Acao();
      acao.setCodigo(entity.getCodigo());
      
      acao = this.get(session, acao, null, null);
      
      //acao.setFlagAtivo(entity.getFlagAtivo()); //setar para cancelado
      acao.setAuditoria(new Auditoria());
      acao.getAuditoria().setDataAlteracao(entity.getAuditoria().getDataAlteracao());
      acao.getAuditoria().setCodigoUsuarioAlteracao(entity.getAuditoria().getCodigoUsuarioAlteracao());
      
      session.merge(acao);
      
      return acao;
   }

}
