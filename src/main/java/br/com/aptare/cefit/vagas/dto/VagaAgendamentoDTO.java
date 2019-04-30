package br.com.aptare.cefit.vagas.dto;

import java.io.Serializable;

public class VagaAgendamentoDTO implements Serializable
{
   private static final long serialVersionUID = 8059018496629414759L;

   private Long codigo;

   private Long codigoVaga;
   
   private Integer numeroDia;
   
   private Integer numeroHora1;
   
   private Integer numeroHora2;
   
   private Integer numeroHora3;
   
   private Integer numeroHora4;

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

   public Integer getNumeroDia()
   {
      return numeroDia;
   }

   public void setNumeroDia(Integer numeroDia)
   {
      this.numeroDia = numeroDia;
   }

   public Integer getNumeroHora1()
   {
      return numeroHora1;
   }

   public void setNumeroHora1(Integer numeroHora1)
   {
      this.numeroHora1 = numeroHora1;
   }

   public Integer getNumeroHora2()
   {
      return numeroHora2;
   }

   public void setNumeroHora2(Integer numeroHora2)
   {
      this.numeroHora2 = numeroHora2;
   }

   public Integer getNumeroHora3()
   {
      return numeroHora3;
   }

   public void setNumeroHora3(Integer numeroHora3)
   {
      this.numeroHora3 = numeroHora3;
   }

   public Integer getNumeroHora4()
   {
      return numeroHora4;
   }

   public void setNumeroHora4(Integer numeroHora4)
   {
      this.numeroHora4 = numeroHora4;
   }
}
