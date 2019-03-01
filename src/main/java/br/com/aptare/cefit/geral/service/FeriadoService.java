package br.com.aptare.cefit.geral.service;

import br.com.aptare.cefit.geral.entity.Feriado;
import br.com.aptare.fda.crud.service.AptareService;
import br.com.aptare.fda.hibernate.CatalogoRestricoes;

public class FeriadoService extends AptareService<Feriado>
{
   private static FeriadoService instancia;

   public static FeriadoService getInstancia()
   {
      if (instancia == null)
      {
         instancia = new FeriadoService();
      }
      return instancia;
   }

   private FeriadoService()
   {
      adicionarFiltro("dataFeriado", CatalogoRestricoes.MAIOR_IGUAL, "filtro.dataInicio");
      adicionarFiltro("dataFeriado", CatalogoRestricoes.MENOR_IGUAL, "filtro.dataFim");
   }
   
}
