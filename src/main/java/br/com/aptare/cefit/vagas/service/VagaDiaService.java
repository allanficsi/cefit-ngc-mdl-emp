package br.com.aptare.cefit.vagas.service;

import br.com.aptare.cefit.vagas.entity.VagaDia;
import br.com.aptare.fda.crud.service.AptareService;

public class VagaDiaService extends AptareService<VagaDia>
{
   private static VagaDiaService instancia;
   
   public static VagaDiaService getInstancia()
   {
      if (instancia == null)
      {
         instancia = new VagaDiaService();
      }
      return instancia;
   }

   private VagaDiaService(){}

}
