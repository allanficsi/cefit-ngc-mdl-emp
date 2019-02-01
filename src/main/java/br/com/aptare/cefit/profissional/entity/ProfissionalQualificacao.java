package br.com.aptare.cefit.profissional.entity;

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
@Table(schema = "SC_PRF", name = "TBL_PRF_QLF")
@Proxy(lazy = true)
public class ProfissionalQualificacao implements Serializable
{

   private static final long serialVersionUID = 1431211184645188934L;

   @Id
   @Column(name = "CD_PRF_QLF")
   @GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ_PRF_QLF")
   @SequenceGenerator(name = "SQ_PRF_QLF", sequenceName = "SC_PRF.SQ_PRF_QLF")
   private Long codigo;
   

   @Column(name = "CD_PRF")
   private Long codigoProfissional;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "CD_PRF", insertable = false, updatable = false)
   private Profissional profissional;
   
   @Column(name = "CD_QLF")
   private Long codigoQualificacao;

   public Long getCodigo()
   {
      return codigo;
   }

   public void setCodigo(Long codigo)
   {
      this.codigo = codigo;
   }

   public Long getCodigoProfissional()
   {
      return codigoProfissional;
   }

   public void setCodigoProfissional(Long codigoProfissional)
   {
      this.codigoProfissional = codigoProfissional;
   }

   public Long getCodigoQualificacao()
   {
      return codigoQualificacao;
   }

   public void setCodigoQualificacao(Long codigoQualificacao)
   {
      this.codigoQualificacao = codigoQualificacao;
   }

   public Profissional getProfissional()
   {
      return profissional;
   }

   public void setProfissional(Profissional profissional)
   {
      this.profissional = profissional;
   }
}
