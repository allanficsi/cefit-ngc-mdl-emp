package br.com.aptare.cefit.vagas.entity;

import br.com.aptare.cefit.trabalhador.entity.Trabalhador;
import br.com.aptare.seguranca.entidade.Auditoria;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

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
   private Trabalhador trabalhador;
   
   @Column(name = "CD_VAG")
   private Long codigoVaga;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "CD_VAG", insertable = false, updatable = false)
   private Vaga vaga;
   
   @Column(name = "FG_ATV_ENC")
   private String flagAtivo;
   
   @Column(name = "DT_CNC_USR")
   private Date dataCancelamento;
   
   @Column(name = "CD_CNC_USR")
   private Long codigoUsuarioCancelamento;
   
   @Transient
   private HashMap<String, Object> filtroMap;
   
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

   public Long getCodigoVaga()
   {
      return codigoVaga;
   }

   public void setCodigoVaga(Long codigoVaga)
   {
      this.codigoVaga = codigoVaga;
   }

   public Trabalhador getTrabalhador()
   {
      return trabalhador;
   }

   public void setTrabalhador(Trabalhador trabalhador)
   {
      this.trabalhador = trabalhador;
   }

   public Vaga getVaga()
   {
      return vaga;
   }

   public void setVaga(Vaga vaga)
   {
      this.vaga = vaga;
   }

   public Auditoria getAuditoria()
   {
      return auditoria;
   }

   public void setAuditoria(Auditoria auditoria)
   {
      this.auditoria = auditoria;
   }

   public String getFlagAtivo()
   {
      return flagAtivo;
   }

   public void setFlagAtivo(String flagAtivo)
   {
      this.flagAtivo = flagAtivo;
   }

   public Date getDataCancelamento()
   {
      return dataCancelamento;
   }

   public void setDataCancelamento(Date dataCancelamento)
   {
      this.dataCancelamento = dataCancelamento;
   }

   public Long getCodigoUsuarioCancelamento()
   {
      return codigoUsuarioCancelamento;
   }

   public void setCodigoUsuarioCancelamento(Long codigoUsuarioCancelamento)
   {
      this.codigoUsuarioCancelamento = codigoUsuarioCancelamento;
   }

   public HashMap<String, Object> getFiltroMap()
   {
      return filtroMap;
   }

   public void setFiltroMap(HashMap<String, Object> filtroMap)
   {
      this.filtroMap = filtroMap;
   }
}
