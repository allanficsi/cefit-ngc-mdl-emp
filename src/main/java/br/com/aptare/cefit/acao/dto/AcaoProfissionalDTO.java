package br.com.aptare.cefit.acao.dto;

import br.com.aptare.cefit.profissional.dto.ProfissionalDTO;

public class AcaoProfissionalDTO
{
   private Long codigo;

   private Long codigoAcao;
   
   private Long codigoProfissional;
   
   private ProfissionalDTO profissional;
   
   public Long getCodigo()
   {
      return codigo;
   }

   public void setCodigo(Long codigo)
   {
      this.codigo = codigo;
   }

   public Long getCodigoAcao()
   {
      return codigoAcao;
   }

   public void setCodigoAcao(Long codigoAcao)
   {
      this.codigoAcao = codigoAcao;
   }

   public Long getCodigoProfissional()
   {
      return codigoProfissional;
   }

   public void setCodigoProfissional(Long codigoProfissional)
   {
      this.codigoProfissional = codigoProfissional;
   }

   public ProfissionalDTO getProfissional()
   {
      return profissional;
   }

   public void setProfissional(ProfissionalDTO profissional)
   {
      this.profissional = profissional;
   }
}
