package br.com.aptare.cefit.espaco.service;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.aptare.cefit.espaco.entity.EspacoItemEspaco;
import br.com.aptare.fda.crud.service.AptareService;
import br.com.aptare.fda.exception.AptareException;
import br.com.aptare.fda.exception.TratamentoPadraoErro;

public class EspacoItemEspacoService extends AptareService<EspacoItemEspaco>
{
   private static EspacoItemEspacoService instancia;

   public static EspacoItemEspacoService getInstancia()
   {
      if (instancia == null)
      {
         instancia = new EspacoItemEspacoService();
      }
      return instancia;
   }

   private EspacoItemEspacoService()
   {
   }
   
   public void atualizarListaEspacoItemEspaco(List<EspacoItemEspaco> lista, Long codigoEspaco) throws AptareException
   {
       Session session = getSession();
       session.setFlushMode(FlushMode.COMMIT);
       Transaction tx = session.beginTransaction();
       
       try
       {
           this.atualizarListaEspacoItemEspaco(session, lista, codigoEspaco);
           tx.commit();
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
   
   

   public void atualizarListaEspacoItemEspaco(Session session, List<EspacoItemEspaco> lista, Long codigoEspaco) throws AptareException
   {
      if(lista != null
            && lista.size() > 0)
      {
         // DELETA OS REGISTROS EXISTENTES
         EspacoItemEspaco espacoItemEspaco = new EspacoItemEspaco();
         espacoItemEspaco.setCodigoEspaco(codigoEspaco);
         List<EspacoItemEspaco> listaRemove = this.pesquisar(session, espacoItemEspaco, null, null);

         for (EspacoItemEspaco objRemove : listaRemove)
         {
            session.delete(objRemove);
         }

         session.flush();
         
         // ADICIONA OS NOVOS REGISTROS
         for (EspacoItemEspaco objInsert : lista)
         {
            objInsert.setEspaco(null);
            objInsert.setCodigoEspaco(codigoEspaco);
            session.save(objInsert);
         }
      }
   }
}
