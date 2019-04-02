package br.com.aptare.cefit.trabalhador.service;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.aptare.cefit.trabalhador.entity.TrabalhadorDeficiencia;
import br.com.aptare.fda.crud.service.AptareService;
import br.com.aptare.fda.exception.AptareException;
import br.com.aptare.fda.exception.TratamentoPadraoErro;

public class TrabalhadorDeficienciaService extends AptareService<TrabalhadorDeficiencia>
{

   private static TrabalhadorDeficienciaService instancia;

   public static TrabalhadorDeficienciaService getInstancia()
   {
      if (instancia == null)
      {
         instancia = new TrabalhadorDeficienciaService();
      }
      return instancia;
   }

   private TrabalhadorDeficienciaService()
   {
   }
   
   public void atualizarListaDeficiencia(List<TrabalhadorDeficiencia> lista, Long codigoTrabalhador) throws AptareException
   {
       Session session = getSession();
       session.setFlushMode(FlushMode.COMMIT);
       Transaction tx = session.beginTransaction();
       
       try
       {
           this.atualizarListaDeficiencia(session, lista, codigoTrabalhador);
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

   public void atualizarListaDeficiencia(Session session, List<TrabalhadorDeficiencia> lista, Long codigoTrabalhador) throws AptareException
   {
      if(lista != null
            && lista.size() > 0)
      {
         // DELETA OS REGISTROS EXISTENTES
         TrabalhadorDeficiencia trabalhadorDeficiencia = new TrabalhadorDeficiencia();
         trabalhadorDeficiencia.setCodigoTrabalhador(codigoTrabalhador);
         List<TrabalhadorDeficiencia> listaRemove = this.pesquisar(session, trabalhadorDeficiencia, null, null);

         for (TrabalhadorDeficiencia objRemove : listaRemove)
         {
            session.delete(objRemove);
         }

         session.flush();
         
         // ADICIONA OS NOVOS REGISTROS
         for (TrabalhadorDeficiencia objInsert : lista)
         {
            objInsert.setCodigoTrabalhador(codigoTrabalhador);
            session.save(objInsert);
         }
      }
   }

}
