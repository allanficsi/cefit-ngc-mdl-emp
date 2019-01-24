package br.com.aptare.cefit.cadastroUnico.dto;

import java.util.Date;
import java.util.Set;

public class PessoaJuridicaDTO
{
   private Long codigoCadastroUnico;

   private String nomeFantasia;

   private Long inscricaoEstadual;

   private Date dataRegistroJunta;
   
   private Set<ContatoDTO> listaContato;

   public Long getCodigoCadastroUnico()
   {
      return codigoCadastroUnico;
   }

   public void setCodigoCadastroUnico(Long codigoCadastroUnico)
   {
      this.codigoCadastroUnico = codigoCadastroUnico;
   }

   public String getNomeFantasia()
   {
      return nomeFantasia;
   }

   public void setNomeFantasia(String nomeFantasia)
   {
      this.nomeFantasia = nomeFantasia;
   }

   public Long getInscricaoEstadual()
   {
      return inscricaoEstadual;
   }

   public void setInscricaoEstadual(Long inscricaoEstadual)
   {
      this.inscricaoEstadual = inscricaoEstadual;
   }

   public Date getDataRegistroJunta()
   {
      return dataRegistroJunta;
   }

   public void setDataRegistroJunta(Date dataRegistroJunta)
   {
      this.dataRegistroJunta = dataRegistroJunta;
   }

   public Set<ContatoDTO> getListaContato()
   {
      return listaContato;
   }

   public void setListaContato(Set<ContatoDTO> listaContato)
   {
      this.listaContato = listaContato;
   }
}
