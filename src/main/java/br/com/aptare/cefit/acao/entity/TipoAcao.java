package br.com.aptare.cefit.acao.entity;

import java.io.Serializable;
import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Proxy;

import br.com.aptare.seguranca.entidade.Auditoria;

@Entity
@Table(schema = "SC_ACA", name = "TBL_TAC")
@Proxy(lazy = true)
public class TipoAcao implements Serializable
{

   private static final long serialVersionUID = 1431211184645188934L;

   @Id
   @Column(name = "CD_TAC")
   @GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ_TAC")
   @SequenceGenerator(name = "SQ_TAC", sequenceName = "SC_ACA.SQ_TAC")
   private Long codigo;

   @Column(name = "NM_TAC")
   private String descricao;
   
   @Column(name = "FG_ATV")
   private String flagAtivo;
   
   @Transient
   private HashMap<Object, String> filtro;

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

   public HashMap<Object, String> getFiltro()
   {
      return filtro;
   }

   public void setFiltro(HashMap<Object, String> filtro)
   {
      this.filtro = filtro;
   }
}
