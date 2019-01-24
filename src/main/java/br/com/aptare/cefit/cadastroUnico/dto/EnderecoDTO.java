package br.com.aptare.cefit.cadastroUnico.dto;

import br.com.aptare.cefit.common.dto.AuditoriaDTO;
import br.com.aptare.cefit.correio.CorreioDTO;

public class EnderecoDTO
{
   private Long codigo;

   private Long codigoCadastroUnico;

   private Integer cep;

   private String cepFormatado;

   private String numero;

   private String complemento;

   private String flagAtivo;

   private Integer tipo;

   private String descricaoTipo;

   private ExtensaoEnderecoDTO extensaoEndereco;

   private CorreioDTO correio;

   private AuditoriaDTO auditoria;

   private String enderecoCompleto;

   private String logradouroGenerico;

   private String pontoReferencia;

   public Long getCodigo()
   {
      return codigo;
   }

   public void setCodigo(Long codigo)
   {
      this.codigo = codigo;
   }

   public Long getCodigoCadastroUnico()
   {
      return codigoCadastroUnico;
   }

   public void setCodigoCadastroUnico(Long codigoCadastroUnico)
   {
      this.codigoCadastroUnico = codigoCadastroUnico;
   }

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

   public String getNumero()
   {
      return numero;
   }

   public void setNumero(String numero)
   {
      this.numero = numero;
   }

   public String getComplemento()
   {
      return complemento;
   }

   public void setComplemento(String complemento)
   {
      this.complemento = complemento;
   }

   public String getFlagAtivo()
   {
      return flagAtivo;
   }

   public void setFlagAtivo(String flagAtivo)
   {
      this.flagAtivo = flagAtivo;
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

   public ExtensaoEnderecoDTO getExtensaoEndereco()
   {
      return extensaoEndereco;
   }

   public void setExtensaoEndereco(ExtensaoEnderecoDTO extensaoEndereco)
   {
      this.extensaoEndereco = extensaoEndereco;
   }

   public AuditoriaDTO getAuditoria()
   {
      return auditoria;
   }

   public void setAuditoria(AuditoriaDTO auditoria)
   {
      this.auditoria = auditoria;
   }

   public String getEnderecoCompleto()
   {
      return enderecoCompleto;
   }

   public void setEnderecoCompleto(String enderecoCompleto)
   {
      this.enderecoCompleto = enderecoCompleto;
   }

   public String getLogradouroGenerico()
   {
      return logradouroGenerico;
   }

   public void setLogradouroGenerico(String logradouroGenerico)
   {
      this.logradouroGenerico = logradouroGenerico;
   }

   public CorreioDTO getCorreio()
   {
      return correio;
   }

   public void setCorreio(CorreioDTO correio)
   {
      this.correio = correio;
   }

   public String getPontoReferencia()
   {
      return pontoReferencia;
   }

   public void setPontoReferencia(String pontoReferencia)
   {
      this.pontoReferencia = pontoReferencia;
   }
}
