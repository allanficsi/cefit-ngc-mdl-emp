package br.com.aptare.cefit.vagas.dto;

import br.com.aptare.cefit.cadastroUnico.dto.EnderecoDTO;
import br.com.aptare.cefit.common.dto.AuditoriaDTO;
import br.com.aptare.cefit.empregador.dto.EmpregadorDTO;
import br.com.aptare.cefit.trabalhador.dto.CboDTO;
import br.com.aptare.cefit.trabalhador.dto.TrabalhadorDTO;
import br.com.aptare.cefit.vagas.dto.filtro.FiltroVagaDTO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class VagaDTO implements Serializable
{
   private static final long serialVersionUID = 8059018496629414759L;

   private Long codigo;
   
   private String descricao;

   private String tipoVaga;
   
   private String tipoDescricaoVaga;
   
   private Long codigoTrabalhador;
   
   private TrabalhadorDTO trabalhadorEntity;
   
   private Long codigoCbo;
   
   private CboDTO cboEntity;
   
   private String descricaoCbo;
   
   private Long codigoEmpregador;
   
   private EmpregadorDTO empregador;
   
   private Date dataInicio;
   
   private Date dataFim;

   private Date dataLimite;

   private Integer situacao;

   private Integer direcionamento;

   private String descricaoSituacao;
   
   private String observacao;
   
   private Boolean flagRealizada;

   private Boolean flagControleExibicao;
   
   private Double valorPago;
   
   private Long codigoEndereco;
   
   private EnderecoDTO endereco;
   
   private List<VagaAgendamentoDTO> listaVagaAgendamentoOrdenada;
   
   private Set<VagaDiaDTO> listaVagaDia;

   private AuditoriaDTO auditoria;
   
   private String descricaoEndereco;
   
   private String descricaoDia;
   
   private FiltroVagaDTO filtro;
   

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

   public Date getDataLimite() {
      return dataLimite;
   }

   public void setDataLimite(Date dataLimite) {
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

   public Integer getDirecionamento() {
      return direcionamento;
   }

   public void setDirecionamento(Integer direcionamento) {
      this.direcionamento = direcionamento;
   }

   public AuditoriaDTO getAuditoria()
   {
      return auditoria;
   }

   public void setAuditoria(AuditoriaDTO auditoria)
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

   public Set<VagaDiaDTO> getListaVagaDia()
   {
      return listaVagaDia;
   }

   public void setListaVagaDia(Set<VagaDiaDTO> listaVagaDia)
   {
      this.listaVagaDia = listaVagaDia;
   }

   public FiltroVagaDTO getFiltro()
   {
      return filtro;
   }

   public void setFiltro(FiltroVagaDTO filtro)
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

   public CboDTO getCboEntity()
   {
      return cboEntity;
   }

   public void setCboEntity(CboDTO cboEntity)
   {
      this.cboEntity = cboEntity;
   }

   public TrabalhadorDTO getTrabalhadorEntity()
   {
      return trabalhadorEntity;
   }

   public void setTrabalhadorEntity(TrabalhadorDTO trabalhadorEntity)
   {
      this.trabalhadorEntity = trabalhadorEntity;
   }

   public EmpregadorDTO getEmpregador()
   {
      return empregador;
   }

   public void setEmpregador(EmpregadorDTO empregador)
   {
      this.empregador = empregador;
   }

   public List<VagaAgendamentoDTO> getListaVagaAgendamentoOrdenada()
   {
      return listaVagaAgendamentoOrdenada;
   }

   public void setListaVagaAgendamentoOrdenada(List<VagaAgendamentoDTO> listaVagaAgendamentoOrdenada)
   {
      this.listaVagaAgendamentoOrdenada = listaVagaAgendamentoOrdenada;
   }

   public Boolean getFlagRealizada()
   {
      return flagRealizada;
   }

   public void setFlagRealizada(Boolean flagRealizada)
   {
      this.flagRealizada = flagRealizada;
   }

   public Boolean getFlagControleExibicao() {
      return flagControleExibicao;
   }

   public void setFlagControleExibicao(Boolean flagControleExibicao) {
      this.flagControleExibicao = flagControleExibicao;
   }

   public Double getValorPago()
   {
      return valorPago;
   }

   public void setValorPago(Double valorPago)
   {
      this.valorPago = valorPago;
   }

   public Long getCodigoEndereco()
   {
      return codigoEndereco;
   }

   public void setCodigoEndereco(Long codigoEndereco)
   {
      this.codigoEndereco = codigoEndereco;
   }

   public EnderecoDTO getEndereco()
   {
      return endereco;
   }

   public void setEndereco(EnderecoDTO endereco)
   {
      this.endereco = endereco;
   }

   public String getDescricaoEndereco()
   {
      return descricaoEndereco;
   }

   public void setDescricaoEndereco(String descricaoEndereco)
   {
      this.descricaoEndereco = descricaoEndereco;
   }

   public String getDescricaoDia()
   {
      return descricaoDia;
   }

   public void setDescricaoDia(String descricaoDia)
   {
      this.descricaoDia = descricaoDia;
   }
}
