package br.com.aptare.cefit.cadastroUnico.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class PessoaFisicaDTO implements Serializable
{
   private static final long serialVersionUID = 1L;

   private Long codigoCadastroUnico;

   private Long registroGeral;

   private String nomeMae;

   private Date dataNascimento;

   private String sexo;

   private Date dataEmissaoRg;

   private String orgaoEmissorRg;

   private String ufOrgaoEmissorRg;

   private String naturalidade;

   private String ufNaturalidade;

   private String nacionalidade;

   private Integer estadoCivil;

   private String descricaoEstadoCivil;

   private String identificadorPrincipal;
   
   private Set<TelefoneDTO> listaTelefone;

   public Long getCodigoCadastroUnico()
   {
      return codigoCadastroUnico;
   }

   public void setCodigoCadastroUnico(Long codigoCadastroUnico)
   {
      this.codigoCadastroUnico = codigoCadastroUnico;
   }

   public Long getRegistroGeral()
   {
      return registroGeral;
   }

   public void setRegistroGeral(Long registroGeral)
   {
      this.registroGeral = registroGeral;
   }

   public String getNomeMae()
   {
      return nomeMae;
   }

   public void setNomeMae(String nomeMae)
   {
      this.nomeMae = nomeMae;
   }

   public Date getDataNascimento()
   {
      return dataNascimento;
   }

   public void setDataNascimento(Date dataNascimento)
   {
      this.dataNascimento = dataNascimento;
   }

   public String getSexo()
   {
      return sexo;
   }

   public void setSexo(String sexo)
   {
      this.sexo = sexo;
   }

   public Date getDataEmissaoRg()
   {
      return dataEmissaoRg;
   }

   public void setDataEmissaoRg(Date dataEmissaoRg)
   {
      this.dataEmissaoRg = dataEmissaoRg;
   }

   public String getOrgaoEmissorRg()
   {
      return orgaoEmissorRg;
   }

   public void setOrgaoEmissorRg(String orgaoEmissorRg)
   {
      this.orgaoEmissorRg = orgaoEmissorRg;
   }

   public String getUfOrgaoEmissorRg()
   {
      return ufOrgaoEmissorRg;
   }

   public void setUfOrgaoEmissorRg(String ufOrgaoEmissorRg)
   {
      this.ufOrgaoEmissorRg = ufOrgaoEmissorRg;
   }

   public String getNaturalidade()
   {
      return naturalidade;
   }

   public void setNaturalidade(String naturalidade)
   {
      this.naturalidade = naturalidade;
   }

   public String getUfNaturalidade()
   {
      return ufNaturalidade;
   }

   public void setUfNaturalidade(String ufNaturalidade)
   {
      this.ufNaturalidade = ufNaturalidade;
   }

   public String getNacionalidade()
   {
      return nacionalidade;
   }

   public void setNacionalidade(String nacionalidade)
   {
      this.nacionalidade = nacionalidade;
   }

   public Integer getEstadoCivil()
   {
      return estadoCivil;
   }

   public void setEstadoCivil(Integer estadoCivil)
   {
      this.estadoCivil = estadoCivil;
   }

   public String getDescricaoEstadoCivil()
   {
      return descricaoEstadoCivil;
   }

   public void setDescricaoEstadoCivil(String descricaoEstadoCivil)
   {
      this.descricaoEstadoCivil = descricaoEstadoCivil;
   }

   public String getIdentificadorPrincipal()
   {
      return identificadorPrincipal;
   }

   public void setIdentificadorPrincipal(String identificadorPrincipal)
   {
      this.identificadorPrincipal = identificadorPrincipal;
   }

   public Set<TelefoneDTO> getListaTelefone()
   {
      return listaTelefone;
   }

   public void setListaTelefone(Set<TelefoneDTO> listaTelefone)
   {
      this.listaTelefone = listaTelefone;
   }

}
