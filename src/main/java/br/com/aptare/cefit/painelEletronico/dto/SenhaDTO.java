package br.com.aptare.cefit.painelEletronico.dto;

import java.io.Serializable;
import java.util.Date;

public class SenhaDTO implements Serializable
{
   private static final long serialVersionUID = 1L;

   private Long codigo;

   private Long codigoTipoSenha;

   private Long numero;

   private String descricao;

   private Date data;

   private Date dataInclusao;
   
   private Boolean flagAtivo;
   
   private Date dataAlteracao;
   
   private Long codigoUsuarioAlteracao;

   public Long getCodigo()
   {
      return codigo;
   }

   public void setCodigo(Long codigo)
   {
      this.codigo = codigo;
   }

   public Long getCodigoTipoSenha()
   {
      return codigoTipoSenha;
   }

   public void setCodigoTipoSenha(Long codigoTipoSenha)
   {
      this.codigoTipoSenha = codigoTipoSenha;
   }

   public Long getNumero()
   {
      return numero;
   }

   public void setNumero(Long numero)
   {
      this.numero = numero;
   }

   public String getDescricao()
   {
      return descricao;
   }

   public void setDescricao(String descricao)
   {
      this.descricao = descricao;
   }

   public Date getData()
   {
      return data;
   }

   public void setData(Date data)
   {
      this.data = data;
   }

   public Date getDataInclusao()
   {
      return dataInclusao;
   }

   public void setDataInclusao(Date dataInclusao)
   {
      this.dataInclusao = dataInclusao;
   }

   public Boolean getFlagAtivo()
   {
      return flagAtivo;
   }

   public void setFlagAtivo(Boolean flagAtivo)
   {
      this.flagAtivo = flagAtivo;
   }

   public Date getDataAlteracao()
   {
      return dataAlteracao;
   }

   public void setDataAlteracao(Date dataAlteracao)
   {
      this.dataAlteracao = dataAlteracao;
   }

   public Long getCodigoUsuarioAlteracao()
   {
      return codigoUsuarioAlteracao;
   }

   public void setCodigoUsuarioAlteracao(Long codigoUsuarioAlteracao)
   {
      this.codigoUsuarioAlteracao = codigoUsuarioAlteracao;
   }
}
