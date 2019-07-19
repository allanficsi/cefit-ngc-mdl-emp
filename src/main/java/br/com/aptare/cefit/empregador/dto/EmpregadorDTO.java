package br.com.aptare.cefit.empregador.dto;

import java.util.Date;

import br.com.aptare.cefit.cadastroUnico.dto.CadastroUnicoDTO;
import br.com.aptare.cefit.common.dto.AuditoriaDTO;

public class EmpregadorDTO
{
   private Long codigo;

   private Long codigoCadastroUnico;

   private CadastroUnicoDTO cadastroUnico;

   private Long codigoCnae;

   private Long codigoProgramaCredito;

   private Long numeroFuncionarios;

   private Long codigoPorteEmpresa;

   private Long codigoSetorEconomia;

   private Date dataAtualizacaoPorteEmpresa;

   private Long codigoUsuarioAtualizacaoProteEmpresa;

   private AuditoriaDTO auditoria;

   private Integer situacao;

   private String descricaoSituacao;

   private Long numeroCei;

   private String observacao;


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

   public CadastroUnicoDTO getCadastroUnico()
   {
      return cadastroUnico;
   }

   public void setCadastroUnico(CadastroUnicoDTO cadastroUnico)
   {
      this.cadastroUnico = cadastroUnico;
   }

   public AuditoriaDTO getAuditoria()
   {
      return auditoria;
   }

   public void setAuditoria(AuditoriaDTO auditoria)
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
}
