package br.com.aptare.cefit.painelEletronico.service;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import br.com.aptare.cefit.painelEletronico.entity.Chamada;
import br.com.aptare.cefit.painelEletronico.entity.Senha;
import br.com.aptare.fda.crud.service.AptareService;
import br.com.aptare.fda.exception.AptareException;
import br.com.aptare.fda.exception.TratamentoPadraoErro;

public class ChamadaService extends AptareService<Chamada>
{
   private static ChamadaService instancia;
   
   private final int MAX_ULTIMAS_CHAMADAS = 5;

   public static ChamadaService getInstancia()
   {
      if (instancia == null)
      {
         instancia = new ChamadaService();
      }
      return instancia;
   }

   public Chamada retornarUltima() throws AptareException
   {
      Session session = getSession();
      session.setFlushMode(FlushMode.COMMIT);

      try
      {
         return this.retornarUltima(session);
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

   public Chamada retornarUltima(Session session) throws AptareException
   {
      Long codigo = null;

      Criteria criteria = session.createCriteria(Chamada.class);

      ProjectionList projection = Projections.projectionList();
      projection.add(Projections.max("codigo"));
      
      criteria.createAlias("senha", "senha", JoinType.INNER_JOIN);
      
      criteria.add(Restrictions.eq("senha.flagAtivo", true));
      criteria.add(Restrictions.eq("data", new Date()));

      criteria.setProjection(projection);

      Object resultado = criteria.uniqueResult();

      Chamada chamada = null;

      if (resultado != null)
      {
         codigo = Long.parseLong(resultado.toString());

         chamada = new Chamada();
         chamada.setCodigo(codigo);

         chamada = this.get(session, chamada, new String[] { "senha.tipoSenha", "guiche" }, null);
      }

      return chamada;
   }
   
   public Chamada retornarUltima(Long codigoTipoSenha) throws AptareException
   {
      Session session = getSession();
      session.setFlushMode(FlushMode.COMMIT);

      try
      {
         return this.retornarUltima(session, codigoTipoSenha);
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

   public Chamada retornarUltima(Session session, Long codigoTipoSenha) throws AptareException
   {
      Long codigo = null;

      Criteria criteria = session.createCriteria(Chamada.class);

      ProjectionList projection = Projections.projectionList();
      projection.add(Projections.max("codigo"));
      
      criteria.createAlias("senha", "senha", JoinType.INNER_JOIN);
      criteria.createAlias("senha.tipoSenha", "tipoSenha", JoinType.INNER_JOIN);
      criteria.createAlias("guiche", "guiche", JoinType.INNER_JOIN);
      
      criteria.add(Restrictions.eq("senha.codigoTipoSenha", codigoTipoSenha));
      criteria.add(Restrictions.eq("senha.flagAtivo", true));
      criteria.add(Restrictions.eq("data", new Date()));
      
      criteria.setProjection(projection);

      Object resultado = criteria.uniqueResult();

      Chamada chamada = null;

      if (resultado != null)
      {
         codigo = Long.parseLong(resultado.toString());

         chamada = new Chamada();
         chamada.setCodigo(codigo);

         chamada = this.get(session, chamada, new String[] { "senha.tipoSenha", "senha.guiche" }, null);
      }

      return chamada;
   }
   
   public Chamada retornarProxima(Long codigoTipoSenha) throws AptareException
   {
      Session session = getSession();
      session.setFlushMode(FlushMode.COMMIT);

      try
      {
         return this.retornarProxima(session, codigoTipoSenha);
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

   public Chamada retornarProxima(Session session, Long codigoTipoSenha) throws AptareException
   {
      Chamada chamada = this.retornarUltima(codigoTipoSenha);
      
      Criteria criteria = session.createCriteria(Senha.class);

      ProjectionList projection = Projections.projectionList();
      projection.add(Projections.min("codigo"));
      
      if(chamada != null)
      {
         criteria.add(Restrictions.gt("codigo", chamada.getCodigoSenha()));
      }
      
      criteria.add(Restrictions.eq("codigoTipoSenha", codigoTipoSenha));
      criteria.add(Restrictions.eq("flagAtivo", true));
      criteria.add(Restrictions.eq("data", new Date()));
      
      criteria.setProjection(projection);

      Object resultado = criteria.uniqueResult();
      Chamada retorno = null;
      
      if (resultado != null)
      {
         Long codigo = Long.parseLong(resultado.toString());
         
         Senha senha = new Senha();
         senha.setCodigo(codigo);

         senha = SenhaService.getInstancia().get(session, senha, null, null);
         
         if(senha != null)
         {
            retorno = new Chamada();
            retorno.setSenha(senha);
         }
      }
      
      return retorno;
   }
   
   public List<Chamada> listarUltimasChamadas() throws AptareException
   {
      Session session = getSession();
      session.setFlushMode(FlushMode.COMMIT);

      try
      {
         return this.listarUltimasChamadas(session);
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
   
   public List<Chamada> listarUltimasChamadas(Session session) throws AptareException
   {
      Chamada chamada = new Chamada();
      chamada.setSenha(new Senha());
      chamada.getSenha().setFlagAtivo(true);
      chamada.getSenha().setData(new Date());
      
      List<Chamada> lista = this.pesquisar(session, chamada, new String[] {"senha.tipoSenha", "guiche"}, new String[] {"codigo*"});
      
      return lista;
   }

   @Override
   protected Integer getNumeroMaximoRegistros()
   {
      return MAX_ULTIMAS_CHAMADAS;
   }
   
}
