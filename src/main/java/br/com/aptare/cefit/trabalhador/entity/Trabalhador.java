package br.com.aptare.cefit.trabalhador.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Proxy;

import br.com.aptare.cadastroUnico.entidade.CadastroUnico;
import br.com.aptare.seguranca.entidade.Auditoria;

@Entity
@Table(schema = "SC_TRB", name = "TBL_TRB")
@Proxy(lazy = true)
public class Trabalhador implements Serializable
{

   private static final long serialVersionUID = 1431211184645188934L;

   @Id
   @Column(name = "CD_TRB")
   @GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ_TRB")
   @SequenceGenerator(name = "SQ_TRB", sequenceName = "SC_TRB.SQ_TRB")
   private Long codigo;

   @Column(name = "CD_CUN")
   private Long codigoCadastroUnico;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "CD_CUN", insertable = false, updatable = false)
   private CadastroUnico cadastroUnico;
   
   @Column(name = "NR_PIS")
   private Long numeroPis;
   
   @Column(name = "NR_CTPS")
   private Long numeroCtps;
   
   @Column(name = "DT_EMS_CTPS")
   private Date dataEmissaoCtps;
   
   @Column(name = "ST_TRB")
   private Integer situacao;

   @Formula("(SELECT DMN.NM_VLR_DMN FROM SC_GRL.TBL_DMN DMN WHERE DMN.NM_CMP_DMN = 'ST_TRB' AND DMN.VL_CMP_DMN = ST_TRB)")
   private String descricaoSituacao;

   @Column(name = "ST_ING_PGR")
   private Integer situacaoIngresso;

   @Formula("(SELECT DMN.NM_VLR_DMN FROM SC_GRL.TBL_DMN DMN WHERE DMN.NM_CMP_DMN = 'ST_ING_PGR' AND DMN.VL_CMP_DMN = ST_ING_PGR)")
   private String descricaoSituacaoIngresso;
   
   @Column(name = "OBS_TRB")
   private String observacao;
   
   @Column(name = "UF_CTPS")
   private String ufCtps;
   
   @Column(name = "NR_SER_CTPS")
   private Long numeroSerieCtps;

   @Column(name = "NR_INS_PRF")
   private Long numeroInscricaoPrefeitura;

   @Column(name = "NR_INSS")   
   private Long numeroInss;
   
   @OneToMany(mappedBy = "trabalhador", fetch = FetchType.LAZY)
   private Set<TrabalhadorCbo> listaTrabalhadorCbo;
   
   @OneToMany(mappedBy = "trabalhador", fetch = FetchType.LAZY)
   private Set<TrabalhadorDeficiencia> listaTrabalhadorDeficiencia;

   @OneToMany(mappedBy = "trabalhador", fetch = FetchType.LAZY)
   private Set<TrabalhadorAgenda> listaTrabalhadorAgenda;

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

   public Long getCodigoCadastroUnico()
   {
      return codigoCadastroUnico;
   }

   public void setCodigoCadastroUnico(Long codigoCadastroUnico)
   {
      this.codigoCadastroUnico = codigoCadastroUnico;
   }

   public CadastroUnico getCadastroUnico()
   {
      return cadastroUnico;
   }

   public void setCadastroUnico(CadastroUnico cadastroUnico)
   {
      this.cadastroUnico = cadastroUnico;
   }

   public Long getNumeroPis()
   {
      return numeroPis;
   }

   public void setNumeroPis(Long numeroPis)
   {
      this.numeroPis = numeroPis;
   }

   public Long getNumeroCtps()
   {
      return numeroCtps;
   }

   public void setNumeroCtps(Long numeroCtps)
   {
      this.numeroCtps = numeroCtps;
   }

   public Date getDataEmissaoCtps()
   {
      return dataEmissaoCtps;
   }

   public void setDataEmissaoCtps(Date dataEmissaoCtps)
   {
      this.dataEmissaoCtps = dataEmissaoCtps;
   }

   public Integer getSituacao()
   {
      return situacao;
   }

   public void setSituacao(Integer situacao)
   {
      this.situacao = situacao;
   }

   public String getDescricaoSituacao()
   {
      return descricaoSituacao;
   }

   public void setDescricaoSituacao(String descricaoSituacao)
   {
      this.descricaoSituacao = descricaoSituacao;
   }

   public Integer getSituacaoIngresso()
   {
      return situacaoIngresso;
   }

   public void setSituacaoIngresso(Integer situacaoIngresso)
   {
      this.situacaoIngresso = situacaoIngresso;
   }

   public String getDescricaoSituacaoIngresso()
   {
      return descricaoSituacaoIngresso;
   }

   public void setDescricaoSituacaoIngresso(String descricaoSituacaoIngresso)
   {
      this.descricaoSituacaoIngresso = descricaoSituacaoIngresso;
   }

   public String getObservacao()
   {
      return observacao;
   }

   public void setObservacao(String observacao)
   {
      this.observacao = observacao;
   }

   public Auditoria getAuditoria()
   {
      return auditoria;
   }

   public void setAuditoria(Auditoria auditoria)
   {
      this.auditoria = auditoria;
   }

   public String getUfCtps()
   {
      return ufCtps;
   }

   public void setUfCtps(String ufCtps)
   {
      this.ufCtps = ufCtps;
   }

   public Long getNumeroSerieCtps()
   {
      return numeroSerieCtps;
   }

   public void setNumeroSerieCtps(Long numeroSerieCtps)
   {
      this.numeroSerieCtps = numeroSerieCtps;
   }

   public Long getNumeroInscricaoPrefeitura()
   {
      return numeroInscricaoPrefeitura;
   }

   public void setNumeroInscricaoPrefeitura(Long numeroInscricaoPrefeitura)
   {
      this.numeroInscricaoPrefeitura = numeroInscricaoPrefeitura;
   }

   public Long getNumeroInss()
   {
      return numeroInss;
   }

   public void setNumeroInss(Long numeroInss)
   {
      this.numeroInss = numeroInss;
   }

   public Set<TrabalhadorCbo> getListaTrabalhadorCbo()
   {
      return listaTrabalhadorCbo;
   }

   public void setListaTrabalhadorCbo(Set<TrabalhadorCbo> listaTrabalhadorCbo)
   {
      this.listaTrabalhadorCbo = listaTrabalhadorCbo;
   }

   public Set<TrabalhadorDeficiencia> getListaTrabalhadorDeficiencia()
   {
      return listaTrabalhadorDeficiencia;
   }

   public void setListaTrabalhadorDeficiencia(Set<TrabalhadorDeficiencia> listaTrabalhadorDeficiencia)
   {
      this.listaTrabalhadorDeficiencia = listaTrabalhadorDeficiencia;
   }

   public Set<TrabalhadorAgenda> getListaTrabalhadorAgenda() {
      return listaTrabalhadorAgenda;
   }

   public void setListaTrabalhadorAgenda(Set<TrabalhadorAgenda> listaTrabalhadorAgenda) {
      this.listaTrabalhadorAgenda = listaTrabalhadorAgenda;
   }
}
