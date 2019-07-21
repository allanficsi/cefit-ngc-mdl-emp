package br.com.aptare.cefit.trabalhador.entity;

import br.com.aptare.cefit.vagas.entity.Vaga;
import br.com.aptare.seguranca.entidade.Auditoria;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

@Entity
@Table(schema = "SC_TRB", name = "TBL_CBO")
@Proxy(lazy = true)
public class Cbo implements Serializable
{

   private static final long serialVersionUID = 1431211184645188934L;

   @Id
   @Column(name = "CD_CBO")
   @GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ_CBO")
   @SequenceGenerator(name = "SQ_CBO", sequenceName = "SC_TRB.SQ_CBO")
   private Long codigo;

   @Column(name = "NM_CBO")
   private String nome;

   @Column(name = "NM_COD_CBO")
   private String nomeCodigo;
   
   @Column(name = "TP_IMO_CBO")
   private String tipo;
   
   @Column(name = "FG_ATV_CBO")
   private String flagAtivo;
   
   @Column(name = "FG_VLR_FIX_CBO")
   private String flagValorFixo;
   
   @Column(name = "VL_SRV_CBO")
   private Double valorServico;
   
   @Column(name = "VL_VST_CBO")
   private Double valorVisita;
   
   @Embedded
   private Auditoria auditoria;
   
   @OneToMany(mappedBy = "cboEntity", fetch = FetchType.LAZY)
   private Set<Vaga> listaVaga;
   
   @Transient
   private HashMap<Object, String> filtro;
   

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

   public String getTipo()
   {
      return tipo;
   }

   public void setTipo(String tipo)
   {
      this.tipo = tipo;
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

   public String getFlagValorFixo()
   {
      return flagValorFixo;
   }

   public void setFlagValorFixo(String flagValorFixo)
   {
      this.flagValorFixo = flagValorFixo;
   }

   public Double getValorServico()
   {
      return valorServico;
   }

   public void setValorServico(Double valorServico)
   {
      this.valorServico = valorServico;
   }

   public Double getValorVisita()
   {
      return valorVisita;
   }

   public void setValorVisita(Double valorVisita)
   {
      this.valorVisita = valorVisita;
   }
}
