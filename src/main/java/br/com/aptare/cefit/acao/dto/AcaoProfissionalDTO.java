package br.com.aptare.cefit.acao.dto;

import br.com.aptare.cefit.profissional.dto.ProfissionalDTO;

public class AcaoProfissionalDTO
{
   private Long codigo;

   private Long codigoAca;
   
   private Long codigoPrf;
   
   private ProfissionalDTO profissional;
   
   public Long getCodigo()
   {
      return codigo;
   }

   public void setCodigo(Long codigo)
   {
      this.codigo = codigo;
   }

   public Long getCodigoAca()
   {
      return codigoAca;
   }

   public void setCodigoAca(Long codigoAca)
   {
      this.codigoAca = codigoAca;
   }

   public Long getCodigoPrf()
   {
      return codigoPrf;
   }

   public void setCodigoPrf(Long codigoPrf)
   {
      this.codigoPrf = codigoPrf;
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
