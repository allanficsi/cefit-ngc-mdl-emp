package br.com.aptare.cefit.espaco.service;

import java.util.HashMap;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.aptare.cefit.espaco.entity.ItemEspaco;
import br.com.aptare.fda.crud.service.AptareService;
import br.com.aptare.fda.exception.AptareException;
import br.com.aptare.fda.exception.TratamentoPadraoErro;
import br.com.aptare.fda.hibernate.CatalogoRestricoes;
import br.com.aptare.seguranca.entidade.Auditoria;

public class ItemEspacoService extends AptareService<ItemEspaco>
{
   private static ItemEspacoService instancia;

   public static ItemEspacoService getInstancia()
   {
      if (instancia == null)
      {
         instancia = new ItemEspacoService();
      }
      return instancia;
   }

   private ItemEspacoService()
   {
      adicionarFiltro("descricao", CatalogoRestricoes.IGUAL, "filtro.descricao");      
   }
   
   @Override
   protected void validarInserir(Session session, ItemEspaco entity) throws AptareException
   {
      ItemEspaco itemEspaco = new ItemEspaco();
      itemEspaco.setFiltro(new HashMap<Object, String>());
      itemEspaco.getFiltro().put("descricao", entity.getDescricao());
      itemEspaco.setFlagAtivo("S");
      
      itemEspaco = this.get(session, itemEspaco, null, null);
      
      if(itemEspaco != null)
      {
         throw new AptareException("Este Cargo já existe em nossa base de dados.");
      }
   }

   @Override
   protected void validarAlterar(Session session, ItemEspaco entity) throws AptareException
   {
      ItemEspaco itemEspaco = new ItemEspaco();
      itemEspaco.setFiltro(new HashMap<Object, String>());
      itemEspaco.getFiltro().put("descricao", entity.getDescricao());
      itemEspaco.setFlagAtivo("S");
      
      itemEspaco = this.get(session, itemEspaco, null, null);
      
      if(itemEspaco != null 
            && itemEspaco.getCodigo().longValue() != entity.getCodigo().longValue())
      {
         throw new AptareException("Este Cargo já existe em nossa base de dados.");
      }
   }
   
   public ItemEspaco ativarInativar(ItemEspaco entity) throws AptareException
   {
       Session session = getSession();
       session.setFlushMode(FlushMode.COMMIT);
       Transaction tx = session.beginTransaction();
       
       try
       {
          ItemEspaco retorno = this.ativarInativar(session, entity);
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

   public ItemEspaco ativarInativar(Session session, ItemEspaco entity) throws AptareException
   {
      // Get cargo somente com o codigo
      ItemEspaco itemEspaco = new ItemEspaco();
      itemEspaco.setCodigo(entity.getCodigo());
      
      itemEspaco = this.get(session, itemEspaco, null, null);
      
      itemEspaco.setFlagAtivo(entity.getFlagAtivo());
      itemEspaco.setAuditoria(new Auditoria());
      itemEspaco.getAuditoria().setDataAlteracao(entity.getAuditoria().getDataAlteracao());
      itemEspaco.getAuditoria().setCodigoUsuarioAlteracao(entity.getAuditoria().getCodigoUsuarioAlteracao());
      
      session.merge(itemEspaco);
      
      return itemEspaco;
   }
   
}
