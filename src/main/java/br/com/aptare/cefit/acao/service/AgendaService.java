package br.com.aptare.cefit.acao.service;

import br.com.aptare.cefit.acao.entity.Agenda;
import br.com.aptare.fda.crud.service.AptareService;

public class AgendaService extends AptareService<Agenda>
{

   private static AgendaService instancia;

   public static AgendaService getInstancia()
   {
      if (instancia == null)
      {
         instancia = new AgendaService();
      }
      return instancia;
   }

   private AgendaService()
   {
   }
}
