package br.com.aptare.cefit.vagas.service;

import br.com.aptare.cefit.vagas.entity.EncaminhamentoNaoAtendido;
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

public class EncaminhamentoNaoAtendidoService extends AptareService<EncaminhamentoNaoAtendido>
{
   private static EncaminhamentoNaoAtendidoService instancia;
   
   public static EncaminhamentoNaoAtendidoService getInstancia()
   {
      if (instancia == null)
      {
         instancia = new EncaminhamentoNaoAtendidoService();
      }
      return instancia;
   }

   private EncaminhamentoNaoAtendidoService()
   {
   }
   
   public Long[] retornarCodigoNaoAtendido(Long codigoVaga) throws AptareException
   {
      Session session = getSession();
      session.setFlushMode(FlushMode.COMMIT);

      try
      {
         return this.retornarCodigoNaoAtendido(session, codigoVaga);
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
   public Long[] retornarCodigoNaoAtendido(Session session, Long codigoVaga) throws AptareException
   {
      Criteria criteria = session.createCriteria(EncaminhamentoNaoAtendido.class);

      ProjectionList projection = Projections.projectionList();
      projection.add(Projections.distinct(Projections.groupProperty("codigoTrabalhador")));
      
      criteria.add(Restrictions.eq("codigoVaga", codigoVaga));
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
