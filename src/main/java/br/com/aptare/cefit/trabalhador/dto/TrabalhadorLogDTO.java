package br.com.aptare.cefit.trabalhador.dto;

import br.com.aptare.cefit.cadastroUnico.dto.CadastroUnicoDTO;
import br.com.aptare.cefit.common.dto.AuditoriaDTO;

import java.util.Date;
import java.util.Set;

public class TrabalhadorLogDTO
{

    private Long codigo;

    private Integer situacaoIncAnterior;

    private Integer situacaoIncNova;

    private Integer situacaoAnterior;

    private Integer situacaoNova;

    private Date dataOperacao;

    private Long codigoUsuarioOperacao;

    private String observacaoSitucaoIngresso;

    private String motivoInativacaoAtivacao;

    private Long codigoTrabalhador;

    private String observacaoInativacaoAtivacao;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Integer getSituacaoIncAnterior() {
        return situacaoIncAnterior;
    }

    public void setSituacaoIncAnterior(Integer situacaoIncAnterior) {
        this.situacaoIncAnterior = situacaoIncAnterior;
    }

    public Integer getSituacaoIncNova() {
        return situacaoIncNova;
    }

    public void setSituacaoIncNova(Integer situacaoIncNova) {
        this.situacaoIncNova = situacaoIncNova;
    }

    public Integer getSituacaoAnterior() {
        return situacaoAnterior;
    }

    public void setSituacaoAnterior(Integer situacaoAnterior) {
        this.situacaoAnterior = situacaoAnterior;
    }

    public Integer getSituacaoNova() {
        return situacaoNova;
    }

    public void setSituacaoNova(Integer situacaoNova) {
        this.situacaoNova = situacaoNova;
    }

    public Date getDataOperacao() {
        return dataOperacao;
    }

    public void setDataOperacao(Date dataOperacao) {
        this.dataOperacao = dataOperacao;
    }

    public Long getCodigoUsuarioOperacao() {
        return codigoUsuarioOperacao;
    }

    public void setCodigoUsuarioOperacao(Long codigoUsuarioOperacao) {
        this.codigoUsuarioOperacao = codigoUsuarioOperacao;
    }

    public String getObservacaoSitucaoIngresso() {
        return observacaoSitucaoIngresso;
    }

    public void setObservacaoSitucaoIngresso(String observacaoSitucaoIngresso) {
        this.observacaoSitucaoIngresso = observacaoSitucaoIngresso;
    }

    public Long getCodigoTrabalhador() {
        return codigoTrabalhador;
    }

    public void setCodigoTrabalhador(Long codigoTrabalhador) {
        this.codigoTrabalhador = codigoTrabalhador;
    }

    public String getMotivoInativacaoAtivacao() {
        return motivoInativacaoAtivacao;
    }

    public void setMotivoInativacaoAtivacao(String motivoInativacaoAtivacao) {
        this.motivoInativacaoAtivacao = motivoInativacaoAtivacao;
    }

    public String getObservacaoInativacaoAtivacao() {
        return observacaoInativacaoAtivacao;
    }

    public void setObservacaoInativacaoAtivacao(String observacaoInativacaoAtivacao) {
        this.observacaoInativacaoAtivacao = observacaoInativacaoAtivacao;
    }
}
