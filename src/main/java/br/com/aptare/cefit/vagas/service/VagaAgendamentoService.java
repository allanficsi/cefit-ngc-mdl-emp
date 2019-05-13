package br.com.aptare.cefit.vagas.service;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.aptare.cefit.vagas.entity.VagaAgendamento;
import br.com.aptare.fda.crud.service.AptareService;
import br.com.aptare.fda.exception.AptareException;
import br.com.aptare.fda.exception.TratamentoPadraoErro;

public class VagaAgendamentoService extends AptareService<VagaAgendamento>
{
   private static VagaAgendamentoService instancia;
   
   public static VagaAgendamentoService getInstancia()
   {
      if (instancia == null)
      {
         instancia = new VagaAgendamentoService();
      }
      return instancia;
   }

   private VagaAgendamentoService(){}

   public void atualizarListaVagaAgendamento(List<VagaAgendamento> lista, Long codigoVaga) throws AptareException
   {
       Session session = getSession();
       session.setFlushMode(FlushMode.COMMIT);
       Transaction tx = session.beginTransaction();
       
       try
       {
           this.atualizarListaVagaAgendamento(session, lista, codigoVaga);
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

   public void atualizarListaVagaAgendamento(Session session, List<VagaAgendamento> lista, Long codigoVaga) throws AptareException
   {
      if(lista != null
            && lista.size() > 0)
      {
         // DELETA OS REGISTROS EXISTENTES
         VagaAgendamento vagaAgendamento = new VagaAgendamento();
         vagaAgendamento.setCodigoVaga(codigoVaga);
         List<VagaAgendamento> listaRemove = this.pesquisar(session, vagaAgendamento, null, null);

         for (VagaAgendamento objRemove : listaRemove)
         {
            session.delete(objRemove);
         }

         session.flush();
         
         // ADICIONA OS NOVOS REGISTROS
         for (VagaAgendamento objInsert : lista)
         {
            objInsert.setCodigoVaga(codigoVaga);
            session.save(objInsert);
            session.flush();
         }
      }
   }
   
}
