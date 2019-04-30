package br.com.aptare.cefit.vagas.dto;

import java.io.Serializable;

public class VagaDiaDTO implements Serializable
{
   private static final long serialVersionUID = 8059018496629414759L;

   private Long codigo;

   private Long codigoVaga;
   
   private Long codigoDia;

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

   public Long getCodigoDia()
   {
      return codigoDia;
   }

   public void setCodigoDia(Long codigoDia)
   {
      this.codigoDia = codigoDia;
   }
}
