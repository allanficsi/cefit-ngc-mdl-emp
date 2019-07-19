package br.com.aptare.cefit.trabalhador.entity.filtro;

import java.io.Serializable;
import java.util.Date;

public class PresencaFiltro implements Serializable
{
   
   private static final long serialVersionUID = -5546451468710986183L;

   private Date dataInicio;

   private Date dataFim;

   public Date getDataInicio() {
      return dataInicio;
   }

   public void setDataInicio(Date dataInicio) {
      this.dataInicio = dataInicio;
   }

   public Date getDataFim() {
      return dataFim;
   }

   public void setDataFim(Date dataFim) {
      this.dataFim = dataFim;
   }
}
