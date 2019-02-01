package br.com.aptare.cefit.profissional.entity;

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
@Table(schema = "SC_PRF", name = "TBL_QLF")
@Proxy(lazy = true)
public class Qualificacao implements Serializable
{

   private static final long serialVersionUID = 1431211184645188934L;

   @Id
   @Column(name = "CD_QLF")
   @GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ_QLF")
   @SequenceGenerator(name = "SQ_QLF", sequenceName = "SC_PRF.SQ_QLF")
   private Long codigo;

   @Column(name = "NM_QLF")
   private String descricao;
   
   @Column(name = "FG_ATV")
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

   public String getFlagAtivo()
   {
      return flagAtivo;
   }

   public void setFlagAtivo(String flagAtivo)
   {
      this.flagAtivo = flagAtivo;
   }

   public Auditoria getAuditoria()
   {
      return auditoria;
   }

   public void setAuditoria(Auditoria auditoria)
   {
      this.auditoria = auditoria;
   }
}
