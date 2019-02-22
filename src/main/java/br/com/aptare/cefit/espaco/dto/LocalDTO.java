package br.com.aptare.cefit.espaco.dto;

import java.io.Serializable;

import br.com.aptare.cefit.common.dto.AuditoriaDTO;

public class LocalDTO implements Serializable
{
   private static final long serialVersionUID = 1431211184645188934L;

   private Long codigo;

   private String nome;
   
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

   public String getNome()
   {
      return nome;
   }

   public void setNome(String nome)
   {
      this.nome = nome;
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
