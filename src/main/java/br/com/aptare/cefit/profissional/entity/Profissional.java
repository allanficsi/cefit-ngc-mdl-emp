package br.com.aptare.cefit.profissional.entity;

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

import org.hibernate.annotations.Proxy;

import br.com.aptare.cadastroUnico.entidade.CadastroUnico;
import br.com.aptare.seguranca.entidade.Auditoria;

@Entity
@Table(schema = "SC_PRF", name = "TBL_PRF")
@Proxy(lazy = true)
public class Profissional implements Serializable
{

   private static final long serialVersionUID = 1431211184645188934L;

   @Id
   @Column(name = "CD_PRF")
   @GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ_PRF")
   @SequenceGenerator(name = "SQ_PRF", sequenceName = "SC_PRF.SQ_PRF")
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
   
   @Column(name = "OBS_PRF")
   private String observacao;
   
   @Column(name = "UF_CTPS")
   private String ufCtps;
   
   @Column(name = "NR_SER_CTPS")
   private Long numeroSerieCtps;

   @Column(name = "NR_INS_PRF")
   private Long numeroInscricaoPrefeitura;

   @Column(name = "NR_INSS")   
   private Long numeroInss;
   
   @Column(name = "FG_ATV")
   private String flagAtivo;
   
   @Column(name = "FG_PSC")
   private String flagPsicologo;
   
   @OneToMany(mappedBy = "profissional", fetch = FetchType.LAZY)
   private Set<ProfissionalQualificacao> listaProfissionalQualificacao;
   
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

   public String getObservacao()
   {
      return observacao;
   }

   public void setObservacao(String observacao)
   {
      this.observacao = observacao;
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

   public String getFlagPsicologo()
   {
      return flagPsicologo;
   }

   public void setFlagPsicologo(String flagPsicologo)
   {
      this.flagPsicologo = flagPsicologo;
   }

   public Set<ProfissionalQualificacao> getListaProfissionalQualificacao()
   {
      return listaProfissionalQualificacao;
   }

   public void setListaProfissionalQualificacao(Set<ProfissionalQualificacao> listaProfissionalQualificacao)
   {
      this.listaProfissionalQualificacao = listaProfissionalQualificacao;
   }
}
