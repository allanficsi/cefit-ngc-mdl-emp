package br.com.aptare.cefit.profissional.service;

import br.com.aptare.cefit.profissional.entity.ProfissionalQualificacao;
import br.com.aptare.fda.crud.service.AptareService;

public class ProfissionalQualificacaoService extends AptareService<ProfissionalQualificacao>
{

   private static ProfissionalQualificacaoService instancia;

   public static ProfissionalQualificacaoService getInstancia()
   {
      if (instancia == null)
      {
         instancia = new ProfissionalQualificacaoService();
      }
      return instancia;
   }

   private ProfissionalQualificacaoService()
   {
   }

}
