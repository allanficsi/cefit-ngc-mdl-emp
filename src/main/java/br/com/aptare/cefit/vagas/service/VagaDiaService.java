package br.com.aptare.cefit.vagas.service;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.aptare.cefit.vagas.entity.VagaDia;
import br.com.aptare.fda.crud.service.AptareService;
import br.com.aptare.fda.exception.AptareException;
import br.com.aptare.fda.exception.TratamentoPadraoErro;

public class VagaDiaService extends AptareService<VagaDia>
{
    private static VagaDiaService instancia;

    public static VagaDiaService getInstancia()
    {
        if (instancia == null)
        {
            instancia = new VagaDiaService();
        }
        return instancia;
    }

    private VagaDiaService(){}

    public void atualizarListaVagaDia(List<VagaDia> lista, Long codigoVaga) throws AptareException
    {
        Session session = getSession();
        session.setFlushMode(FlushMode.COMMIT);
        Transaction tx = session.beginTransaction();

        try
        {
            this.atualizarListaVagaDia(session, lista, codigoVaga);
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

    public void atualizarListaVagaDia(Session session, List<VagaDia> lista, Long codigoVaga) throws AptareException
    {
        if(lista != null
                && lista.size() > 0)
        {
            // DELETA OS REGISTROS EXISTENTES
            VagaDia vagaDia = new VagaDia();
            vagaDia.setCodigoVaga(codigoVaga);
            List<VagaDia> listaRemove = this.pesquisar(session, vagaDia, null, null);

            for (VagaDia objRemove : listaRemove)
            {
                session.delete(objRemove);
            }

            //super.sincronizarLimpar(session);
            //session.flush();

            // ADICIONA OS NOVOS REGISTROS
            for (VagaDia objInsert : lista)
            {
                objInsert.setCodigoVaga(codigoVaga);
                session.save(objInsert);
                session.flush();
            }
        }
    }

}
