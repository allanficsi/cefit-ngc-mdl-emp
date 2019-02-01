package br.com.aptare.cefit.trabalhador.dto;

public class TrabalhadorDeficienciaDTO
{
   private Long codigo;
   
   private Long codigoTrabalhador;

   private Long codigoDeficiencia;
   
   private String descricaoDeficiencia;
   
   private String nome;

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

   public Long getCodigoDeficiencia()
   {
      return codigoDeficiencia;
   }

   public void setCodigoDeficiencia(Long codigoDeficiencia)
   {
      this.codigoDeficiencia = codigoDeficiencia;
   }

   public String getNome()
   {
      return nome;
   }

   public void setNome(String nome)
   {
      this.nome = nome;
   }

   public String getDescricaoDeficiencia()
   {
      return descricaoDeficiencia;
   }

   public void setDescricaoDeficiencia(String descricaoDeficiencia)
   {
      this.descricaoDeficiencia = descricaoDeficiencia;
   }
}
