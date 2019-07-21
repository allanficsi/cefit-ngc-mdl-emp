package br.com.aptare.cefit.trabalhador.dto;

import br.com.aptare.cefit.cadastroUnico.dto.CadastroUnicoDTO;
import br.com.aptare.cefit.common.dto.AuditoriaDTO;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class TrabalhadorDTO implements Serializable
{
   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   private Long codigo;

   private Long codigoCadastroUnico;

   private CadastroUnicoDTO cadastroUnico;

   private Long numeroPis;

   private Long numeroCtps;

   private Long dataEmissaoCtps;

   private Integer situacao;

   private String descricaoSituacao;

   private Integer situacaoIngresso;

   private String descricaoSituacaoIngresso;

   private String ufCtps;

   private Long numeroSerieCtps;

   private Long numeroInscricaoPrefeitura;
   
   private Long numeroInss;

   private AuditoriaDTO auditoria;

   private Boolean flagTrabalhadorInformal;

   private Boolean flagTrabalhadorFormal;

   private String telefoneExtenso;
   
   private String observacao;

   private Set<TrabalhadorCboDTO> listaTrabalhadorCbo;

   private Set<TrabalhadorDeficienciaDTO> listaTrabalhadorDeficiencia;

   private Set<TrabalhadorAgendaDTO> listaTrabalhadorAgenda;
   
   private Set<TrabalhadorLogDTO> listaTrabalhadorLog;

   private List<TrabalhadorLogDTO> listaTrabalhadorLogOrdenada;

   private List<TrabalhadorRejeicaoDTO> listaTrabalhadorRejeicao;

   private List<TrabalhadorPresencaDTO> listaTrabalhadorPresenca;

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

   public CadastroUnicoDTO getCadastroUnico()
   {
      return cadastroUnico;
   }

   public void setCadastroUnico(CadastroUnicoDTO cadastroUnico)
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

   public Long getDataEmissaoCtps()
   {
      return dataEmissaoCtps;
   }

   public void setDataEmissaoCtps(Long dataEmissaoCtps)
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

   public AuditoriaDTO getAuditoria()
   {
      return auditoria;
   }

   public void setAuditoria(AuditoriaDTO auditoria)
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

   public Set<TrabalhadorCboDTO> getListaTrabalhadorCbo()
   {
      return listaTrabalhadorCbo;
   }

   public void setListaTrabalhadorCbo(Set<TrabalhadorCboDTO> listaTrabalhadorCbo)
   {
      this.listaTrabalhadorCbo = listaTrabalhadorCbo;
   }

   public Set<TrabalhadorDeficienciaDTO> getListaTrabalhadorDeficiencia()
   {
      return listaTrabalhadorDeficiencia;
   }

   public void setListaTrabalhadorDeficiencia(Set<TrabalhadorDeficienciaDTO> listaTrabalhadorDeficiencia)
   {
      this.listaTrabalhadorDeficiencia = listaTrabalhadorDeficiencia;
   }

   public Set<TrabalhadorAgendaDTO> getListaTrabalhadorAgenda()
   {
      return listaTrabalhadorAgenda;
   }

   public void setListaTrabalhadorAgenda(Set<TrabalhadorAgendaDTO> listaTrabalhadorAgenda)
   {
      this.listaTrabalhadorAgenda = listaTrabalhadorAgenda;
   }

   public String getTelefoneExtenso()
   {
      return telefoneExtenso;
   }

   public void setTelefoneExtenso(String telefoneExtenso)
   {
      this.telefoneExtenso = telefoneExtenso;
   }

   public Boolean getFlagTrabalhadorInformal()
   {
      return flagTrabalhadorInformal;
   }

   public void setFlagTrabalhadorInformal(Boolean flagTrabalhadorInformal)
   {
      this.flagTrabalhadorInformal = flagTrabalhadorInformal;
   }

   public Boolean getFlagTrabalhadorFormal()
   {
      return flagTrabalhadorFormal;
   }

   public void setFlagTrabalhadorFormal(Boolean flagTrabalhadorFormal)
   {
      this.flagTrabalhadorFormal = flagTrabalhadorFormal;
   }

   public Set<TrabalhadorLogDTO> getListaTrabalhadorLog()
   {
      return listaTrabalhadorLog;
   }

   public void setListaTrabalhadorLog(Set<TrabalhadorLogDTO> listaTrabalhadorLog)
   {
      this.listaTrabalhadorLog = listaTrabalhadorLog;
   }

   public List<TrabalhadorLogDTO> getListaTrabalhadorLogOrdenada()
   {
      return listaTrabalhadorLogOrdenada;
   }

   public void setListaTrabalhadorLogOrdenada(List<TrabalhadorLogDTO> listaTrabalhadorLogOrdenada)
   {
      this.listaTrabalhadorLogOrdenada = listaTrabalhadorLogOrdenada;
   }

   public String getObservacao()
   {
      return observacao;
   }

   public void setObservacao(String observacao)
   {
      this.observacao = observacao;
   }

   public List<TrabalhadorRejeicaoDTO> getListaTrabalhadorRejeicao() {
      return listaTrabalhadorRejeicao;
   }

   public void setListaTrabalhadorRejeicao(List<TrabalhadorRejeicaoDTO> listaTrabalhadorRejeicao) {
      this.listaTrabalhadorRejeicao = listaTrabalhadorRejeicao;
   }

   public List<TrabalhadorPresencaDTO> getListaTrabalhadorPresenca() {
      return listaTrabalhadorPresenca;
   }

   public void setListaTrabalhadorPresenca(List<TrabalhadorPresencaDTO> listaTrabalhadorPresenca) {
      this.listaTrabalhadorPresenca = listaTrabalhadorPresenca;
   }
}
