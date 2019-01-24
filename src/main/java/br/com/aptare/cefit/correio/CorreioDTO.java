package br.com.aptare.cefit.correio;

public class CorreioDTO
{
   private Integer cep;
   
   private String cepFormatado;
   
   private String logradouro;
   
   private String bairro;
   
   private String localidade;
   
   private String uf;
   

   public Integer getCep()
   {
      return cep;
   }

   public void setCep(Integer cep)
   {
      this.cep = cep;
   }

   public String getCepFormatado()
   {
      return cepFormatado;
   }

   public void setCepFormatado(String cepFormatado)
   {
      this.cepFormatado = cepFormatado;
   }

   public String getLogradouro()
   {
      return logradouro;
   }

   public void setLogradouro(String logradouro)
   {
      this.logradouro = logradouro;
   }

   public String getBairro()
   {
      return bairro;
   }

   public void setBairro(String bairro)
   {
      this.bairro = bairro;
   }

   public String getLocalidade()
   {
      return localidade;
   }

   public void setLocalidade(String localidade)
   {
      this.localidade = localidade;
   }

   public String getUf()
   {
      return uf;
   }

   public void setUf(String uf)
   {
      this.uf = uf;
   }
}
