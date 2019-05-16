package br.com.aptare.cefit.vagas.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

public class VagaLogDTO implements Serializable
{
   private static final long serialVersionUID = 1431211184645188934L;

   private Long codigo;

   private Long situacaoAnterior;
   
   private Long situacaoNova;
   
   private Date dataOperacao;
   
   private Long codigoUsuarioOperacao;

   public Long getCodigo()
   {
      return codigo;
   }

   public void setCodigo(Long codigo)
   {
      this.codigo = codigo;
   }

   public Long getSituacaoAnterior()
   {
      return situacaoAnterior;
   }

   public void setSituacaoAnterior(Long situacaoAnterior)
   {
      this.situacaoAnterior = situacaoAnterior;
   }

   public Long getSituacaoNova()
   {
      return situacaoNova;
   }

   public void setSituacaoNova(Long situacaoNova)
   {
      this.situacaoNova = situacaoNova;
   }

   public Date getDataOperacao()
   {
      return dataOperacao;
   }

   public void setDataOperacao(Date dataOperacao)
   {
      this.dataOperacao = dataOperacao;
   }

   public Long getCodigoUsuarioOperacao()
   {
      return codigoUsuarioOperacao;
   }

   public void setCodigoUsuarioOperacao(Long codigoUsuarioOperacao)
   {
      this.codigoUsuarioOperacao = codigoUsuarioOperacao;
   }

   
}
