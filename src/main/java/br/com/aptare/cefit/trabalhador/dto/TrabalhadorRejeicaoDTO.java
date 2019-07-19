package br.com.aptare.cefit.trabalhador.dto;

import br.com.aptare.cefit.empregador.dto.EmpregadorDTO;

import java.io.Serializable;
import java.util.Date;

public class TrabalhadorRejeicaoDTO implements Serializable {

    private static final long serialVersionUID = 1758617132136765116L;

    private Long codigo;

    private Long codigoTrabalhador;

    private Long codigoEmpregador;

    private String motivoRejeicao;

    private String flagAtivo;

    private Long codigoUsuarioInclusao;

    private Date dataInclusao;

    private Long codigoUsuarioAlteracao;

    private Date dataAlteracao;

    private Long tipoOrigemRejeicao;

    private Long codigoMotivoRejeicao;

    private EmpregadorDTO empregador;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Long getCodigoTrabalhador() {
        return codigoTrabalhador;
    }

    public void setCodigoTrabalhador(Long codigoTrabalhador) {
        this.codigoTrabalhador = codigoTrabalhador;
    }

    public Long getCodigoEmpregador() {
        return codigoEmpregador;
    }

    public void setCodigoEmpregador(Long codigoEmpregador) {
        this.codigoEmpregador = codigoEmpregador;
    }

    public String getMotivoRejeicao() {
        return motivoRejeicao;
    }

    public void setMotivoRejeicao(String motivoRejeicao) {
        this.motivoRejeicao = motivoRejeicao;
    }

    public String getFlagAtivo() {
        return flagAtivo;
    }

    public void setFlagAtivo(String flagAtivo) {
        this.flagAtivo = flagAtivo;
    }

    public Long getCodigoUsuarioInclusao() {
        return codigoUsuarioInclusao;
    }

    public void setCodigoUsuarioInclusao(Long codigoUsuarioInclusao) {
        this.codigoUsuarioInclusao = codigoUsuarioInclusao;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public Long getCodigoUsuarioAlteracao() {
        return codigoUsuarioAlteracao;
    }

    public void setCodigoUsuarioAlteracao(Long codigoUsuarioAlteracao) {
        this.codigoUsuarioAlteracao = codigoUsuarioAlteracao;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public Long getTipoOrigemRejeicao() {
        return tipoOrigemRejeicao;
    }

    public void setTipoOrigemRejeicao(Long tipoOrigemRejeicao) {
        this.tipoOrigemRejeicao = tipoOrigemRejeicao;
    }

    public Long getCodigoMotivoRejeicao() {
        return codigoMotivoRejeicao;
    }

    public void setCodigoMotivoRejeicao(Long codigoMotivoRejeicao) {
        this.codigoMotivoRejeicao = codigoMotivoRejeicao;
    }

    public EmpregadorDTO getEmpregador() {
        return empregador;
    }

    public void setEmpregador(EmpregadorDTO empregador) {
        this.empregador = empregador;
    }
}
