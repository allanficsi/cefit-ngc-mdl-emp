package br.com.aptare.cefit.empregador.entity;

import java.io.Serializable;
import java.util.Date;

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

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Proxy;

import br.com.aptare.cadastroUnico.entidade.CadastroUnico;
import br.com.aptare.seguranca.entidade.Auditoria;

@Entity
@Table(schema = "SC_EMP", name = "TBL_EMP")
@Proxy(lazy = true)
public class Empregador implements Serializable
{

   private static final long serialVersionUID = 1431211184645188934L;

   @Id
   @Column(name = "CD_EMP")
   @GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ_EMP")
   @SequenceGenerator(name = "SQ_EMP", sequenceName = "SC_EMP.SQ_EMP")
   private Long codigo;

   @Column(name = "CD_CUN")
   private Long codigoCadastroUnico;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "CD_CUN", insertable = false, updatable = false)
   private CadastroUnico cadastroUnico;

   @Column(name = "CD_CNA")
   private Long codigoCnae;

   @Column(name = "CD_PCR")
   private Long codigoProgramaCredito;

   @Column(name = "NR_FUN")
   private Long numeroFuncionarios;

   @Column(name = "CD_PEM")
   private Long codigoPorteEmpresa;

   @Column(name = "CD_STR_ECN")
   private Long codigoSetorEconomia;

   @Column(name = "DT_ATU_PEM")
   private Date dataAtualizacaoPorteEmpresa;

   @Column(name = "CD_USR_ATU_PEM")
   private Long codigoUsuarioAtualizacaoProteEmpresa;

   @Column(name = "ST_EMP")
   private Integer situacao;

   @Formula("(SELECT DMN.NM_VLR_DMN FROM SC_GRL.TBL_DMN DMN WHERE DMN.NM_CMP_DMN = 'ST_EMP' AND DMN.VL_CMP_DMN = ST_EMP)")
   private String descricaoSituacao;

   @Column(name = "NR_CEI")
   private Long numeroCei;

   @Column(name = "OBS_EMP")
   private String observacao;

   @Formula("( coalesce(nr_cei::text, '') ||';'|| (select cun.nr_cpf_cnpj_cun ||';'|| cun.nm_cun from sc_cuc.tbl_cun cun where cun.cd_cun = cd_cun) )")
   private String filtroGenerico;

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

   public Long getCodigoCadastroUnico()
   {
      return codigoCadastroUnico;
   }

   public void setCodigoCadastroUnico(Long codigoCadastroUnico)
   {
      this.codigoCadastroUnico = codigoCadastroUnico;
   }

   public CadastroUnico getCadastroUnico()
   {
      return cadastroUnico;
   }

   public void setCadastroUnico(CadastroUnico cadastroUnico)
   {
      this.cadastroUnico = cadastroUnico;
   }

   public Long getCodigoCnae()
   {
      return codigoCnae;
   }

   public void setCodigoCnae(Long codigoCnae)
   {
      this.codigoCnae = codigoCnae;
   }

   public Long getCodigoProgramaCredito()
   {
      return codigoProgramaCredito;
   }

   public void setCodigoProgramaCredito(Long codigoProgramaCredito)
   {
      this.codigoProgramaCredito = codigoProgramaCredito;
   }

   public Long getNumeroFuncionarios()
   {
      return numeroFuncionarios;
   }

   public void setNumeroFuncionarios(Long numeroFuncionarios)
   {
      this.numeroFuncionarios = numeroFuncionarios;
   }

   public Long getCodigoPorteEmpresa()
   {
      return codigoPorteEmpresa;
   }

   public void setCodigoPorteEmpresa(Long codigoPorteEmpresa)
   {
      this.codigoPorteEmpresa = codigoPorteEmpresa;
   }

   public Long getCodigoSetorEconomia() {
      return codigoSetorEconomia;
   }

   public void setCodigoSetorEconomia(Long codigoSetorEconomia) {
      this.codigoSetorEconomia = codigoSetorEconomia;
   }

   public Date getDataAtualizacaoPorteEmpresa()
   {
      return dataAtualizacaoPorteEmpresa;
   }

   public void setDataAtualizacaoPorteEmpresa(Date dataAtualizacaoPorteEmpresa)
   {
      this.dataAtualizacaoPorteEmpresa = dataAtualizacaoPorteEmpresa;
   }

   public Long getCodigoUsuarioAtualizacaoProteEmpresa()
   {
      return codigoUsuarioAtualizacaoProteEmpresa;
   }

   public void setCodigoUsuarioAtualizacaoProteEmpresa(Long codigoUsuarioAtualizacaoProteEmpresa)
   {
      this.codigoUsuarioAtualizacaoProteEmpresa = codigoUsuarioAtualizacaoProteEmpresa;
   }

   public Integer getSituacao()
   {
      return situacao;
   }

   public void setSituacao(Integer situacao)
   {
      this.situacao = situacao;
   }

   public Auditoria getAuditoria()
   {
      return auditoria;
   }

   public void setAuditoria(Auditoria auditoria)
   {
      this.auditoria = auditoria;
   }

   public Long getNumeroCei()
   {
      return numeroCei;
   }

   public void setNumeroCei(Long numeroCei)
   {
      this.numeroCei = numeroCei;
   }

   public String getObservacao()
   {
      return observacao;
   }

   public void setObservacao(String observacao)
   {
      this.observacao = observacao;
   }

   public String getDescricaoSituacao()
   {
      return descricaoSituacao;
   }

   public void setDescricaoSituacao(String descricaoSituacao)
   {
      this.descricaoSituacao = descricaoSituacao;
   }

   public String getFiltroGenerico()
   {
      return filtroGenerico;
   }

   public void setFiltroGenerico(String filtroGenerico)
   {
      this.filtroGenerico = filtroGenerico;
   }

}
