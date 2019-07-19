package br.com.aptare.cefit.trabalhador.entity;

import br.com.aptare.cefit.trabalhador.entity.filtro.FiltroDocumento;
import br.com.aptare.seguranca.entidade.Auditoria;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "SC_TRB", name = "TBL_DCM")
@Proxy(lazy = true)
public class Documento implements Serializable
{
   
   private static final long serialVersionUID = 4284021779164554456L;

   @Id
   @Column(name = "CD_DCM")
   @GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ_DCM")
   @SequenceGenerator(name = "SQ_DCM", sequenceName = "SC_TRB.SQ_DCM")
   private Long codigo;
   
   @Column(name = "CD_TRB")
   private Long codigoTrabalhador;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "CD_TRB", insertable = false, updatable = false)
   private Trabalhador trabalhador;
   
   @Column(name = "TP_DCM")
   private Integer tipo;

   @Formula("(SELECT DMN.NM_VLR_DMN FROM SC_GRL.TBL_DMN DMN WHERE DMN.NM_CMP_DMN = 'TP_DCM' AND DMN.VL_CMP_DMN = TP_DCM)")
   private String descricaoTipo;
   
   @Column(name = "EXT_ARQ_DCM")
   private String extensao;
   
   @Column(name = "FG_ATV_DCM")
   private String flagAtivo;

   @Embedded
   private Auditoria auditoria;
   
   @Transient
   private String base64;
   
   @Transient
   private FiltroDocumento filtro;

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

   public Integer getTipo()
   {
      return tipo;
   }

   public void setTipo(Integer tipo)
   {
      this.tipo = tipo;
   }

   public String getDescricaoTipo()
   {
      return descricaoTipo;
   }

   public void setDescricaoTipo(String descricaoTipo)
   {
      this.descricaoTipo = descricaoTipo;
   }

   public String getExtensao()
   {
      return extensao;
   }

   public void setExtensao(String extensao)
   {
      this.extensao = extensao;
   }

   public String getFlagAtivo()
   {
      return flagAtivo;
   }

   public void setFlagAtivo(String flagAtivo)
   {
      this.flagAtivo = flagAtivo;
   }

   public Auditoria getAuditoria()
   {
      return auditoria;
   }

   public void setAuditoria(Auditoria auditoria)
   {
      this.auditoria = auditoria;
   }

   public FiltroDocumento getFiltro()
   {
      return filtro;
   }

   public void setFiltro(FiltroDocumento filtro)
   {
      this.filtro = filtro;
   }

   public String getBase64()
   {
      return base64;
   }

   public void setBase64(String base64)
   {
      this.base64 = base64;
   }

}
