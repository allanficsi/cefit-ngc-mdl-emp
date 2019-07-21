package br.com.aptare.cefit.trabalhador.dto;

public class TrabalhadorCboDTO
{
   private Long codigo;
   
   private Long codigoTrabalhador;

   private Long codigoCbo;
   
   private String descricaoCbo;
   
   private CboDTO cbo;
   
   private String nome;

   private Long codigoExperiencia;

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

   public Long getCodigoCbo()
   {
      return codigoCbo;
   }

   public void setCodigoCbo(Long codigoCbo)
   {
      this.codigoCbo = codigoCbo;
   }

   public String getNome()
   {
      return nome;
   }

   public void setNome(String nome)
   {
      this.nome = nome;
   }

   public Long getCodigoExperiencia() {
      return codigoExperiencia;
   }

   public void setCodigoExperiencia(Long codigoExperiencia) {
      this.codigoExperiencia = codigoExperiencia;
   }

   public CboDTO getCbo()
   {
      return cbo;
   }

   public void setCbo(CboDTO cbo)
   {
      this.cbo = cbo;
   }

   public String getDescricaoCbo()
   {
      return descricaoCbo;
   }

   public void setDescricaoCbo(String descricaoCbo)
   {
      this.descricaoCbo = descricaoCbo;
   }
}
