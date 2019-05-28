package br.com.aptare.cefit.vagas.dto;

import java.io.Serializable;

import br.com.aptare.cefit.common.dto.AuditoriaDTO;
import br.com.aptare.cefit.trabalhador.entity.Trabalhador;
import br.com.aptare.cefit.vagas.entity.Vaga;

public class EncaminhamentoNaoAtendidoDTO implements Serializable
{
   private static final long serialVersionUID = 8059018496629414759L;

   private Long codigo;

   private Long codigoTrabalhador;
   
   private Trabalhador trabalhadorEntity;
   
   private Long codigoVaga;
   
   private Vaga vagaEntity;
   
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

   public Trabalhador getTrabalhadorEntity()
   {
      return trabalhadorEntity;
   }

   public void setTrabalhadorEntity(Trabalhador trabalhadorEntity)
   {
      this.trabalhadorEntity = trabalhadorEntity;
   }

   public Long getCodigoVaga()
   {
      return codigoVaga;
   }

   public void setCodigoVaga(Long codigoVaga)
   {
      this.codigoVaga = codigoVaga;
   }

   public Vaga getVagaEntity()
   {
      return vagaEntity;
   }

   public void setVagaEntity(Vaga vagaEntity)
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
