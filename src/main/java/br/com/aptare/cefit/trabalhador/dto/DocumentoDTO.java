package br.com.aptare.cefit.trabalhador.dto;

import java.io.Serializable;

public class DocumentoDTO implements Serializable
{
   
   private static final long serialVersionUID = -446357010773990960L;

   private Long codigo;
   
   private Long codigoTrabalhador;
   
   private Integer tipo;
   
   private String descricaoTipo;
   
   private Long codigoUsuario;
   
   private String base64;
   
   private String flagExisteArquivo;

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

   public Integer getTipo()
   {
      return tipo;
   }

   public void setTipo(Integer tipo)
   {
      this.tipo = tipo;
   }

   public String getDescricaoTipo()
   {
      return descricaoTipo;
   }

   public void setDescricaoTipo(String descricaoTipo)
   {
      this.descricaoTipo = descricaoTipo;
   }

   public Long getCodigoUsuario()
   {
      return codigoUsuario;
   }

   public void setCodigoUsuario(Long codigoUsuario)
   {
      this.codigoUsuario = codigoUsuario;
   }

   public String getBase64()
   {
      return base64;
   }

   public void setBase64(String base64)
   {
      this.base64 = base64;
   }

   public String getFlagExisteArquivo()
   {
      return flagExisteArquivo;
   }

   public void setFlagExisteArquivo(String flagExisteArquivo)
   {
      this.flagExisteArquivo = flagExisteArquivo;
   }
   
}
