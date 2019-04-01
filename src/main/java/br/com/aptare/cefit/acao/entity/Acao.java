package br.com.aptare.cefit.acao.entity;

import java.io.Serializable;
import java.util.HashMap;
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
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Proxy;

import br.com.aptare.cefit.espaco.entity.Espaco;
import br.com.aptare.seguranca.entidade.Auditoria;

@Entity
@Table(schema = "SC_ACA", name = "TBL_ACA")
@Proxy(lazy = true)
public class Acao implements Serializable
{
   private static final long serialVersionUID = 1431211184645188934L;

   @Id
   @Column(name = "CD_ACA")
   @GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ_ACA")
   @SequenceGenerator(name = "SQ_ACA", sequenceName = "SC_ACA.SQ_ACA")
   private Long codigo;

   @Column(name = "CD_ESP")
   private Long codigoEsp;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "CD_ESP", insertable = false, updatable = false)
   private Espaco espaco;
   
   @Column(name = "NM_ACA")
   private String nome;
   
   @Column(name = "CD_TAC")
   private Long codigoTac;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "CD_TAC", insertable = false, updatable = false)
   private TipoAcao tipoAcao;   
   
   @Column(name = "NR_VAG")
   private Long numeroVagas;
   
   @Column(name = "FG_VTR")
   private Boolean flagValeTransporte;
   
   @Column(name = "FG_VRF")
   private Boolean flagValeRefeicao;
   
   @Column(name = "OBS_ACA")
   private String observacao;
   
   @Formula("(SELECT DMN.NM_VLR_DMN FROM SC_GRL.TBL_DMN DMN WHERE DMN.NM_CMP_DMN = 'ST_ACA' AND DMN.VL_CMP_DMN = ST_ACA)")
   private String descricaoSituacao;
   
   @Column(name = "ST_ACA")
   private Long situacao;
   
   @OneToMany(mappedBy = "acao", fetch = FetchType.LAZY)
   private Set<Agenda> listaAgenda;   
   
   @OneToMany(mappedBy = "acao", fetch = FetchType.LAZY)
   private Set<AcaoProfissional> listaAcaoProfissional;
   
   @Transient
   private HashMap<Object, String> filtro;

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

   public Long getCodigoEsp()
   {
      return codigoEsp;
   }

   public void setCodigoEsp(Long codigoEsp)
   {
      this.codigoEsp = codigoEsp;
   }

   public Espaco getEspaco()
   {
      return espaco;
   }

   public void setEspaco(Espaco espaco)
   {
      this.espaco = espaco;
   }

   public String getNome()
   {
      return nome;
   }

   public void setNome(String nome)
   {
      this.nome = nome;
   }

   public Long getCodigoTac()
   {
      return codigoTac;
   }

   public void setCodigoTac(Long codigoTac)
   {
      this.codigoTac = codigoTac;
   }

   public TipoAcao getTipoAcao()
   {
      return tipoAcao;
   }

   public void setTipoAcao(TipoAcao tipoAcao)
   {
      this.tipoAcao = tipoAcao;
   }

   public Long getNumeroVagas()
   {
      return numeroVagas;
   }

   public void setNumeroVagas(Long numeroVagas)
   {
      this.numeroVagas = numeroVagas;
   }

   public Boolean getFlagValeTransporte()
   {
      return flagValeTransporte;
   }

   public void setFlagValeTransporte(Boolean flagValeTransporte)
   {
      this.flagValeTransporte = flagValeTransporte;
   }

   public Boolean getFlagValeRefeicao()
   {
      return flagValeRefeicao;
   }

   public void setFlagValeRefeicao(Boolean flagValeRefeicao)
   {
      this.flagValeRefeicao = flagValeRefeicao;
   }

   public String getObservacao()
   {
      return observacao;
   }

   public void setObservacao(String observacao)
   {
      this.observacao = observacao;
   }

   public Long getSituacao()
   {
      return situacao;
   }

   public void setSituacao(Long situacao)
   {
      this.situacao = situacao;
   }

   public HashMap<Object, String> getFiltro()
   {
      return filtro;
   }

   public void setFiltro(HashMap<Object, String> filtro)
   {
      this.filtro = filtro;
   }

   public Auditoria getAuditoria()
   {
      return auditoria;
   }

   public void setAuditoria(Auditoria auditoria)
   {
      this.auditoria = auditoria;
   }

   public Set<Agenda> getListaAgenda()
   {
      return listaAgenda;
   }

   public void setListaAgenda(Set<Agenda> listaAgenda)
   {
      this.listaAgenda = listaAgenda;
   }

   public Set<AcaoProfissional> getListaAcaoProfissional()
   {
      return listaAcaoProfissional;
   }

   public void setListaAcaoProfissional(Set<AcaoProfissional> listaAcaoProfissional)
   {
      this.listaAcaoProfissional = listaAcaoProfissional;
   }

   public String getDescricaoSituacao()
   {
      return descricaoSituacao;
   }

   public void setDescricaoSituacao(String descricaoSituacao)
   {
      this.descricaoSituacao = descricaoSituacao;
   }
}
