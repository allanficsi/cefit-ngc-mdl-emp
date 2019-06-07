package br.com.aptare.cefit.painelEletronico.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

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
import javax.persistence.Transient;

import org.hibernate.annotations.Proxy;

@Entity
@Table(schema = "SC_PEL", name = "TBL_SNH")
@Proxy(lazy = true)
public class Senha implements Serializable
{

   private static final long serialVersionUID = 1431211184645188934L;

   @Id
   @Column(name = "CD_SNH")
   @GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ_SNH")
   @SequenceGenerator(name = "SQ_SNH", sequenceName = "SC_PEL.SQ_SNH")
   private Long codigo;
   
   @Column(name = "CD_TPS")
   private Long codigoTipoSenha;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "CD_TPS", insertable = false, updatable = false)
   private TipoSenha tipoSenha;
   
   @Column(name = "NR_SNH")
   private Long numero;
   
   @Column(name = "DS_SNH")
   private String descricao;
   
   @Column(name = "DT_SNH")
   private Date data;
   
   @Column(name = "DT_INC_SNH")
   private Date dataInclusao;
   
   @Column(name = "FG_ATV_SNH")
   private Boolean flagAtivo;
   
   @Column(name = "DT_ALT_SNH")
   private Date dataAlteracao;
   
   @Column(name = "CD_ALT_SNH")
   private Long codigoUsuarioAlteracao;
   
   @Transient
   private HashMap<String, Object> filtro;

   public Long getCodigo()
   {
      return codigo;
   }

   public void setCodigo(Long codigo)
   {
      this.codigo = codigo;
   }

   public Long getCodigoTipoSenha()
   {
      return codigoTipoSenha;
   }

   public void setCodigoTipoSenha(Long codigoTipoSenha)
   {
      this.codigoTipoSenha = codigoTipoSenha;
   }

   public Long getNumero()
   {
      return numero;
   }

   public void setNumero(Long numero)
   {
      this.numero = numero;
   }

   public String getDescricao()
   {
      return descricao;
   }

   public void setDescricao(String descricao)
   {
      this.descricao = descricao;
   }

   public Date getData()
   {
      return data;
   }

   public void setData(Date data)
   {
      this.data = data;
   }

   public Date getDataInclusao()
   {
      return dataInclusao;
   }

   public void setDataInclusao(Date dataInclusao)
   {
      this.dataInclusao = dataInclusao;
   }

   public Boolean getFlagAtivo()
   {
      return flagAtivo;
   }

   public void setFlagAtivo(Boolean flagAtivo)
   {
      this.flagAtivo = flagAtivo;
   }

   public HashMap<String, Object> getFiltro()
   {
      return filtro;
   }

   public void setFiltro(HashMap<String, Object> filtro)
   {
      this.filtro = filtro;
   }

   public TipoSenha getTipoSenha()
   {
      return tipoSenha;
   }

   public void setTipoSenha(TipoSenha tipoSenha)
   {
      this.tipoSenha = tipoSenha;
   }

   public Date getDataAlteracao()
   {
      return dataAlteracao;
   }

   public void setDataAlteracao(Date dataAlteracao)
   {
      this.dataAlteracao = dataAlteracao;
   }

   public Long getCodigoUsuarioAlteracao()
   {
      return codigoUsuarioAlteracao;
   }

   public void setCodigoUsuarioAlteracao(Long codigoUsuarioAlteracao)
   {
      this.codigoUsuarioAlteracao = codigoUsuarioAlteracao;
   }
}
