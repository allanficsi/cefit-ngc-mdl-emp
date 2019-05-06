package br.com.aptare.cefit.trabalhador.service;

import br.com.aptare.cefit.trabalhador.entity.TrabalhadorAgenda;
import br.com.aptare.fda.crud.service.AptareService;
import br.com.aptare.fda.crud.service.UtilService;
import br.com.aptare.fda.exception.AptareException;
import br.com.aptare.fda.exception.TratamentoPadraoErro;
import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.util.List;
import java.util.Map;

public class TrabalhadorAgendaService extends AptareService<TrabalhadorAgenda> {
    private static TrabalhadorAgendaService instancia;

    public static TrabalhadorAgendaService getInstancia() {
        if (instancia == null) {
            instancia = new TrabalhadorAgendaService();
        }
        return instancia;
    }

    private TrabalhadorAgendaService() {

    }
    public void atualizarListaCbo(List<TrabalhadorAgenda> lista, Long codigoTrabalhador) throws AptareException
    {
        Session session = getSession();
        session.setFlushMode(FlushMode.COMMIT);
        Transaction tx = session.beginTransaction();

        try
        {
            this.atualizarAgenda(session, lista, codigoTrabalhador);
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
    public void atualizarAgenda(Session session, List<TrabalhadorAgenda> lista, Long codigoTrabalhador) throws AptareException
    {
        if(lista != null
                && lista.size() > 0)
        {
            // DELETA OS REGISTROS EXISTENTES
            TrabalhadorAgenda trabalhadorAgenda = new TrabalhadorAgenda();
            trabalhadorAgenda.setCodigoTrabalhador(codigoTrabalhador);
            List<TrabalhadorAgenda> listaRemove = this.pesquisar(session, trabalhadorAgenda, null, null);

            for (TrabalhadorAgenda objRemove : listaRemove)
            {
                session.delete(objRemove);
            }

            session.flush();

            // ADICIONA OS NOVOS REGISTROS
            for (TrabalhadorAgenda objInsert : lista)
            {
                objInsert.setCodigoTrabalhador(codigoTrabalhador);
                session.save(objInsert);
            }
        }
    }


    @Override
    public List<TrabalhadorAgenda> pesquisar(Session session, TrabalhadorAgenda filter, String[] juncoes, String[] ordenacoes) throws AptareException {
        this.validarPesquisar(session, filter);
        Criteria criteria = this.setarCriteria(session);
        Map<String, String> juncoesAplicadas = UtilService.aplicarJuncoes(session, criteria, filter, juncoes);
        //UtilService.aplicarFiltrosPersistentes(criteria, filter, (String)null, juncoesAplicadas, (List)null, this.propriedades);
        this.aplicarFiltrosTransitorios(criteria, filter, juncoesAplicadas);
        UtilService.aplicarOrdenacao(criteria, filter, ordenacoes);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.setMaxResults(this.getNumeroMaximoRegistros());
        return criteria.list();
    }
    private Criteria setarCriteria(Session session) {
        ParameterizedTypeImpl type = (ParameterizedTypeImpl)this.getClass().getGenericSuperclass();
        Class<?> classeEntity = (Class)type.getActualTypeArguments()[0];
        Criteria criteria = session.createCriteria(classeEntity);
        return criteria;
    }
}
