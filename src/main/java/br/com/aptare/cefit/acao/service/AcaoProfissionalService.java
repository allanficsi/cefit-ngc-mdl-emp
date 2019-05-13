package br.com.aptare.cefit.acao.service;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.aptare.cefit.acao.entity.AcaoProfissional;
import br.com.aptare.fda.crud.service.AptareService;
import br.com.aptare.fda.exception.AptareException;
import br.com.aptare.fda.exception.TratamentoPadraoErro;

public class AcaoProfissionalService extends AptareService<AcaoProfissional>
{
   private static AcaoProfissionalService instancia;

   public static AcaoProfissionalService getInstancia()
   {
      if (instancia == null)
      {
         instancia = new AcaoProfissionalService();
      }
      return instancia;
   }

   private AcaoProfissionalService()
   {
   }
   
   public void atualizarListaAcaoProfissional(List<AcaoProfissional> lista, Long codigoAcao) throws AptareException
   {
       Session session = getSession();
       session.setFlushMode(FlushMode.COMMIT);
       Transaction tx = session.beginTransaction();
       
       try
       {
           this.atualizarListaAcaoProfissional(session, lista, codigoAcao);
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

   public void atualizarListaAcaoProfissional(Session session, List<AcaoProfissional> lista, Long codigoAcao) throws AptareException
   {
      if(lista != null
            && lista.size() > 0)
      {
         // DELETA OS REGISTROS EXISTENTES
         AcaoProfissional acaoProfissional = new AcaoProfissional();
         acaoProfissional.setCodigoAcao(codigoAcao);
         List<AcaoProfissional> listaRemove = this.pesquisar(session, acaoProfissional, null, null);

         for (AcaoProfissional objRemove : listaRemove)
         {
            session.delete(objRemove);
         }

         session.flush();
         
         // ADICIONA OS NOVOS REGISTROS
         for (AcaoProfissional objInsert : lista)
         {
            AcaoProfissional objAcaoProfissional = new AcaoProfissional();
            objAcaoProfissional.setCodigoAcao(codigoAcao);
            objAcaoProfissional.setCodigoPrf(objInsert.getProfissional().getCodigo());
            session.save(objAcaoProfissional);
            session.flush();
         }
      }
   }
   
}
