package br.com.aptare.cefit.acao.service;

import java.util.HashMap;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.aptare.cefit.acao.entity.TipoAcao;
import br.com.aptare.fda.crud.service.AptareService;
import br.com.aptare.fda.exception.AptareException;
import br.com.aptare.fda.exception.TratamentoPadraoErro;
import br.com.aptare.fda.hibernate.CatalogoRestricoes;
import br.com.aptare.seguranca.entidade.Auditoria;

public class TipoAcaoService extends AptareService<TipoAcao>
{

   private static TipoAcaoService instancia;

   public static TipoAcaoService getInstancia()
   {
      if (instancia == null)
      {
         instancia = new TipoAcaoService();
      }
      return instancia;
   }

   private TipoAcaoService()
   {
      adicionarFiltro("descricao", CatalogoRestricoes.IGUAL, "filtro.descricao");
   }
   
   @Override
   protected void validarInserir(Session session, TipoAcao entity) throws AptareException
   {
      TipoAcao tipoAcao = new TipoAcao();
      tipoAcao.setFiltro(new HashMap<Object, String>());
      tipoAcao.getFiltro().put("descricao", entity.getDescricao());
      tipoAcao.setFlagAtivo("S");
      
      tipoAcao = this.get(session, tipoAcao, null, null);
      
      if(tipoAcao != null && !entity.getDescricao().equals(tipoAcao.getDescricao()))
      {
         throw new AptareException("Este Tipo de Ação já existe em nossa base de dados.");
      }
   }

   @Override
   protected void validarAlterar(Session session, TipoAcao entity) throws AptareException
   {
      TipoAcao tipoAcao = new TipoAcao();
      tipoAcao.setFiltro(new HashMap<Object, String>());
      tipoAcao.getFiltro().put("descricao", entity.getDescricao());
      tipoAcao.setFlagAtivo("S");
      
      tipoAcao = this.get(session, tipoAcao, null, null);
      
      if(tipoAcao != null 
            && !entity.getDescricao().equals(tipoAcao.getDescricao())
            && tipoAcao.getCodigo().longValue() != entity.getCodigo().longValue())
      {
         throw new AptareException("Este Tipo de Ação já existe em nossa base de dados.");
      }
   }
   
   public TipoAcao ativarInativar(TipoAcao entity) throws AptareException
   {
       Session session = getSession();
       session.setFlushMode(FlushMode.COMMIT);
       Transaction tx = session.beginTransaction();
       
       try
       {
           TipoAcao retorno = this.ativarInativar(session, entity);
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

   public TipoAcao ativarInativar(Session session, TipoAcao entity) throws AptareException
   {
      // Get tipoacao somente com o codigo
      TipoAcao tipoAcao = new TipoAcao();
      tipoAcao.setCodigo(entity.getCodigo());
      
      tipoAcao = this.get(session, tipoAcao, null, null);
      
      tipoAcao.setFlagAtivo(entity.getFlagAtivo());
      tipoAcao.setAuditoria(new Auditoria());
      tipoAcao.getAuditoria().setDataAlteracao(entity.getAuditoria().getDataAlteracao());
      tipoAcao.getAuditoria().setCodigoUsuarioAlteracao(entity.getAuditoria().getCodigoUsuarioAlteracao());
      
      session.merge(tipoAcao);
      
      return tipoAcao;
   }

}
