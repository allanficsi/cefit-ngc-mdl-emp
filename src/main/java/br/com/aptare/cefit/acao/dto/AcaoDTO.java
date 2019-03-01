package br.com.aptare.cefit.acao.dto;

import br.com.aptare.cefit.common.dto.AuditoriaDTO;
import br.com.aptare.cefit.espaco.entity.Espaco;

public class AcaoDTO
{
   private Long codigo;

   private Long codigoEspaco;
   
   private Espaco espaco;
   
   private String nome;
   
   private Long codigoTipoAcao;
   
   private Long numeroVagas;
   
   private Boolean flagValeTransporte;
   
   private Boolean flagValeRefeicao;
   
   private String observacao;
   
   private Long codigoAgendamento;
   
   private Long situacao;
   
   private AuditoriaDTO auditoria;

   public Long getCodigo()
   {
      return codigo;
   }

   public void setCodigo(Long codigo)
   {
      this.codigo = codigo;
   }

   public Long getCodigoEspaco()
   {
      return codigoEspaco;
   }

   public void setCodigoEspaco(Long codigoEspaco)
   {
      this.codigoEspaco = codigoEspaco;
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

   public Long getCodigoTipoAcao()
   {
      return codigoTipoAcao;
   }

   public void setCodigoTipoAcao(Long codigoTipoAcao)
   {
      this.codigoTipoAcao = codigoTipoAcao;
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
}
