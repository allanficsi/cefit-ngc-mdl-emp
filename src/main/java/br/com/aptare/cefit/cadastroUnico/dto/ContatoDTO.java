package br.com.aptare.cefit.cadastroUnico.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import br.com.aptare.cefit.common.dto.AuditoriaDTO;

public class ContatoDTO implements Serializable
{
   private static final long serialVersionUID = 1L;

   private Long codigo;
   
   private Long codigoCadastroUnico;
   
   private Long codigoCargo;
   
   private CargoDTO cargo;
   
   private String nome;
   
   private Date dataNascimento;
   
   private String email;
   
   private String flagAtivo;
   
   private AuditoriaDTO auditoria;
   
   private Set<TelefoneDTO> listaTelefone;
   
   private Long tipoContato;
   
   private String descricaoTipoContato;
   

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

   public Long getCodigoCargo()
   {
      return codigoCargo;
   }

   public void setCodigoCargo(Long codigoCargo)
   {
      this.codigoCargo = codigoCargo;
   }

   public String getNome()
   {
      return nome;
   }

   public void setNome(String nome)
   {
      this.nome = nome;
   }

   public Date getDataNascimento()
   {
      return dataNascimento;
   }

   public void setDataNascimento(Date dataNascimento)
   {
      this.dataNascimento = dataNascimento;
   }

   public String getEmail()
   {
      return email;
   }

   public void setEmail(String email)
   {
      this.email = email;
   }

   public String getFlagAtivo()
   {
      return flagAtivo;
   }

   public void setFlagAtivo(String flagAtivo)
   {
      this.flagAtivo = flagAtivo;
   }

   public AuditoriaDTO getAuditoria()
   {
      return auditoria;
   }

   public void setAuditoria(AuditoriaDTO auditoria)
   {
      this.auditoria = auditoria;
   }

   public CargoDTO getCargo()
   {
      return cargo;
   }

   public void setCargo(CargoDTO cargo)
   {
      this.cargo = cargo;
   }

   public Set<TelefoneDTO> getListaTelefone()
   {
      return listaTelefone;
   }

   public void setListaTelefone(Set<TelefoneDTO> listaTelefone)
   {
      this.listaTelefone = listaTelefone;
   }

   public Long getTipoContato()
   {
      return tipoContato;
   }

   public void setTipoContato(Long tipoContato)
   {
      this.tipoContato = tipoContato;
   }

   public String getDescricaoTipoContato()
   {
      return descricaoTipoContato;
   }

   public void setDescricaoTipoContato(String descricaoTipoContato)
   {
      this.descricaoTipoContato = descricaoTipoContato;
   }
}
