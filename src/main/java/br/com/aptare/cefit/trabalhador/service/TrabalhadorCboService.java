package br.com.aptare.cefit.trabalhador.service;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.aptare.cefit.trabalhador.entity.TrabalhadorCbo;
import br.com.aptare.fda.crud.service.AptareService;
import br.com.aptare.fda.exception.AptareException;
import br.com.aptare.fda.exception.TratamentoPadraoErro;

public class TrabalhadorCboService extends AptareService<TrabalhadorCbo>
{

   private static TrabalhadorCboService instancia;

   public static TrabalhadorCboService getInstancia()
   {
      if (instancia == null)
      {
         instancia = new TrabalhadorCboService();
      }
      return instancia;
   }

   private TrabalhadorCboService()
   {
   }
   
   public void atualizarListaCbo(List<TrabalhadorCbo> lista, Long codigoTrabalhador) throws AptareException
   {
       Session session = getSession();
       session.setFlushMode(FlushMode.COMMIT);
       Transaction tx = session.beginTransaction();
       
       try
       {
           this.atualizarListaCbo(session, lista, codigoTrabalhador);
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
   
   

   public void atualizarListaCbo(Session session, List<TrabalhadorCbo> lista, Long codigoTrabalhador) throws AptareException
   {
      if(lista != null
            && lista.size() > 0)
      {
         // DELETA OS REGISTROS EXISTENTES
         TrabalhadorCbo trabalhadorCbo = new TrabalhadorCbo();
         trabalhadorCbo.setCodigoTrabalhador(codigoTrabalhador);
         List<TrabalhadorCbo> listaRemove = TrabalhadorCboService.getInstancia().pesquisar(session, trabalhadorCbo, null, null);

         for (TrabalhadorCbo objRemove : listaRemove)
         {
            session.delete(objRemove);
         }

         session.flush();
         
         // ADICIONA OS NOVOS REGISTROS
         for (TrabalhadorCbo objInsert : lista)
         {
            objInsert.setCbo(null);
            objInsert.setCodigoTrabalhador(codigoTrabalhador);
            session.save(objInsert);
         }
      }
   }

}
