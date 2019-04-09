package br.com.aptare.cefit.acao.entity;

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

import br.com.aptare.cefit.profissional.entity.Profissional;

@Entity
@Table(schema = "SC_ACA", name = "TBL_ACA_PRF")
@Proxy(lazy = true)
public class AcaoProfissional implements Serializable
{
   private static final long serialVersionUID = 1431211184645188934L;

   @Id
   @Column(name = "CD_ACA_PRF")
   @GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ_ACA")
   @SequenceGenerator(name = "SQ_ACA", sequenceName = "SC_ACA.SQ_ACA_PRF")
   private Long codigo;

   @Column(name = "CD_ACA")
   private Long codigoAca;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "CD_ACA", insertable = false, updatable = false)
   private Acao acao;
   
   @Column(name = "CD_PRF")
   private Long codigoPrf;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "CD_PRF", insertable = false, updatable = false)
   private Profissional profissional;

   public Long getCodigo()
   {
      return codigo;
   }

   public void setCodigo(Long codigo)
   {
      this.codigo = codigo;
   }


   public Acao getAcao()
   {
      return acao;
   }

   public void setAcao(Acao acao)
   {
      this.acao = acao;
   }

   public Long getCodigoAca()
   {
      return codigoAca;
   }

   public void setCodigoAca(Long codigoAca)
   {
      this.codigoAca = codigoAca;
   }

   public Long getCodigoPrf()
   {
      return codigoPrf;
   }

   public void setCodigoPrf(Long codigoPrf)
   {
      this.codigoPrf = codigoPrf;
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
