package br.com.aptare.cefit.vagas.dto;

import java.io.Serializable;

import br.com.aptare.cefit.common.dto.AuditoriaDTO;
import br.com.aptare.cefit.trabalhador.dto.TrabalhadorDTO;

public class EncaminhamentoNaoAtendidoDTO implements Serializable
{
   private static final long serialVersionUID = 8059018496629414759L;

   private Long codigo;

   private Long codigoTrabalhador;
   
   private TrabalhadorDTO trabalhador;
   
   private Long codigoVaga;
   
   private VagaDTO vagaEntity;
   
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

   public TrabalhadorDTO getTrabalhador()
   {
      return trabalhador;
   }

   public void setTrabalhador(TrabalhadorDTO trabalhador)
   {
      this.trabalhador = trabalhador;
   }

   public Long getCodigoVaga()
   {
      return codigoVaga;
   }

   public void setCodigoVaga(Long codigoVaga)
   {
      this.codigoVaga = codigoVaga;
   }

   public VagaDTO getVagaEntity()
   {
      return vagaEntity;
   }

   public void setVagaEntity(VagaDTO vagaEntity)
   {
      this.vagaEntity = vagaEntity;
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
