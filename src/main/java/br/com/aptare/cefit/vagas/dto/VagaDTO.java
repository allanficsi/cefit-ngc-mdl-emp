package br.com.aptare.cefit.vagas.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import br.com.aptare.cefit.common.dto.AuditoriaDTO;
import br.com.aptare.cefit.trabalhador.dto.TrabalhadorDTO;
import br.com.aptare.cefit.vagas.dto.filtro.FiltroVagaDTO;

public class VagaDTO implements Serializable
{
   private static final long serialVersionUID = 8059018496629414759L;

   private Long codigo;
   
   private String descricao;

   private String tipoVaga;
   
   private String tipoDescricaoVaga;
   
   private Long codigoTrabalhador;
   
   private TrabalhadorDTO trabalhador;
   
   private Long codigoCbo;
   
   private String descricaoCbo;
   
   private Long codigoEmpregador;
   
   private Date dataInicio;
   
   private Date dataFim;
   
   private Integer situacao;
   
   private String descricaoSituacao;
   
   private String observacao;
   
   private Set<VagaAgendamentoDTO> listaVagaAgendamento;
   
   private Set<VagaDiaDTO> listaVagaDia;

   private AuditoriaDTO auditoria;
   
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

   public TrabalhadorDTO getTrabalhador()
   {
      return trabalhador;
   }

   public void setTrabalhador(TrabalhadorDTO trabalhador)
   {
      this.trabalhador = trabalhador;
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

   public Set<VagaAgendamentoDTO> getListaVagaAgendamento()
   {
      return listaVagaAgendamento;
   }

   public void setListaVagaAgendamento(Set<VagaAgendamentoDTO> listaVagaAgendamento)
   {
      this.listaVagaAgendamento = listaVagaAgendamento;
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
}
