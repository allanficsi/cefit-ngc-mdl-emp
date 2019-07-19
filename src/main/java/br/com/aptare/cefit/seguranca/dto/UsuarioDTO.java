package br.com.aptare.cefit.seguranca.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.aptare.cefit.cadastroUnico.dto.CadastroUnicoDTO;
import br.com.aptare.cefit.trabalhador.dto.DocumentoDTO;

public class UsuarioDTO implements Serializable
{
   private static final long serialVersionUID = -3869083358867288336L;

   private Long codigo;

   private String nome;

   private String login;

   private String senha;

   private Long codigoCadastroUnico;

   private Long celular;

   private Date dataNascimento;

   private Long cpf1;

   private Date dataNascimento1;

   private Long codigoTrabalhador;

   //private CadastroUnicoDTO  cadastroUnico;

   private List<DocumentoDTO> listaDocumento;

   public Long getCodigo()
   {
      return codigo;
   }

   public void setCodigo(Long codigo)
   {
      this.codigo = codigo;
   }

   public String getLogin()
   {
      return login;
   }

   public void setLogin(String login)
   {
      this.login = login;
   }

   public String getSenha()
   {
      return senha;
   }

   public void setSenha(String senha)
   {
      this.senha = senha;
   }

   public Long getCodigoCadastroUnico()
   {
      return codigoCadastroUnico;
   }

   public void setCodigoCadastroUnico(Long codigoCadastroUnico)
   {
      this.codigoCadastroUnico = codigoCadastroUnico;
   }

   public String getNome()
   {
      return nome;
   }

   public void setNome(String nome)
   {
      this.nome = nome;
   }

   public Long getCelular()
   {
      return celular;
   }

   public void setCelular(Long celular)
   {
      this.celular = celular;
   }

   public Date getDataNascimento()
   {
      return dataNascimento;
   }

   public void setDataNascimento(Date dataNascimento)
   {
      this.dataNascimento = dataNascimento;
   }

   public Long getCpf1()
   {
      return cpf1;
   }

   public void setCpf1(Long cpf)
   {
      this.cpf1 = cpf;
   }

   public Long getCodigoTrabalhador()
   {
      return codigoTrabalhador;
   }

   public void setCodigoTrabalhador(Long codigoTrabalhador)
   {
      this.codigoTrabalhador = codigoTrabalhador;
   }

   public List<DocumentoDTO> getListaDocumento()
   {
      return listaDocumento;
   }

   public void setListaDocumento(List<DocumentoDTO> listaDocumento)
   {
      this.listaDocumento = listaDocumento;
   }

   public Date getDataNascimento1() {
      return dataNascimento1;
   }

   public void setDataNascimento1(Date dataNascimento1) {
      this.dataNascimento1 = dataNascimento1;
   }

   //   public CadastroUnicoDTO getCadastroUnico() {
//      return cadastroUnico;
//   }
//
//   public void setCadastroUnico(CadastroUnicoDTO cadastroUnico) {
//      this.cadastroUnico = cadastroUnico;
//   }
}
