package br.com.aptare.cefit.vagas.entity;

import br.com.aptare.cefit.trabalhador.entity.Trabalhador;
import br.com.aptare.seguranca.entidade.Auditoria;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "SC_VAG", name = "TBL_ENA")
@Proxy(lazy = true)
public class EncaminhamentoNaoAtendido implements Serializable
{

   private static final long serialVersionUID = 1431211184645188934L;

   @Id
   @Column(name = "CD_ENA")
   @GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ_ENA")
   @SequenceGenerator(name = "SQ_ENA", sequenceName = "SC_VAG.SQ_ENA")
   private Long codigo;

   @Column(name = "CD_TRB")
   private Long codigoTrabalhador;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "CD_TRB", insertable = false, updatable = false)
   private Trabalhador trabalhador;
   
   @Column(name = "CD_VAG")
   private Long codigoVaga;
   
   @Column(name = "FG_ATV_ENA")
   private String flagAtivo;
   
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

   public Trabalhador getTrabalhador()
   {
      return trabalhador;
   }

   public void setTrabalhador(Trabalhador trabalhador)
   {
      this.trabalhador = trabalhador;
   }

   public Long getCodigoVaga()
   {
      return codigoVaga;
   }

   public void setCodigoVaga(Long codigoVaga)
   {
      this.codigoVaga = codigoVaga;
   }

   public String getFlagAtivo()
   {
      return flagAtivo;
   }

   public void setFlagAtivo(String flagAtivo)
   {
      this.flagAtivo = flagAtivo;
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
