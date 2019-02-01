package br.com.aptare.cefit.profissional.service;

import br.com.aptare.cefit.profissional.entity.Qualificacao;
import br.com.aptare.fda.crud.service.AptareService;

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
   }

}
