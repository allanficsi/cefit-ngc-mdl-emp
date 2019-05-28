package br.com.aptare.cefit.vagas.service;

import br.com.aptare.cefit.vagas.entity.Encaminhamento;
import br.com.aptare.fda.crud.service.AptareService;

public class EncaminhamentoService extends AptareService<Encaminhamento>
{
   private static EncaminhamentoService instancia;
   
   public static EncaminhamentoService getInstancia()
   {
      if (instancia == null)
      {
         instancia = new EncaminhamentoService();
      }
      return instancia;
   }

   private EncaminhamentoService()
   {
   }

}
