package br.com.aptare.cefit.espaco.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Proxy;

import br.com.aptare.cadastroUnico.entidade.Endereco;
import br.com.aptare.cefit.espaco.entity.filtro.EspacoFiltro;
import br.com.aptare.seguranca.entidade.Auditoria;

@Entity
@Table(schema = "SC_ESP", name = "TBL_ESP")
@Proxy(lazy = true)
public class Espaco implements Serializable
{

   private static final long serialVersionUID = 1431211184645188934L;

   @Id
   @Column(name = "CD_ESP")
   @GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ_ESP")
   @SequenceGenerator(name = "SQ_ESP", sequenceName = "SC_ESP.SQ_ESP")
   private Long codigo;

   @Column(name = "NM_ESP")
   private String nome;
   
   @Column(name = "NR_CPD_ESP")
   private Integer capacidade;
   
   @Column(name = "DS_ESP")
   private String descricao;
   
   @Column(name = "CD_EDR")
   private Long codigoEndereco;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "CD_EDR", insertable = false, updatable = false)
   private Endereco endereco;
   
   @Column(name = "FG_ATV")
   private String flagAtivo;
   
   @Column(name = "CD_LOC")
   private Long codigoLocal;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "CD_LOC", insertable = false, updatable = false)
   private Local local;
   
   @OneToMany(mappedBy = "espaco", fetch = FetchType.LAZY)
   private Set<EspacoItemEspaco> listaEspacoItemEspaco;
   
   @Embedded
   private Auditoria auditoria;
   
   @Transient
   private EspacoFiltro filtro;

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

   public Integer getCapacidade()
   {
      return capacidade;
   }

   public void setCapacidade(Integer capacidade)
   {
      this.capacidade = capacidade;
   }

   public String getDescricao()
   {
      return descricao;
   }

   public void setDescricao(String descricao)
   {
      this.descricao = descricao;
   }

   public Long getCodigoEndereco()
   {
      return codigoEndereco;
   }

   public void setCodigoEndereco(Long codigoEndereco)
   {
      this.codigoEndereco = codigoEndereco;
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

   public Endereco getEndereco()
   {
      return endereco;
   }

   public void setEndereco(Endereco endereco)
   {
      this.endereco = endereco;
   }

   public Set<EspacoItemEspaco> getListaEspacoItemEspaco()
   {
      return listaEspacoItemEspaco;
   }

   public void setListaEspacoItemEspaco(Set<EspacoItemEspaco> listaEspacoItemEspaco)
   {
      this.listaEspacoItemEspaco = listaEspacoItemEspaco;
   }

   public Long getCodigoLocal()
   {
      return codigoLocal;
   }

   public void setCodigoLocal(Long codigoLocal)
   {
      this.codigoLocal = codigoLocal;
   }

   public Local getLocal()
   {
      return local;
   }

   public void setLocal(Local local)
   {
      this.local = local;
   }

   public EspacoFiltro getFiltro()
   {
      return filtro;
   }

   public void setFiltro(EspacoFiltro filtro)
   {
      this.filtro = filtro;
   }
}
