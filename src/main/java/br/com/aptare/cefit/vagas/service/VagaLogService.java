package br.com.aptare.cefit.vagas.service;

import br.com.aptare.cefit.vagas.entity.VagaLog;
import br.com.aptare.fda.crud.service.AptareService;

public class VagaLogService extends AptareService<VagaLog>
{

   private static VagaLogService instancia;

   public static VagaLogService getInstancia()
   {
      if (instancia == null)
      {
         instancia = new VagaLogService();
      }
      return instancia;
   }

   private VagaLogService()
   {
   }

}
