package br.com.aptare.cefit.trabalhador.dto;

public class CboDTO
{
   private Long codigo;
   
   private String nome;
   
   private String nomeCodigo;

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

   public String getNomeCodigo()
   {
      return nomeCodigo;
   }

   public void setNomeCodigo(String nomeCodigo)
   {
      this.nomeCodigo = nomeCodigo;
   }
   
}
