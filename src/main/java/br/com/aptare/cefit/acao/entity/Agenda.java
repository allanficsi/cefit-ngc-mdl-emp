package br.com.aptare.cefit.acao.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Proxy;

import br.com.aptare.seguranca.entidade.Auditoria;

@Entity
@Table(schema = "SC_ACA", name = "TBL_AGN")
@Proxy(lazy = true)
public class Agenda implements Serializable
{

   private static final long serialVersionUID = 1431211184645188934L;

   @Id
   @Column(name = "CD_AGN")
   @GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ_AGN")
   @SequenceGenerator(name = "SQ_AGN", sequenceName = "SC_ACA.SQ_AGN")
   private Long codigo;

   @Column(name = "CD_ACA")
   private Long codigoAcao;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "CD_ACA", insertable = false, updatable = false)
   private Acao acao;  
   
   @Column(name = "DT_AGN")
   private Date dataAgenda;
   
   @Column(name = "FG_FER")
   private Boolean fgFeriado;
   
   @Column(name = "NR_HOR_1")
   private String nrHor1;
   
   @Column(name = "NR_HOR_2")
   private String nrHor2;
   
   @Column(name = "NR_HOR_3")
   private String nrHor3;
   
   @Column(name = "NR_HOR_4")
   private String nrHor4;
   
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

   public Long getCodigoAcao()
   {
      return codigoAcao;
   }

   public void setCodigoAcao(Long codigoAcao)
   {
      this.codigoAcao = codigoAcao;
   }

   public Acao getAcao()
   {
      return acao;
   }

   public void setAcao(Acao acao)
   {
      this.acao = acao;
   }

   public Date getDataAgenda()
   {
      return dataAgenda;
   }

   public void setDataAgenda(Date dataAgenda)
   {
      this.dataAgenda = dataAgenda;
   }

   public Boolean getFgFeriado()
   {
      return fgFeriado;
   }

   public void setFgFeriado(Boolean fgFeriado)
   {
      this.fgFeriado = fgFeriado;
   }

   public String getNrHor1()
   {
      return nrHor1;
   }

   public void setNrHor1(String nrHor1)
   {
      this.nrHor1 = nrHor1;
   }

   public String getNrHor2()
   {
      return nrHor2;
   }

   public void setNrHor2(String nrHor2)
   {
      this.nrHor2 = nrHor2;
   }

   public String getNrHor3()
   {
      return nrHor3;
   }

   public void setNrHor3(String nrHor3)
   {
      this.nrHor3 = nrHor3;
   }

   public String getNrHor4()
   {
      return nrHor4;
   }

   public void setNrHor4(String nrHor4)
   {
      this.nrHor4 = nrHor4;
   }

   public String getFlagAtivo()
   {
      return flagAtivo;
   }

   public void setFlagAtivo(String flagAtivo)
   {
      this.flagAtivo = flagAtivo;
   }

   public HashMap<Object, String> getFiltro()
   {
      return filtro;
   }

   public void setFiltro(HashMap<Object, String> filtro)
   {
      this.filtro = filtro;
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
