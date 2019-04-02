package br.com.aptare.cefit.acao.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import br.com.aptare.cefit.common.dto.AuditoriaDTO;
import br.com.aptare.cefit.espaco.dto.EspacoDTO;

public class AcaoDTO implements Serializable
{
   private static final long serialVersionUID = 1L;

   private Long codigo;

   private Long codigoEsp;
   
   private EspacoDTO espaco;
   
   private String nome;
   
   private Long codigoTac;
   
   private TipoAcaoDTO tipoAcao;
   
   private Long numeroVagas;
   
   private Boolean flagValeTransporte;
   
   private Boolean flagValeRefeicao;
   
   private String observacao;
   
   private Long codigoAgendamento;
   
   private String descricaoSituacao;
   
   private Long situacao;
   
   private Set<AcaoProfissionalDTO> listaAcaoProfissional;
   
   private Set<AgendaDTO> listaAgenda;
   
   private List<AgendaDTO> listaAgendaOrdenada;
   
   private AuditoriaDTO auditoria;

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

   public EspacoDTO getEspaco()
   {
      return espaco;
   }

   public void setEspaco(EspacoDTO espaco)
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

   public Long getCodigoAgendamento()
   {
      return codigoAgendamento;
   }

   public void setCodigoAgendamento(Long codigoAgendamento)
   {
      this.codigoAgendamento = codigoAgendamento;
   }

   public Long getSituacao()
   {
      return situacao;
   }

   public void setSituacao(Long situacao)
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

   public TipoAcaoDTO getTipoAcao()
   {
      return tipoAcao;
   }

   public void setTipoAcao(TipoAcaoDTO tipoAcao)
   {
      this.tipoAcao = tipoAcao;
   }

   public Set<AcaoProfissionalDTO> getListaAcaoProfissional()
   {
      return listaAcaoProfissional;
   }

   public void setListaAcaoProfissional(Set<AcaoProfissionalDTO> listaAcaoProfissional)
   {
      this.listaAcaoProfissional = listaAcaoProfissional;
   }

   public Set<AgendaDTO> getListaAgenda()
   {
      return listaAgenda;
   }

   public void setListaAgenda(Set<AgendaDTO> listaAgenda)
   {
      this.listaAgenda = listaAgenda;
   }

   public String getDescricaoSituacao()
   {
      return descricaoSituacao;
   }

   public void setDescricaoSituacao(String descricaoSituacao)
   {
      this.descricaoSituacao = descricaoSituacao;
   }

   public List<AgendaDTO> getListaAgendaOrdenada()
   {
      return listaAgendaOrdenada;
   }

   public void setListaAgendaOrdenada(List<AgendaDTO> listaAgendaOrdenada)
   {
      this.listaAgendaOrdenada = listaAgendaOrdenada;
   }
}
