package br.com.aptare.cefit.vagas.service;

import br.com.aptare.cefit.vagas.entity.EncaminhamentoNaoAtendido;
import br.com.aptare.fda.crud.service.AptareService;

public class EncaminhamentoNaoAtendidoService extends AptareService<EncaminhamentoNaoAtendido>
{
   private static EncaminhamentoNaoAtendidoService instancia;
   
   public static EncaminhamentoNaoAtendidoService getInstancia()
   {
      if (instancia == null)
      {
         instancia = new EncaminhamentoNaoAtendidoService();
      }
      return instancia;
   }

   private EncaminhamentoNaoAtendidoService()
   {
   }

}
