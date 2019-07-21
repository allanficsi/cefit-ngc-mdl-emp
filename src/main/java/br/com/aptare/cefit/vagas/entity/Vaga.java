package br.com.aptare.cefit.vagas.entity;

import br.com.aptare.cadastroUnico.entidade.Endereco;
import br.com.aptare.cefit.empregador.entity.Empregador;
import br.com.aptare.cefit.trabalhador.entity.Cbo;
import br.com.aptare.cefit.trabalhador.entity.Trabalhador;
import br.com.aptare.cefit.vagas.entity.filtro.FiltroVaga;
import br.com.aptare.seguranca.entidade.Auditoria;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(schema = "SC_VAG", name = "TBL_VAG")
@Proxy(lazy = true)
public class Vaga implements Serializable
{

   private static final long serialVersionUID = 1431211184645188934L;

   @Id
   @Column(name = "CD_VAG")
   @GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ_VAG")
   @SequenceGenerator(name = "SQ_VAG", sequenceName = "SC_VAG.SQ_VAG")
   private Long codigo;

   @Column(name = "DS_VAG")
   private String descricao;

   @Column(name = "TP_VAG")
   private String tipoVaga;

   @Column(name = "TP_DS_VAG")
   private String tipoDescricaoVaga;

   @Column(name = "CD_TRB")
   private Long codigoTrabalhador;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "CD_TRB", insertable = false, updatable = false)
   private Trabalhador trabalhadorEntity;

   @Column(name = "CD_CBO")
   private Long codigoCbo;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "CD_CBO", insertable = false, updatable = false)
   private Cbo cboEntity;

   @Column(name = "DS_CBO")
   private String descricaoCbo;

   @Column(name = "CD_EMP")
   private Long codigoEmpregador;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "CD_EMP", insertable = false, updatable = false)
   private Empregador empregador;

   @Column(name = "DT_INI")
   private Date dataInicio;

   @Column(name = "DT_FIM")
   private Date dataFim;

   @Column(name = "DT_LMT")
   private Date dataLimite;

   @Column(name = "ST_VAG")
   private Integer situacao;

   @Column(name = "DRC_VAG")
   private Integer direcionamento;

   @Formula("(SELECT DMN.NM_VLR_DMN FROM SC_GRL.TBL_DMN DMN WHERE DMN.NM_CMP_DMN = 'ST_VAG' AND DMN.VL_CMP_DMN = ST_VAG)")
   private String descricaoSituacao;

   @Column(name = "DS_OBS")
   private String observacao;

   @Column(name = "FG_REA_VAG")
   private Boolean flagRealizada;

   @Column(name = "FG_CNT_EXB")
   private Boolean flagControleExibicao;

   @Column(name = "VL_PAG_VAG")
   private Double valorPago;

   @Column(name = "CD_EDR")
   private Long codigoEndereco;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "CD_EDR", insertable = false, updatable = false)
   private Endereco endereco;

   @OneToMany(mappedBy = "vaga", fetch = FetchType.LAZY)
   private Set<VagaDia> listaVagaDia;

   @OneToMany(mappedBy = "vaga", fetch = FetchType.LAZY)
   private Set<Encaminhamento> listaEncaminhamento;

   @Transient
   private FiltroVaga filtro;

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

   public String getDescricao()
   {
      return descricao;
   }

   public void setDescricao(String descricao)
   {
      this.descricao = descricao;
   }

   public String getTipoVaga()
   {
      return tipoVaga;
   }

   public void setTipoVaga(String tipoVaga)
   {
      this.tipoVaga = tipoVaga;
   }

   public String getTipoDescricaoVaga()
   {
      return tipoDescricaoVaga;
   }

   public void setTipoDescricaoVaga(String tipoDescricaoVaga)
   {
      this.tipoDescricaoVaga = tipoDescricaoVaga;
   }

   public Long getCodigoTrabalhador()
   {
      return codigoTrabalhador;
   }

   public void setCodigoTrabalhador(Long codigoTrabalhador)
   {
      this.codigoTrabalhador = codigoTrabalhador;
   }

   public Long getCodigoCbo()
   {
      return codigoCbo;
   }

   public void setCodigoCbo(Long codigoCbo)
   {
      this.codigoCbo = codigoCbo;
   }

   public String getDescricaoCbo()
   {
      return descricaoCbo;
   }

   public void setDescricaoCbo(String descricaoCbo)
   {
      this.descricaoCbo = descricaoCbo;
   }

   public Long getCodigoEmpregador()
   {
      return codigoEmpregador;
   }

   public void setCodigoEmpregador(Long codigoEmpregador)
   {
      this.codigoEmpregador = codigoEmpregador;
   }

   public Date getDataInicio()
   {
      return dataInicio;
   }

   public void setDataInicio(Date dataInicio)
   {
      this.dataInicio = dataInicio;
   }

   public Date getDataFim()
   {
      return dataFim;
   }

   public void setDataFim(Date dataFim)
   {
      this.dataFim = dataFim;
   }

   public Date getDataLimite()
   {
      return dataLimite;
   }

   public void setDataLimite(Date dataLimite)
   {
      this.dataLimite = dataLimite;
   }

   public Integer getSituacao()
   {
      return situacao;
   }

   public void setSituacao(Integer situacao)
   {
      this.situacao = situacao;
   }

   public Auditoria getAuditoria()
   {
      return auditoria;
   }

   public void setAuditoria(Auditoria auditoria)
   {
      this.auditoria = auditoria;
   }

   public String getObservacao()
   {
      return observacao;
   }

   public void setObservacao(String observacao)
   {
      this.observacao = observacao;
   }

   public Set<VagaDia> getListaVagaDia()
   {
      return listaVagaDia;
   }

   public void setListaVagaDia(Set<VagaDia> listaVagaDia)
   {
      this.listaVagaDia = listaVagaDia;
   }

   public FiltroVaga getFiltro()
   {
      return filtro;
   }

   public void setFiltro(FiltroVaga filtro)
   {
      this.filtro = filtro;
   }

   public String getDescricaoSituacao()
   {
      return descricaoSituacao;
   }

   public void setDescricaoSituacao(String descricaoSituacao)
   {
      this.descricaoSituacao = descricaoSituacao;
   }

   public Cbo getCboEntity()
   {
      return cboEntity;
   }

   public void setCboEntity(Cbo cboEntity)
   {
      this.cboEntity = cboEntity;
   }

   public Trabalhador getTrabalhadorEntity()
   {
      return trabalhadorEntity;
   }

   public void setTrabalhadorEntity(Trabalhador trabalhadorEntity)
   {
      this.trabalhadorEntity = trabalhadorEntity;
   }

   public Empregador getEmpregador()
   {
      return empregador;
   }

   public void setEmpregador(Empregador empregador)
   {
      this.empregador = empregador;
   }

   public Boolean getFlagControleExibicao()
   {
      return flagControleExibicao;
   }

   public void setFlagControleExibicao(Boolean flagControleExibicao)
   {
      this.flagControleExibicao = flagControleExibicao;
   }

   public Boolean getFlagRealizada()
   {
      return flagRealizada;
   }

   public void setFlagRealizada(Boolean flagRealizada)
   {
      this.flagRealizada = flagRealizada;
   }

   public Integer getDirecionamento()
   {
      return direcionamento;
   }

   public void setDirecionamento(Integer direcionamento)
   {
      this.direcionamento = direcionamento;
   }

   public Double getValorPago()
   {
      return valorPago;
   }

   public void setValorPago(Double valorPago)
   {
      this.valorPago = valorPago;
   }

   public Set<Encaminhamento> getListaEncaminhamento()
   {
      return listaEncaminhamento;
   }

   public void setListaEncaminhamento(Set<Encaminhamento> listaEncaminhamento)
   {
      this.listaEncaminhamento = listaEncaminhamento;
   }

   public Long getCodigoEndereco()
   {
      return codigoEndereco;
   }

   public void setCodigoEndereco(Long codigoEndereco)
   {
      this.codigoEndereco = codigoEndereco;
   }

   public Endereco getEndereco()
   {
      return endereco;
   }

   public void setEndereco(Endereco endereco)
   {
      this.endereco = endereco;
   }

}
