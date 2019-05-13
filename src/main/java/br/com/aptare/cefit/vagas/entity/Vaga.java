package br.com.aptare.cefit.vagas.entity;

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
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Proxy;

import br.com.aptare.cefit.empregador.entity.Empregador;
import br.com.aptare.cefit.trabalhador.entity.Cbo;
import br.com.aptare.cefit.trabalhador.entity.Trabalhador;
import br.com.aptare.cefit.vagas.entity.filtro.FiltroVaga;
import br.com.aptare.seguranca.entidade.Auditoria;

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
   private Empregador empregadorEntity;
   
   @Column(name = "DT_INI")
   private Date dataInicio;
   
   @Column(name = "DT_FIM")
   private Date dataFim;
   
   @Column(name = "ST_VAG")
   private Integer situacao;
   
   @Formula("(SELECT DMN.NM_VLR_DMN FROM SC_GRL.TBL_DMN DMN WHERE DMN.NM_CMP_DMN = 'ST_VAG' AND DMN.VL_CMP_DMN = ST_VAG)")
   private String descricaoSituacao;
   
   @Column(name = "DS_OBS")
   private String observacao;
   
   @OneToMany(mappedBy = "vaga", fetch = FetchType.LAZY)
   private Set<VagaAgendamento> listaVagaAgendamento; 
   
   @OneToMany(mappedBy = "vaga", fetch = FetchType.LAZY)
   private Set<VagaDia> listaVagaDia; 
   
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

   public Set<VagaAgendamento> getListaVagaAgendamento()
   {
      return listaVagaAgendamento;
   }

   public void setListaVagaAgendamento(Set<VagaAgendamento> listaVagaAgendamento)
   {
      this.listaVagaAgendamento = listaVagaAgendamento;
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

   public Empregador getEmpregadorEntity()
   {
      return empregadorEntity;
   }

   public void setEmpregadorEntity(Empregador empregadorEntity)
   {
      this.empregadorEntity = empregadorEntity;
   }
}
