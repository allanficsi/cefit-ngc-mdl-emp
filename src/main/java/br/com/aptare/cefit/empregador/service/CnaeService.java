package br.com.aptare.cefit.empregador.service;

import br.com.aptare.cefit.empregador.entity.Cnae;
import br.com.aptare.fda.crud.service.AptareService;

public class CnaeService extends AptareService<Cnae>
{

   private static CnaeService instancia;

   public static CnaeService getInstancia()
   {
      if (instancia == null)
      {
         instancia = new CnaeService();
      }
      return instancia;
   }

   private CnaeService()
   {
   }

}
