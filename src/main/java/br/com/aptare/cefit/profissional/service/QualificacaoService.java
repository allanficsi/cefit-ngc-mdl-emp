package br.com.aptare.cefit.profissional.service;

import java.util.HashMap;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.aptare.cefit.profissional.entity.Qualificacao;
import br.com.aptare.fda.crud.service.AptareService;
import br.com.aptare.fda.exception.AptareException;
import br.com.aptare.fda.exception.TratamentoPadraoErro;
import br.com.aptare.fda.hibernate.CatalogoRestricoes;
import br.com.aptare.seguranca.entidade.Auditoria;

public class QualificacaoService extends AptareService<Qualificacao>
{

   private static QualificacaoService instancia;

   public static QualificacaoService getInstancia()
   {
      if (instancia == null)
      {
         instancia = new QualificacaoService();
      }
      return instancia;
   }

   private QualificacaoService()
   {
      adicionarFiltro("descricao", CatalogoRestricoes.IGUAL, "filtro.descricao");
   }
   
   @Override
   protected void validarInserir(Session session, Qualificacao entity) throws AptareException
   {
      Qualificacao qualificacao = new Qualificacao();
      qualificacao.setFiltro(new HashMap<Object, String>());
      qualificacao.getFiltro().put("descricao", entity.getDescricao());
      qualificacao.setFlagAtivo("S");
      
      qualificacao = this.get(session, qualificacao, null, null);
      
      if(qualificacao != null && !entity.getDescricao().equals(qualificacao.getDescricao()))
      {
         throw new AptareException("Esta Qualificação já existe em nossa base de dados.");
      }
   }

   @Override
   protected void validarAlterar(Session session, Qualificacao entity) throws AptareException
   {
      Qualificacao qualificacao = new Qualificacao();
      qualificacao.setFiltro(new HashMap<Object, String>());
      qualificacao.getFiltro().put("descricao", entity.getDescricao());
      qualificacao.setFlagAtivo("S");
      
      qualificacao = this.get(session, qualificacao, null, null);
      
      if(qualificacao != null 
            && !entity.getDescricao().equals(qualificacao.getDescricao())
            && qualificacao.getCodigo().longValue() != entity.getCodigo().longValue())
      {
         throw new AptareException("Esta Qualificação já existe em nossa base de dados.");
      }
   }
   
   public Qualificacao ativarInativar(Qualificacao entity) throws AptareException
   {
       Session session = getSession();
       session.setFlushMode(FlushMode.COMMIT);
       Transaction tx = session.beginTransaction();
       
       try
       {
           Qualificacao retorno = this.ativarInativar(session, entity);
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

   public Qualificacao ativarInativar(Session session, Qualificacao entity) throws AptareException
   {
      // Get cargo somente com o codigo
      Qualificacao qualificacao = new Qualificacao();
      qualificacao.setCodigo(entity.getCodigo());
      
      qualificacao = this.get(session, qualificacao, null, null);
      
      qualificacao.setFlagAtivo(entity.getFlagAtivo());
      qualificacao.setAuditoria(new Auditoria());
      qualificacao.getAuditoria().setDataAlteracao(entity.getAuditoria().getDataAlteracao());
      qualificacao.getAuditoria().setCodigoUsuarioAlteracao(entity.getAuditoria().getCodigoUsuarioAlteracao());
      
      session.merge(qualificacao);
      
      return qualificacao;
   }

}
