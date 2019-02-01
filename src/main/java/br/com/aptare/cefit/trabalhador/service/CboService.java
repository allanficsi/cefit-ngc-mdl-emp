package br.com.aptare.cefit.trabalhador.service;

import br.com.aptare.cefit.trabalhador.entity.Cbo;
import br.com.aptare.fda.crud.service.AptareService;

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
   }

}
