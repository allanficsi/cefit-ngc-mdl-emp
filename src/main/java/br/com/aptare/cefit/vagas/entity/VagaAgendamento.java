package br.com.aptare.cefit.vagas.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(schema = "SC_VAG", name = "TBL_VAG_AGN")
@Proxy(lazy = true)
public class VagaAgendamento implements Serializable
{
   private static final long serialVersionUID = 1431211184645188934L;

   @Id
   @Column(name = "CD_VAG_AGN")
   @GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ_VAG_AGN")
   @SequenceGenerator(name = "SQ_VAG_AGN", sequenceName = "SC_VAG.SQ_VAG_AGN")
   private Long codigo;

   @Column(name = "CD_VAG")
   private Long codigoVaga;
   
   @Column(name = "NR_DIA")
   private Integer numeroDia;
   
   @Column(name = "NR_HOR1")
   private Integer numeroHora1;
   
   @Column(name = "NR_HOR2")
   private Integer numeroHora2;
   
   @Column(name = "NR_HOR3")
   private Integer numeroHora3;
   
   @Column(name = "NR_HOR4")
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
