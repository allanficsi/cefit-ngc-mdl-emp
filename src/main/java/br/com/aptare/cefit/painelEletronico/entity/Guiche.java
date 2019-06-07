package br.com.aptare.cefit.painelEletronico.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import br.com.aptare.seguranca.entidade.Auditoria;

@Entity
@Table(schema = "SC_PEL", name = "TBL_GCH")
@Proxy(lazy = true)
public class Guiche implements Serializable
{

   private static final long serialVersionUID = 1431211184645188934L;

   @Id
   @Column(name = "CD_GCH")
   @GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ_GCH")
   @SequenceGenerator(name = "SQ_GCH", sequenceName = "SC_PEL.SQ_GCH")
   private Long codigo;
   
   @Column(name = "DS_GCH")
   private String descricao;
   
   @Column(name = "FG_ATV_GCH")
   private String flagAtivo;
   
   @Embedded
   private Auditoria auditoria;

   public Long getCodigo()
   {
      return codigo;
   }

   public void setCodigo(Long codigo)
   {
      this.codigo = codigo;
   }

   public String getDescricao()
   {
      return descricao;
   }

   public void setDescricao(String descricao)
   {
      this.descricao = descricao;
   }

   public Auditoria getAuditoria()
   {
      return auditoria;
   }

   public void setAuditoria(Auditoria auditoria)
   {
      this.auditoria = auditoria;
   }

   public String getFlagAtivo()
   {
      return flagAtivo;
   }

   public void setFlagAtivo(String flagAtivo)
   {
      this.flagAtivo = flagAtivo;
   }
}
