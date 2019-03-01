package br.com.aptare.cefit.geral.dto;

import java.io.Serializable;
import java.util.Date;

import br.com.aptare.cefit.common.dto.AuditoriaDTO;

public class FeriadoDTO  implements Serializable
{
   private static final long serialVersionUID = 8059018496629414759L;

   private Date dataFeriado;
   
   private String descricao;
   
   private AuditoriaDTO auditoria;

   public Date getDataFeriado()
   {
      return dataFeriado;
   }

   public void setDataFeriado(Date dataFeriado)
   {
      this.dataFeriado = dataFeriado;
   }

   public String getDescricao()
   {
      return descricao;
   }

   public void setDescricao(String descricao)
   {
      this.descricao = descricao;
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
