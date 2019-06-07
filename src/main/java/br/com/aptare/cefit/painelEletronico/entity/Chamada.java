package br.com.aptare.cefit.painelEletronico.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(schema = "SC_PEL", name = "TBL_CHM")
@Proxy(lazy = true)
public class Chamada implements Serializable
{
   private static final long serialVersionUID = 1431211184645188934L;

   @Id
   @Column(name = "CD_CHM")
   @GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ_CHM")
   @SequenceGenerator(name = "SQ_CHM", sequenceName = "SC_PEL.SQ_CHM")
   private Long codigo;
   
   @Column(name = "CD_SNH")
   private Long codigoSenha;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "CD_SNH", insertable = false, updatable = false)
   private Senha senha;
   
   @Column(name = "CD_GCH")
   private Long codigoGuiche;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "CD_GCH", insertable = false, updatable = false)
   private Guiche guiche;
   
   @Column(name = "DT_CHM")
   private Date data;
   
   @Column(name = "CD_INC_USR")
   private Long codigoUsuarioInclusao;
   
   @Column(name = "DT_INC_USR")
   private Date dataInclusao;

   public Long getCodigo()
   {
      return codigo;
   }

   public void setCodigo(Long codigo)
   {
      this.codigo = codigo;
   }

   public Long getCodigoSenha()
   {
      return codigoSenha;
   }

   public void setCodigoSenha(Long codigoSenha)
   {
      this.codigoSenha = codigoSenha;
   }

   public Long getCodigoGuiche()
   {
      return codigoGuiche;
   }

   public void setCodigoGuiche(Long codigoGuiche)
   {
      this.codigoGuiche = codigoGuiche;
   }

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

   public Senha getSenha()
   {
      return senha;
   }

   public void setSenha(Senha senha)
   {
      this.senha = senha;
   }

   public Guiche getGuiche()
   {
      return guiche;
   }

   public void setGuiche(Guiche guiche)
   {
      this.guiche = guiche;
   }

   public Date getData()
   {
      return data;
   }

   public void setData(Date data)
   {
      this.data = data;
   }
}
