package br.com.aptare.cefit.vagas.entity.filtro;

import java.io.Serializable;

public class FiltroVaga implements Serializable
{
   private static final long serialVersionUID = 1L;
   
   private String[] tipoVagaIN;

   public String[] getTipoVagaIN()
   {
      return tipoVagaIN;
   }

   public void setTipoVagaIN(String[] tipoVagaIN)
   {
      this.tipoVagaIN = tipoVagaIN;
   }
}
