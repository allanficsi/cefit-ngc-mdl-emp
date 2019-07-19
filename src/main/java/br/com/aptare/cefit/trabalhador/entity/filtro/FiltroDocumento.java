package br.com.aptare.cefit.trabalhador.entity.filtro;

import java.io.Serializable;

public class FiltroDocumento implements Serializable
{
   
   private static final long serialVersionUID = -8980653763476427982L;
   
   private Integer[] tipoIN;

   public Integer[] getTipoIN()
   {
      return tipoIN;
   }

   public void setTipoIN(Integer[] tipoIN)
   {
      this.tipoIN = tipoIN;
   }

}
