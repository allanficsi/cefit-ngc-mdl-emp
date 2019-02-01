package br.com.aptare.cefit.profissional.dto;

import java.util.Date;
import java.util.Set;

import br.com.aptare.cefit.cadastroUnico.dto.CadastroUnicoDTO;
import br.com.aptare.cefit.common.dto.AuditoriaDTO;
import br.com.aptare.cefit.profissional.entity.ProfissionalQualificacao;

public class ProfissionalDTO
{
   private Long codigo;

   private Long codigoCadastroUnico;

   private CadastroUnicoDTO cadastroUnico;

   private Long numeroPis;

   private Long numeroCtps;

   private Date dataEmissaoCtps;

   private String observacao;

   private String ufCtps;

   private Long numeroSerieCtps;

   private Long numeroInscricaoPrefeitura;

   private Long numeroInss;
   
   private String flagAtivo;

   private AuditoriaDTO auditoria;
   
   private String flagPsicologo;
   
   private Set<ProfissionalQualificacao> listaProfissionalQualificacao;
   
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

   public CadastroUnicoDTO getCadastroUnico()
   {
      return cadastroUnico;
   }

   public void setCadastroUnico(CadastroUnicoDTO cadastroUnico)
   {
      this.cadastroUnico = cadastroUnico;
   }

   public Long getNumeroPis()
   {
      return numeroPis;
   }

   public void setNumeroPis(Long numeroPis)
   {
      this.numeroPis = numeroPis;
   }

   public Long getNumeroCtps()
   {
      return numeroCtps;
   }

   public void setNumeroCtps(Long numeroCtps)
   {
      this.numeroCtps = numeroCtps;
   }

   public Date getDataEmissaoCtps()
   {
      return dataEmissaoCtps;
   }

   public void setDataEmissaoCtps(Date dataEmissaoCtps)
   {
      this.dataEmissaoCtps = dataEmissaoCtps;
   }

   public String getObservacao()
   {
      return observacao;
   }

   public void setObservacao(String observacao)
   {
      this.observacao = observacao;
   }

   public String getUfCtps()
   {
      return ufCtps;
   }

   public void setUfCtps(String ufCtps)
   {
      this.ufCtps = ufCtps;
   }

   public Long getNumeroSerieCtps()
   {
      return numeroSerieCtps;
   }

   public void setNumeroSerieCtps(Long numeroSerieCtps)
   {
      this.numeroSerieCtps = numeroSerieCtps;
   }

   public Long getNumeroInscricaoPrefeitura()
   {
      return numeroInscricaoPrefeitura;
   }

   public void setNumeroInscricaoPrefeitura(Long numeroInscricaoPrefeitura)
   {
      this.numeroInscricaoPrefeitura = numeroInscricaoPrefeitura;
   }

   public Long getNumeroInss()
   {
      return numeroInss;
   }

   public void setNumeroInss(Long numeroInss)
   {
      this.numeroInss = numeroInss;
   }

   public AuditoriaDTO getAuditoria()
   {
      return auditoria;
   }

   public void setAuditoria(AuditoriaDTO auditoria)
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

   public String getFlagPsicologo()
   {
      return flagPsicologo;
   }

   public void setFlagPsicologo(String flagPsicologo)
   {
      this.flagPsicologo = flagPsicologo;
   }

   public Set<ProfissionalQualificacao> getListaProfissionalQualificacao()
   {
      return listaProfissionalQualificacao;
   }

   public void setListaProfissionalQualificacao(Set<ProfissionalQualificacao> listaProfissionalQualificacao)
   {
      this.listaProfissionalQualificacao = listaProfissionalQualificacao;
   }
}
