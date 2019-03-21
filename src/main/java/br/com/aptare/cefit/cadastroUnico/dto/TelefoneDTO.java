package br.com.aptare.cefit.cadastroUnico.dto;

import java.io.Serializable;

import br.com.aptare.cefit.common.dto.AuditoriaDTO;

public class TelefoneDTO implements Serializable
{
   private static final long serialVersionUID = 1L;

   private Long codigo;
   
   private Integer ddd;
   
   private Integer numero;
   
   private Integer tipo;
   
   private Long nsuOrigem;
   
   private String flagAtivo;
   
   private Boolean flagWhats;
   
   private String descricaoTipo;

   private AuditoriaDTO auditoria;
   
   public Long getCodigo()
   {
      return codigo;
   }

   public void setCodigo(Long codigo)
   {
      this.codigo = codigo;
   }

   public Integer getDdd()
   {
      return ddd;
   }

   public void setDdd(Integer ddd)
   {
      this.ddd = ddd;
   }

   public Integer getNumero()
   {
      return numero;
   }

   public void setNumero(Integer numero)
   {
      this.numero = numero;
   }

   public Integer getTipo()
   {
      return tipo;
   }

   public void setTipo(Integer tipo)
   {
      this.tipo = tipo;
   }

   public Long getNsuOrigem()
   {
      return nsuOrigem;
   }

   public void setNsuOrigem(Long nsuOrigem)
   {
      this.nsuOrigem = nsuOrigem;
   }

   public String getFlagAtivo()
   {
      return flagAtivo;
   }

   public void setFlagAtivo(String flagAtivo)
   {
      this.flagAtivo = flagAtivo;
   }

   public String getDescricaoTipo()
   {
      return descricaoTipo;
   }

   public void setDescricaoTipo(String descricaoTipo)
   {
      this.descricaoTipo = descricaoTipo;
   }

   public AuditoriaDTO getAuditoria()
   {
      return auditoria;
   }

   public void setAuditoria(AuditoriaDTO auditoria)
   {
      this.auditoria = auditoria;
   }

   public Boolean getFlagWhats()
   {
      return flagWhats;
   }

   public void setFlagWhats(Boolean flagWhats)
   {
      this.flagWhats = flagWhats;
   }
}
