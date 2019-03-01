package br.com.aptare.cefit.geral.entity.filtro;

import java.util.Date;

public class FeriadoFiltro
{
   private Date dataInicio;
   
   private Date dataFim;
   

   public Date getDataInicio()
   {
      return dataInicio;
   }

   public void setDataInicio(Date dataInicio)
   {
      this.dataInicio = dataInicio;
   }

   public Date getDataFim()
   {
      return dataFim;
   }

   public void setDataFim(Date dataFim)
   {
      this.dataFim = dataFim;
   }
}
