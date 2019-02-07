package br.com.aptare.cefit.profissional.service;

import java.util.HashMap;

import org.hibernate.Session;

import br.com.aptare.cefit.profissional.entity.Qualificacao;
import br.com.aptare.fda.crud.service.AptareService;
import br.com.aptare.fda.exception.AptareException;
import br.com.aptare.fda.hibernate.CatalogoRestricoes;

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

}
