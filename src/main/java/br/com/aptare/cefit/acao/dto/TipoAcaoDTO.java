package br.com.aptare.cefit.acao.dto;

import java.io.Serializable;

import br.com.aptare.cefit.common.dto.AuditoriaDTO;

public class TipoAcaoDTO implements Serializable
{
   private static final long serialVersionUID = 7544590941957672636L;

   private Long codigo;

   private String descricao;
   
   private String flagAtivo;

   private AuditoriaDTO auditoria;
   
   private List<AcaoDTO> listaAcao;

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

   public List<AcaoDTO> getListaAcao()
   {
      return listaAcao;
   }

   public void setListaAcao(List<AcaoDTO> listaAcao)
   {
      this.listaAcao = listaAcao;
   }
}
