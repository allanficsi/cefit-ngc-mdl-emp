package br.com.aptare.cefit.vagas.dto;

import java.io.Serializable;
import java.util.Date;

import br.com.aptare.cefit.common.dto.AuditoriaDTO;
import br.com.aptare.cefit.trabalhador.dto.TrabalhadorDTO;

public class EncaminhamentoDTO implements Serializable
{
   private static final long serialVersionUID = 8059018496629414759L;

   private Long codigo;

   private Long codigoTrabalhador;
   
   private TrabalhadorDTO trabalhador;
   
   private Long codigoVaga;
   
   private VagaDTO vaga;
   
   private String flagAtivo;
   
   private Date dataCancelamento;
   
   private Long codigoUsuarioCancelamento;
   
   private AuditoriaDTO auditoria;

   public Long getCodigo()
   {
      return codigo;
   }

   public void setCodigo(Long codigo)
   {
      this.codigo = codigo;
   }

   public Long getCodigoTrabalhador()
   {
      return codigoTrabalhador;
   }

   public void setCodigoTrabalhador(Long codigoTrabalhador)
   {
      this.codigoTrabalhador = codigoTrabalhador;
   }

   public Long getCodigoVaga()
   {
      return codigoVaga;
   }

   public void setCodigoVaga(Long codigoVaga)
   {
      this.codigoVaga = codigoVaga;
   }

   public AuditoriaDTO getAuditoria()
   {
      return auditoria;
   }

   public void setAuditoria(AuditoriaDTO auditoria)
   {
      this.auditoria = auditoria;
   }

   public TrabalhadorDTO getTrabalhador()
   {
      return trabalhador;
   }

   public void setTrabalhador(TrabalhadorDTO trabalhador)
   {
      this.trabalhador = trabalhador;
   }

   public VagaDTO getVaga()
   {
      return vaga;
   }

   public void setVaga(VagaDTO vaga)
   {
      this.vaga = vaga;
   }

   public String getFlagAtivo()
   {
      return flagAtivo;
   }

   public void setFlagAtivo(String flagAtivo)
   {
      this.flagAtivo = flagAtivo;
   }

   public Date getDataCancelamento()
   {
      return dataCancelamento;
   }

   public void setDataCancelamento(Date dataCancelamento)
   {
      this.dataCancelamento = dataCancelamento;
   }

   public Long getCodigoUsuarioCancelamento()
   {
      return codigoUsuarioCancelamento;
   }

   public void setCodigoUsuarioCancelamento(Long codigoUsuarioCancelamento)
   {
      this.codigoUsuarioCancelamento = codigoUsuarioCancelamento;
   }
}
