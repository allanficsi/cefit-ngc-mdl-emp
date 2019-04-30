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
@Table(schema = "SC_VAG", name = "TBL_VAG_DIA")
@Proxy(lazy = true)
public class VagaDia implements Serializable
{

   private static final long serialVersionUID = 1431211184645188934L;

   @Id
   @Column(name = "CD_VAG_DIA")
   @GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ_VAG_DIA")
   @SequenceGenerator(name = "SQ_VAG_DIA", sequenceName = "SC_VAG.SQ_VAG_DIA")
   private Long codigo;

   @Column(name = "CD_VAG")
   private Long codigoVaga;
   
   @Column(name = "CD_DIA_VAG")
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
