package br.com.aptare.cefit.trabalhador.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

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
}
