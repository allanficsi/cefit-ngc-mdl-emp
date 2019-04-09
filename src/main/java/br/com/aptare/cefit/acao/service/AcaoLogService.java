package br.com.aptare.cefit.acao.service;

import br.com.aptare.cefit.acao.entity.AcaoLog;
import br.com.aptare.fda.crud.service.AptareService;

public class AcaoLogService extends AptareService<AcaoLog>
{

   private static AcaoLogService instancia;

   public static AcaoLogService getInstancia()
   {
      if (instancia == null)
      {
         instancia = new AcaoLogService();
      }
      return instancia;
   }

   private AcaoLogService()
   {
   }

}
