package br.com.aptare.cefit.trabalhador.service;


import br.com.aptare.cefit.trabalhador.entity.TrabalhadorLog;
import br.com.aptare.fda.crud.service.AptareService;

public class TrabalhadorLogService extends AptareService<TrabalhadorLog> {

    private static TrabalhadorLogService instancia;

    public static TrabalhadorLogService getInstancia()
    {
        if (instancia == null)

        {
            instancia = new TrabalhadorLogService();
        }
        return instancia;
    }

    private TrabalhadorLogService()
    {
    }


}
