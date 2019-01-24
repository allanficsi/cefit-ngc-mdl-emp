package br.com.aptare.cefit.common.dto;

import java.util.Date;

import br.com.aptare.cefit.seguranca.dto.UsuarioDTO;
import br.com.aptare.seguranca.entidade.Usuario;

public class AuditoriaDTO
{
   private Long codigoUsuarioInclusao;

   private Date dataInclusao;

   private Long codigoUsuarioAlteracao;

   private Date dataAlteracao;

   private UsuarioDTO usuarioInclusao;

   private UsuarioDTO usuarioAlteracao;
   

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

   public Long getCodigoUsuarioAlteracao()
   {
      return codigoUsuarioAlteracao;
   }

   public void setCodigoUsuarioAlteracao(Long codigoUsuarioAlteracao)
   {
      this.codigoUsuarioAlteracao = codigoUsuarioAlteracao;
   }

   public Date getDataAlteracao()
   {
      return dataAlteracao;
   }

   public void setDataAlteracao(Date dataAlteracao)
   {
      this.dataAlteracao = dataAlteracao;
   }

   public UsuarioDTO getUsuarioInclusao()
   {
      return usuarioInclusao;
   }

   public void setUsuarioInclusao(UsuarioDTO usuarioInclusao)
   {
      this.usuarioInclusao = usuarioInclusao;
   }

   public UsuarioDTO getUsuarioAlteracao()
   {
      return usuarioAlteracao;
   }

   public void setUsuarioAlteracao(UsuarioDTO usuarioAlteracao)
   {
      this.usuarioAlteracao = usuarioAlteracao;
   }
}
