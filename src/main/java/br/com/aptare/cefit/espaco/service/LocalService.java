package br.com.aptare.cefit.espaco.service;

import java.util.HashMap;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.aptare.cefit.espaco.entity.Local;
import br.com.aptare.fda.crud.service.AptareService;
import br.com.aptare.fda.exception.AptareException;
import br.com.aptare.fda.exception.TratamentoPadraoErro;
import br.com.aptare.fda.hibernate.CatalogoRestricoes;
import br.com.aptare.seguranca.entidade.Auditoria;

public class LocalService extends AptareService<Local>
{
   private static LocalService instancia;

   public static LocalService getInstancia()
   {
      if (instancia == null)
      {
         instancia = new LocalService();
      }
      return instancia;
   }

   private LocalService()
   {
      adicionarFiltro("nome", CatalogoRestricoes.IGUAL, "filtro.nome");      
   }
   
   @Override
   protected void validarInserir(Session session, Local entity) throws AptareException
   {
      Local localidade = new Local();
      localidade.setFiltro(new HashMap<Object, String>());
      localidade.getFiltro().put("nome", entity.getNome());
      localidade.setFlagAtivo("S");
      
      localidade = this.get(session, localidade, null, null);
      
      if(localidade != null)
      {
         throw new AptareException("Esta Localidade já existe em nossa base de dados.");
      }
   }

   @Override
   protected void validarAlterar(Session session, Local entity) throws AptareException
   {
      Local localidade = new Local();
      localidade.setFiltro(new HashMap<Object, String>());
      localidade.getFiltro().put("nome", entity.getNome());
      localidade.setFlagAtivo("S");
      
      localidade = this.get(session, localidade, null, null);
      
      if(localidade != null 
            && localidade.getCodigo().longValue() != entity.getCodigo().longValue())
      {
         throw new AptareException("Esta Localidade já existe em nossa base de dados.");
      }
   }
   
   public Local ativarInativar(Local entity) throws AptareException
   {
       Session session = getSession();
       session.setFlushMode(FlushMode.COMMIT);
       Transaction tx = session.beginTransaction();
       
       try
       {
          Local retorno = this.ativarInativar(session, entity);
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

   public Local ativarInativar(Session session, Local entity) throws AptareException
   {
      // Get cargo somente com o codigo
      Local localidade = new Local();
      localidade.setCodigo(entity.getCodigo());
      
      localidade = this.get(session, localidade, null, null);
      
      localidade.setFlagAtivo(entity.getFlagAtivo());
      localidade.setAuditoria(new Auditoria());
      localidade.getAuditoria().setDataAlteracao(entity.getAuditoria().getDataAlteracao());
      localidade.getAuditoria().setCodigoUsuarioAlteracao(entity.getAuditoria().getCodigoUsuarioAlteracao());
      
      session.merge(localidade);
      
      return localidade;
   }
   
}
