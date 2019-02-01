package br.com.aptare.cefit.trabalhador.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(schema = "SC_TRB", name = "TBL_TRB_CBO")
@Proxy(lazy = true)
public class TrabalhadorCbo implements Serializable
{

   private static final long serialVersionUID = 1431211184645188934L;

   @Id
   @Column(name = "CD_TRB_CBO")
   @GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ_TRB_CBO")
   @SequenceGenerator(name = "SQ_TRB_CBO", sequenceName = "SC_TRB.SQ_TRB_CBO")
   private Long codigo;
   
   @Column(name = "CD_TRB")
   private Long codigoTrabalhador;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "CD_TRB", insertable = false, updatable = false)
   private Trabalhador trabalhador;

   @Column(name = "CD_CBO")
   private Long codigoCbo;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "CD_CBO", insertable = false, updatable = false)
   private Cbo cbo;
   
   @Column(name = "NM_TRB_CBO")
   private String nome;

   public Long getCodigo()
   {
      return codigo;
   }

   public void setCodigo(Long codigo)
   {
      this.codigo = codigo;
   }

   public Long getCodigoTrabalhador()
   {
      return codigoTrabalhador;
   }

   public void setCodigoTrabalhador(Long codigoTrabalhador)
   {
      this.codigoTrabalhador = codigoTrabalhador;
   }

   public Long getCodigoCbo()
   {
      return codigoCbo;
   }

   public void setCodigoCbo(Long codigoCbo)
   {
      this.codigoCbo = codigoCbo;
   }

   public String getNome()
   {
      return nome;
   }

   public void setNome(String nome)
   {
      this.nome = nome;
   }

   public Trabalhador getTrabalhador()
   {
      return trabalhador;
   }

   public void setTrabalhador(Trabalhador trabalhador)
   {
      this.trabalhador = trabalhador;
   }

   public Cbo getCbo()
   {
      return cbo;
   }

   public void setCbo(Cbo cbo)
   {
      this.cbo = cbo;
   }
}
