package br.com.aptare.cefit.profissional.dto;

public class ProfissionalQualificacaoDTO
{
   private Long codigo;

   private Long codigoProfissional;

   private Long codigoQualificacao;

   private String descricaoQualificacao;

   public Long getCodigo()
   {
      return codigo;
   }

   public void setCodigo(Long codigo)
   {
      this.codigo = codigo;
   }

   public Long getCodigoProfissional()
   {
      return codigoProfissional;
   }

   public void setCodigoProfissional(Long codigoProfissional)
   {
      this.codigoProfissional = codigoProfissional;
   }

   public Long getCodigoQualificacao()
   {
      return codigoQualificacao;
   }

   public void setCodigoQualificacao(Long codigoQualificacao)
   {
      this.codigoQualificacao = codigoQualificacao;
   }

   public String getDescricaoQualificacao()
   {
      return descricaoQualificacao;
   }

   public void setDescricaoQualificacao(String descricaoQualificacao)
   {
      this.descricaoQualificacao = descricaoQualificacao;
   }
}
