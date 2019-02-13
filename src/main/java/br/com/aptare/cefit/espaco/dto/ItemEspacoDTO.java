package br.com.aptare.cefit.espaco.dto;

import java.io.Serializable;

import br.com.aptare.cefit.common.dto.AuditoriaDTO;

public class ItemEspacoDTO implements Serializable
{
   private static final long serialVersionUID = 1431211184645188934L;

   private Long codigo;

   private String descricao;
   
   private String flagAtivo;

   private AuditoriaDTO auditoria;

   
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

   public String getFlagAtivo()
   {
      return flagAtivo;
   }

   public void setFlagAtivo(String flagAtivo)
   {
      this.flagAtivo = flagAtivo;
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
