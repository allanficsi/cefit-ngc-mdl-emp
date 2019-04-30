package br.com.aptare.cefit.vagas.service;

import br.com.aptare.cefit.vagas.entity.Vaga;
import br.com.aptare.fda.crud.service.AptareService;

public class VagaService extends AptareService<Vaga>
{
   private static VagaService instancia;
   
   public static VagaService getInstancia()
   {
      if (instancia == null)
      {
         instancia = new VagaService();
      }
      return instancia;
   }

   private VagaService(){}

}
