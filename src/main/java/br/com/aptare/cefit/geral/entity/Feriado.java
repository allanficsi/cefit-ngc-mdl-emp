package br.com.aptare.cefit.geral.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Proxy;

import br.com.aptare.cefit.geral.entity.filtro.FeriadoFiltro;
import br.com.aptare.seguranca.entidade.Auditoria;

@Entity
@Table(schema = "SC_GRL", name = "TBL_FRD")
@Proxy(lazy = true)
public class Feriado implements Serializable
{

   private static final long serialVersionUID = 1431211184645188934L;

   @Id
   @Column(name = "DT_FRD")
   private Date dataFeriado;
   
   @Column(name = "DS_FRD")
   private String descricao;
   
   @Transient
   private FeriadoFiltro filtro;
   
   @Embedded
   private Auditoria auditoria;

   public Date getDataFeriado()
   {
      return dataFeriado;
   }

   public void setDataFeriado(Date dataFeriado)
   {
      this.dataFeriado = dataFeriado;
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

   public FeriadoFiltro getFiltro()
   {
      return filtro;
   }

   public void setFiltro(FeriadoFiltro filtro)
   {
      this.filtro = filtro;
   }
}
