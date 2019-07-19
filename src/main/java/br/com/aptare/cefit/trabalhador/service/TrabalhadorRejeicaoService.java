package br.com.aptare.cefit.trabalhador.service;


import br.com.aptare.cefit.trabalhador.entity.Trabalhador;
import br.com.aptare.cefit.trabalhador.entity.TrabalhadorRejeicao;
import br.com.aptare.fda.crud.service.AptareService;
import br.com.aptare.fda.exception.AptareException;
import br.com.aptare.fda.exception.TratamentoPadraoErro;
import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class TrabalhadorRejeicaoService extends AptareService<TrabalhadorRejeicao> {

    private static TrabalhadorRejeicaoService instancia;

    public static TrabalhadorRejeicaoService getInstancia()
    {
        if (instancia == null)

        {
            instancia = new TrabalhadorRejeicaoService();
        }
        return instancia;
    }


    public Trabalhador inserir(Trabalhador trabalhador) throws AptareException {

        for (TrabalhadorRejeicao trabalhadorRejeicao : trabalhador.getListaTrabalhadorRejeicao()) {
            super.inserir(trabalhadorRejeicao);
        }

        return trabalhador;
    }
    
    public Long[] retornarCodigoRejeicao(Long codigoEmpregador) throws AptareException
    {
       Session session = getSession();
       session.setFlushMode(FlushMode.COMMIT);

       try
       {
          return this.retornarCodigoRejeicao(session, codigoEmpregador);
       }
       catch (Exception ae)
       {
          throw TratamentoPadraoErro.getInstancia().catchHBConsultaSession(ae);
       }
       finally
       {
          session.close();
       }
    }

    @SuppressWarnings("unchecked")
    public Long[] retornarCodigoRejeicao(Session session, Long codigoEmpregador) throws AptareException
    {
       Criteria criteria = session.createCriteria(TrabalhadorRejeicao.class);

       ProjectionList projection = Projections.projectionList();
       projection.add(Projections.distinct(Projections.groupProperty("codigoTrabalhador")));
       
       criteria.add(Restrictions.eq("codigoEmpregador", codigoEmpregador));
       criteria.add(Restrictions.eq("flagAtivo", "S"));

       criteria.setProjection(projection);

       List<Long> resultado = criteria.list();
       Long[] retorno = null;
       
       if (resultado != null)
       {
          retorno = new Long[resultado.size()];
          
          for (int i = 0; i < resultado.size(); i++)
          {
             retorno[i] = resultado.get(i);
          }
       }
       
       if(retorno != null && retorno.length <= 0)
       {
          retorno = null;
       }

       return retorno;
    }
}
