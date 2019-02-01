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

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Proxy;

@Entity
@Table(schema = "SC_TRB", name = "TBL_TRB_DEF")
@Proxy(lazy = true)
public class TrabalhadorDeficiencia implements Serializable
{

   private static final long serialVersionUID = 1431211184645188934L;

   @Id
   @Column(name = "CD_TRB_DEF")
   @GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ_TRB_DEF")
   @SequenceGenerator(name = "SQ_TRB_DEF", sequenceName = "SC_TRB.SQ_TRB_DEF")
   private Long codigo;
   
   @Column(name = "CD_TRB")
   private Long codigoTrabalhador;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "CD_TRB", insertable = false, updatable = false)
   private Trabalhador trabalhador;

   @Column(name = "CD_DEF")
   private Long codigoDeficiencia;
   
   @Formula("(SELECT DMN.NM_VLR_DMN FROM SC_GRL.TBL_DMN DMN WHERE DMN.NM_CMP_DMN = 'CD_DEF' AND DMN.VL_CMP_DMN = CD_DEF)")
   private String descricaoDeficiencia;
   
   @Column(name = "NM_TRB_DEF")
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

   public Long getCodigoDeficiencia()
   {
      return codigoDeficiencia;
   }

   public void setCodigoDeficiencia(Long codigoDeficiencia)
   {
      this.codigoDeficiencia = codigoDeficiencia;
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

   public String getDescricaoDeficiencia()
   {
      return descricaoDeficiencia;
   }

   public void setDescricaoDeficiencia(String descricaoDeficiencia)
   {
      this.descricaoDeficiencia = descricaoDeficiencia;
   }
}
