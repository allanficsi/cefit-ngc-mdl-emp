package br.com.aptare.cefit.acao.service;

import br.com.aptare.cefit.acao.entity.AcaoProfissional;
import br.com.aptare.fda.crud.service.AptareService;

public class AcaoProfissionalService extends AptareService<AcaoProfissional>
{
   private static AcaoProfissionalService instancia;

   public static AcaoProfissionalService getInstancia()
   {
      if (instancia == null)
      {
         instancia = new AcaoProfissionalService();
      }
      return instancia;
   }

   private AcaoProfissionalService()
   {
   }
   
}
