package br.com.aptare.cefit.vagas.dto;

import java.io.Serializable;
import java.util.Date;

public class VagaDiaDTO implements Serializable
{
   private static final long serialVersionUID = 8059018496629414759L;

   private Long codigo;

   private Long codigoVaga;
   
   private Date data;
   
   private String horarioEntrada;

   private String horarioSaida;
   

   public Long getCodigo()
   {
      return codigo;
   }

   public void setCodigo(Long codigo)
   {
      this.codigo = codigo;
   }

   public Long getCodigoVaga()
   {
      return codigoVaga;
   }

   public void setCodigoVaga(Long codigoVaga)
   {
      this.codigoVaga = codigoVaga;
   }

   public Date getData()
   {
      return data;
   }

   public void setData(Date data)
   {
      this.data = data;
   }

   public String getHorarioEntrada()
   {
      return horarioEntrada;
   }

   public void setHorarioEntrada(String horarioEntrada)
   {
      this.horarioEntrada = horarioEntrada;
   }

   public String getHorarioSaida()
   {
      return horarioSaida;
   }

   public void setHorarioSaida(String horarioSaida)
   {
      this.horarioSaida = horarioSaida;
   }
}
