package br.com.aptare.cefit.vagas.service;

import br.com.aptare.cefit.vagas.entity.VagaAgendamento;
import br.com.aptare.fda.crud.service.AptareService;

public class VagaAgendamentoService extends AptareService<VagaAgendamento>
{
   private static VagaAgendamentoService instancia;
   
   public static VagaAgendamentoService getInstancia()
   {
      if (instancia == null)
      {
         instancia = new VagaAgendamentoService();
      }
      return instancia;
   }

   private VagaAgendamentoService(){}

}
