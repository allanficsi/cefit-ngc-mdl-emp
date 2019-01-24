package br.com.aptare.cefit.cadastroUnico.dto;

import java.util.Set;

public class CadastroUnicoDTO
{
   private Long codigo;

   private String nome;

   private String email;

   private String tipoPessoa;

   private Long cpfCnpj;

   private PessoaJuridicaDTO pessoaJuridica;

   private PessoaFisicaDTO pessoaFisica;

   private String cpf;

   private String cnpj;
   
   private Set<EnderecoDTO> listaEndereco;

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

   public String getEmail()
   {
      return email;
   }

   public void setEmail(String email)
   {
      this.email = email;
   }

   public String getTipoPessoa()
   {
      return tipoPessoa;
   }

   public void setTipoPessoa(String tipoPessoa)
   {
      this.tipoPessoa = tipoPessoa;
   }

   public Long getCpfCnpj()
   {
      return cpfCnpj;
   }

   public void setCpfCnpj(Long cpfCnpj)
   {
      this.cpfCnpj = cpfCnpj;
   }

   public PessoaJuridicaDTO getPessoaJuridica()
   {
      return pessoaJuridica;
   }

   public void setPessoaJuridica(PessoaJuridicaDTO pessoaJuridica)
   {
      this.pessoaJuridica = pessoaJuridica;
   }

   public PessoaFisicaDTO getPessoaFisica()
   {
      return pessoaFisica;
   }

   public void setPessoaFisica(PessoaFisicaDTO pessoaFisica)
   {
      this.pessoaFisica = pessoaFisica;
   }

   public String getCpf()
   {
      return cpf;
   }

   public void setCpf(String cpf)
   {
      this.cpf = cpf;
   }

   public String getCnpj()
   {
      return cnpj;
   }

   public void setCnpj(String cnpj)
   {
      this.cnpj = cnpj;
   }

   public Set<EnderecoDTO> getListaEndereco()
   {
      return listaEndereco;
   }

   public void setListaEndereco(Set<EnderecoDTO> listaEndereco)
   {
      this.listaEndereco = listaEndereco;
   }
}
