package br.com.aptare.cefit.trabalhador.entity;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;

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

   @Column(name = "CD_EXP_CMP")
   private Long codigoExperiencia;

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

   public Long getCodigoExperiencia() {
      return codigoExperiencia;
   }

   public void setCodigoExperiencia(Long codigoExperiencia) {
      this.codigoExperiencia = codigoExperiencia;
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
