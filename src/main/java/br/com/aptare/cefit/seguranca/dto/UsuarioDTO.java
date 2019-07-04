package br.com.aptare.cefit.seguranca.dto;

import br.com.aptare.cefit.empregador.dto.EmpregadorDTO;

import java.io.Serializable;
import java.util.Date;

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
   
   private Long cpf;

   private Long codigoTrabalhador;

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

   public Long getCpf()
   {
      return cpf;
   }

   public void setCpf(Long cpf)
   {
      this.cpf = cpf;
   }

   public Long getCodigoTrabalhador() {
      return codigoTrabalhador;
   }

   public void setCodigoTrabalhador(Long codigoTrabalhador) {
      this.codigoTrabalhador = codigoTrabalhador;
   }
}
