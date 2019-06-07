package br.com.aptare.cefit.painelEletronico.service;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.aptare.cefit.painelEletronico.entity.Guiche;
import br.com.aptare.fda.crud.service.AptareService;
import br.com.aptare.fda.exception.AptareException;
import br.com.aptare.fda.exception.TratamentoPadraoErro;
import br.com.aptare.seguranca.entidade.Auditoria;

public class GuicheService extends AptareService<Guiche>
{

   private static GuicheService instancia;

   public static GuicheService getInstancia()
   {
      if (instancia == null)
      {
         instancia = new GuicheService();
      }
      return instancia;
   }

   public Guiche ativarInativar(Guiche entity) throws AptareException
   {
      Session session = getSession();
      session.setFlushMode(FlushMode.COMMIT);
      Transaction tx = session.beginTransaction();

      try
      {
         Guiche retorno = this.ativarInativar(session, entity);
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

   public Guiche ativarInativar(Session session, Guiche entity) throws AptareException
   {
      // Get cargo somente com o codigo
      Guiche guiche = new Guiche();
      guiche.setCodigo(entity.getCodigo());

      guiche = this.get(session, guiche, null, null);

      guiche.setFlagAtivo(entity.getFlagAtivo());
      guiche.setAuditoria(new Auditoria());
      guiche.getAuditoria().setDataAlteracao(entity.getAuditoria().getDataAlteracao());
      guiche.getAuditoria().setCodigoUsuarioAlteracao(entity.getAuditoria().getCodigoUsuarioAlteracao());

      session.merge(guiche);

      return guiche;
   }
}
