package br.com.aptare.cefit.painelEletronico.service;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.aptare.cefit.painelEletronico.entity.TipoSenha;
import br.com.aptare.fda.crud.service.AptareService;
import br.com.aptare.fda.exception.AptareException;
import br.com.aptare.fda.exception.TratamentoPadraoErro;
import br.com.aptare.seguranca.entidade.Auditoria;

public class TipoSenhaService extends AptareService<TipoSenha>
{

   private static TipoSenhaService instancia;

   public static TipoSenhaService getInstancia()
   {
      if (instancia == null)
      {
         instancia = new TipoSenhaService();
      }
      return instancia;
   }

   public TipoSenha ativarInativar(TipoSenha entity) throws AptareException
   {
      Session session = getSession();
      session.setFlushMode(FlushMode.COMMIT);
      Transaction tx = session.beginTransaction();

      try
      {
         TipoSenha retorno = this.ativarInativar(session, entity);
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

   public TipoSenha ativarInativar(Session session, TipoSenha entity) throws AptareException
   {
      // Get tipoSenha somente com o codigo
      TipoSenha tipoSenha = new TipoSenha();
      tipoSenha.setCodigo(entity.getCodigo());

      tipoSenha = this.get(session, tipoSenha, null, null);

      tipoSenha.setFlagAtivo(entity.getFlagAtivo());
      tipoSenha.setAuditoria(new Auditoria());
      tipoSenha.getAuditoria().setDataAlteracao(entity.getAuditoria().getDataAlteracao());
      tipoSenha.getAuditoria().setCodigoUsuarioAlteracao(entity.getAuditoria().getCodigoUsuarioAlteracao());

      session.merge(tipoSenha);

      return tipoSenha;
   }
}
