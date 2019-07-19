package br.com.aptare.cefit.trabalhador.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import br.com.aptare.cefit.vagas.entity.Vaga;

@Entity
@Table(schema = "SC_TRB", name = "TBL_CBO")
@Proxy(lazy = true)
public class Cbo implements Serializable
{

   private static final long serialVersionUID = 1431211184645188934L;

   @Id
   @Column(name = "CD_CBO")
   private Long codigo;

   @Column(name = "NM_CBO")
   private String nome;

   @Column(name = "NM_COD_CBO")
   private String nomeCodigo;

   @OneToMany(mappedBy = "cboEntity", fetch = FetchType.LAZY)
   private Set<Vaga> listaVaga;


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

   public String getNomeCodigo()
   {
      return nomeCodigo;
   }

   public void setNomeCodigo(String nomeCodigo)
   {
      this.nomeCodigo = nomeCodigo;
   }

   public Set<Vaga> getListaVaga()
   {
      return listaVaga;
   }

   public void setListaVaga(Set<Vaga> listaVaga)
   {
      this.listaVaga = listaVaga;
   }


}
