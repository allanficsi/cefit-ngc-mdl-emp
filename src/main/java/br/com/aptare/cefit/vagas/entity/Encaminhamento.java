package br.com.aptare.cefit.vagas.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
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

import br.com.aptare.cefit.trabalhador.entity.Trabalhador;
import br.com.aptare.seguranca.entidade.Auditoria;

@Entity
@Table(schema = "SC_VAG", name = "TBL_ENC")
@Proxy(lazy = true)
public class Encaminhamento implements Serializable
{

   private static final long serialVersionUID = 1431211184645188934L;

   @Id
   @Column(name = "CD_ENC")
   @GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ_ENC")
   @SequenceGenerator(name = "SQ_ENC", sequenceName = "SC_VAG.SQ_ENC")
   private Long codigo;

   @Column(name = "CD_TRB")
   private Long codigoTrabalhador;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "CD_TRB", insertable = false, updatable = false)
   private Trabalhador trabalhadorEntity;
   
   @Column(name = "CD_VAG")
   private Long codigoVaga;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "CD_VAG", insertable = false, updatable = false)
   private Vaga vagaEntity;
   
   @Embedded
   private Auditoria auditoria;

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

   public Trabalhador getTrabalhadorEntity()
   {
      return trabalhadorEntity;
   }

   public void setTrabalhadorEntity(Trabalhador trabalhadorEntity)
   {
      this.trabalhadorEntity = trabalhadorEntity;
   }

   public Long getCodigoVaga()
   {
      return codigoVaga;
   }

   public void setCodigoVaga(Long codigoVaga)
   {
      this.codigoVaga = codigoVaga;
   }

   public Vaga getVagaEntity()
   {
      return vagaEntity;
   }

   public void setVagaEntity(Vaga vagaEntity)
   {
      this.vagaEntity = vagaEntity;
   }

   public Auditoria getAuditoria()
   {
      return auditoria;
   }

   public void setAuditoria(Auditoria auditoria)
   {
      this.auditoria = auditoria;
   }
}
