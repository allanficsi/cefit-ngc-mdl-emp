package br.com.aptare.cefit.painelEletronico.dto;

import java.io.Serializable;
import java.util.Date;

public class ChamadaDTO implements Serializable
{
   private static final long serialVersionUID = 1L;

   private Long codigo;

   private Long codigoSenha;
   
   private SenhaDTO senha;

   private Long codigoGuiche;
   
   private GuicheDTO guiche;

   private Long codigoUsuarioInclusao;

   private Date dataInclusao;
   
   private Date data;

   public Long getCodigo()
   {
      return codigo;
   }

   public void setCodigo(Long codigo)
   {
      this.codigo = codigo;
   }

   public Long getCodigoSenha()
   {
      return codigoSenha;
   }

   public void setCodigoSenha(Long codigoSenha)
   {
      this.codigoSenha = codigoSenha;
   }

   public Long getCodigoGuiche()
   {
      return codigoGuiche;
   }

   public void setCodigoGuiche(Long codigoGuiche)
   {
      this.codigoGuiche = codigoGuiche;
   }

   public Long getCodigoUsuarioInclusao()
   {
      return codigoUsuarioInclusao;
   }

   public void setCodigoUsuarioInclusao(Long codigoUsuarioInclusao)
   {
      this.codigoUsuarioInclusao = codigoUsuarioInclusao;
   }

   public Date getDataInclusao()
   {
      return dataInclusao;
   }

   public void setDataInclusao(Date dataInclusao)
   {
      this.dataInclusao = dataInclusao;
   }

   public SenhaDTO getSenha()
   {
      return senha;
   }

   public void setSenha(SenhaDTO senha)
   {
      this.senha = senha;
   }

   public GuicheDTO getGuiche()
   {
      return guiche;
   }

   public void setGuiche(GuicheDTO guiche)
   {
      this.guiche = guiche;
   }

   public Date getData()
   {
      return data;
   }

   public void setData(Date data)
   {
      this.data = data;
   }
}
