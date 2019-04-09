package br.com.aptare.cefit.acao.service;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.aptare.cefit.acao.entity.Agenda;
import br.com.aptare.fda.crud.service.AptareService;
import br.com.aptare.fda.exception.AptareException;
import br.com.aptare.fda.exception.TratamentoPadraoErro;

public class AgendaService extends AptareService<Agenda>
{

   private static AgendaService instancia;

   public static AgendaService getInstancia()
   {
      if (instancia == null)
      {
         instancia = new AgendaService();
      }
      return instancia;
   }

   private AgendaService()
   {
   }
   
   public void atualizarAgenda(List<Agenda> lista, Long codigoAcao) throws AptareException
   {
       Session session = getSession();
       session.setFlushMode(FlushMode.COMMIT);
       Transaction tx = session.beginTransaction();
       
       try
       {
           this.atualizarAgenda(session, lista, codigoAcao);
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

   public void atualizarAgenda(Session session, List<Agenda> lista, Long codigoAcao) throws AptareException
   {
      if(lista != null
            && lista.size() > 0)
      {
         // DELETA OS REGISTROS EXISTENTES
         Agenda agenda = new Agenda();
         agenda.setCodigoAcao(codigoAcao);
         List<Agenda> listaRemove = this.pesquisar(session, agenda, null, null);

         for (Agenda objRemove : listaRemove)
         {
            session.delete(objRemove);
         }

         session.flush();
         
         // ADICIONA OS NOVOS REGISTROS
         for (Agenda objInsert : lista)
         {
            objInsert.setCodigoAcao(codigoAcao);
            session.save(objInsert);
         }
      }
   }
}
