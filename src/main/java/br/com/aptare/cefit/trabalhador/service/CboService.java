package br.com.aptare.cefit.trabalhador.service;

import br.com.aptare.cefit.trabalhador.entity.Cbo;
import br.com.aptare.fda.crud.service.AptareService;
import br.com.aptare.fda.exception.AptareException;
import br.com.aptare.fda.exception.TratamentoPadraoErro;
import br.com.aptare.fda.hibernate.CatalogoRestricoes;
import br.com.aptare.seguranca.entidade.Auditoria;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashMap;

public class CboService extends AptareService<Cbo>
{

   private static CboService instancia;

   public static CboService getInstancia()
   {
      if (instancia == null)
      {
         instancia = new CboService();
      }
      return instancia;
   }

   private CboService()
   {
      adicionarFiltro("nome", CatalogoRestricoes.IGUAL, "filtro.nome");
   }

   @Override
   protected void validarInserir(Session session, Cbo entity) throws AptareException
   {
      Cbo cbo = new Cbo();
      cbo.setFiltro(new HashMap<Object, String>());
      cbo.getFiltro().put("nome", entity.getNome());
      cbo.setFlagAtivo("S");

      cbo = this.get(session, cbo, null, null);

      if (cbo != null)
      {
         throw new AptareException("Esta ocupação já existe em nossa base de dados.");
      }
   }

   @Override
   protected void validarAlterar(Session session, Cbo entity) throws AptareException
   {
      Cbo cbo = new Cbo();
      cbo.setFiltro(new HashMap<Object, String>());
      cbo.getFiltro().put("nome", entity.getNome());
      cbo.setFlagAtivo("S");

      cbo = this.get(session, cbo, null, null);

      if (cbo != null && cbo.getCodigo().longValue() != entity.getCodigo().longValue())
      {
         throw new AptareException("Esta ocupação já existe em nossa base de dados.");
      }
   }

   public Cbo ativarInativar(Cbo entity) throws AptareException
   {
      Session session = getSession();
      session.setFlushMode(FlushMode.COMMIT);
      Transaction tx = session.beginTransaction();

      try
      {
         Cbo retorno = this.ativarInativar(session, entity);
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

   public Cbo ativarInativar(Session session, Cbo entity) throws AptareException
   {
      // Get cargo somente com o codigo
      Cbo cbo = new Cbo();
      cbo.setCodigo(entity.getCodigo());

      cbo = this.get(session, cbo, null, null);

      cbo.setFlagAtivo(entity.getFlagAtivo());
      cbo.setAuditoria(new Auditoria());
      cbo.getAuditoria().setDataAlteracao(entity.getAuditoria().getDataAlteracao());
      cbo.getAuditoria().setCodigoUsuarioAlteracao(entity.getAuditoria().getCodigoUsuarioAlteracao());

      session.merge(cbo);

      return cbo;
   }
   
   @Override
   public Cbo alterar(Session session, Cbo entity) throws AptareException
   {
       validarAlterar(session, entity);
       session.merge(entity);
       return entity;
   }

}
