package br.com.aptare.cefit.trabalhador.dto;

import java.io.Serializable;
import java.util.Date;

public class TrabalhadorPresencaDTO implements Serializable {

    private static final long serialVersionUID = 3741438411588623441L;

    private Long codigo;

    private Long codigoTrabalhador;

    private Date dataPresenca;

    private String nrHor1;

    private String nrHor2;

    private Long codigoUsuarioInclusao;

    private Date dataInclusao;

    private Long codigoUsuarioAlteracao;

    private Date dataAlteracao;

    private String flagAtivoPresenca;

    private TrabalhadorDTO trabalhadorDTO;

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

    public Date getDataPresenca() {
        return dataPresenca;
    }

    public void setDataPresenca(Date dataPresenca) {
        this.dataPresenca = dataPresenca;
    }

    public String getNrHor1() {
        return nrHor1;
    }

    public void setNrHor1(String nrHor1) {
        this.nrHor1 = nrHor1;
    }

    public String getNrHor2() {
        return nrHor2;
    }

    public void setNrHor2(String nrHor2) {
        this.nrHor2 = nrHor2;
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

    public String getFlagAtivoPresenca() {
        return flagAtivoPresenca;
    }

    public void setFlagAtivoPresenca(String flagAtivoPresenca) {
        this.flagAtivoPresenca = flagAtivoPresenca;
    }

    public TrabalhadorDTO getTrabalhadorDTO() {
        return trabalhadorDTO;
    }

    public void setTrabalhadorDTO(TrabalhadorDTO trabalhadorDTO) {
        this.trabalhadorDTO = trabalhadorDTO;
    }
}
