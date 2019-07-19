package br.com.aptare.cefit.trabalhador.service;

import br.com.aptare.cefit.trabalhador.entity.Trabalhador;
import br.com.aptare.cefit.trabalhador.entity.TrabalhadorPresenca;
import br.com.aptare.fda.crud.service.AptareService;
import br.com.aptare.fda.exception.AptareException;
import br.com.aptare.fda.exception.TratamentoPadraoErro;
import br.com.aptare.fda.hibernate.CatalogoRestricoes;
import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class TrabalhadorPresencaService extends AptareService<TrabalhadorPresenca>
{

   private static TrabalhadorPresencaService instancia;

   public static TrabalhadorPresencaService getInstancia()
   {
      if (instancia == null)

      {
         instancia = new TrabalhadorPresencaService();
      }
      return instancia;
   }

   private TrabalhadorPresencaService()
   {
      adicionarFiltro("dataPresenca", CatalogoRestricoes.MAIOR_IGUAL, "filtro.dataInicio");
      adicionarFiltro("dataPresenca", CatalogoRestricoes.MENOR_IGUAL, "filtro.dataFim");
   }

   public Trabalhador listarPresencas(TrabalhadorPresenca entity) throws AptareException
   {
      Session session = getSession();
      session.setFlushMode(FlushMode.COMMIT);
      Transaction tx = session.beginTransaction();

      try
      {
         Trabalhador retorno = this.listarPresencas(session, entity);
         tx.commit();
         return retorno;
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

   private Trabalhador listarPresencas(Session session, TrabalhadorPresenca entity) throws AptareException
   {

      List<TrabalhadorPresenca> listaTrabalhadorPresenca = this.pesquisar(session, entity, null, null);

      Trabalhador trabalhador = new Trabalhador();
      trabalhador.setCodigo(entity.getCodigoTrabalhador());

      trabalhador.setListaTrabalhadorPresenca(new HashSet<TrabalhadorPresenca>(listaTrabalhadorPresenca));

      return trabalhador;
   }
   
   public Long[] retornarCodigoPresenca(Date data) throws AptareException
   {
      Session session = getSession();
      session.setFlushMode(FlushMode.COMMIT);

      try
      {
         return this.retornarCodigoPresenca(session, data);
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
   public Long[] retornarCodigoPresenca(Session session, Date data) throws AptareException
   {
      Criteria criteria = session.createCriteria(TrabalhadorPresenca.class);

      ProjectionList projection = Projections.projectionList();
      projection.add(Projections.distinct(Projections.groupProperty("codigoTrabalhador")));
      
      criteria.add(Restrictions.eq("dataPresenca", data));
      criteria.add(Restrictions.eq("flagAtivoPresenca", "S"));

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
