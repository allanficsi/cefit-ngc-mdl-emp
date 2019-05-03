package br.com.aptare.cefit.trabalhador.service;

import br.com.aptare.cefit.trabalhador.entity.TrabalhadorAgenda;
import br.com.aptare.fda.crud.service.AptareService;

public class AgendaService extends AptareService<TrabalhadorAgenda> {
    private static AgendaService instancia;

    public static AgendaService getInstancia() {
        if (instancia == null) {
            instancia = new AgendaService();
        }
        return instancia;
    }

    private AgendaService() {

    }
}
