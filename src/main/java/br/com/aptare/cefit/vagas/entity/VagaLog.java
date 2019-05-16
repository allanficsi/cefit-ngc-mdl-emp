package br.com.aptare.cefit.vagas.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(schema = "SC_VAG", name = "TBL_VAG_LOG")
@Proxy(lazy = true)
public class VagaLog implements Serializable
{
   private static final long serialVersionUID = 1431211184645188934L;

   @Id
   @Column(name = "CD_VAG_LOG")
   @GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ_VAG_LOG")
   @SequenceGenerator(name = "SQ_VAG_LOG", sequenceName = "SC_VAG.SQ_VAG_LOG")
   private Long codigo;

   @Column(name = "ST_VAG_ANT")
   private Long situacaoAnterior;
   
   @Column(name = "ST_VAG_NOV")
   private Long situacaoNova;
   
   @Column(name = "DT_OPR")
   private Date dataOperacao;
   
   @Column(name = "CD_USR_OPR")
   private Long codigoUsuarioOperacao;

   public Long getCodigo()
   {
      return codigo;
   }

   public void setCodigo(Long codigo)
   {
      this.codigo = codigo;
   }

   public Long getSituacaoAnterior()
   {
      return situacaoAnterior;
   }

   public void setSituacaoAnterior(Long situacaoAnterior)
   {
      this.situacaoAnterior = situacaoAnterior;
   }

   public Long getSituacaoNova()
   {
      return situacaoNova;
   }

   public void setSituacaoNova(Long situacaoNova)
   {
      this.situacaoNova = situacaoNova;
   }

   public Date getDataOperacao()
   {
      return dataOperacao;
   }

   public void setDataOperacao(Date dataOperacao)
   {
      this.dataOperacao = dataOperacao;
   }

   public Long getCodigoUsuarioOperacao()
   {
      return codigoUsuarioOperacao;
   }

   public void setCodigoUsuarioOperacao(Long codigoUsuarioOperacao)
   {
      this.codigoUsuarioOperacao = codigoUsuarioOperacao;
   }
}
