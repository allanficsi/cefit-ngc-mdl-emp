package br.com.aptare.cefit.trabalhador.dto;

public class TrabalhadorAgendaDTO {

    private Long codigo;

    private String nrHor1;

    private String nrHor2;

    private String nrHor3;

    private String nrHor4;

    private Boolean flagSel;

    private Integer nrDia;

    private Long codigoTrabalhador;


    public Long getCodigo() { return codigo; }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
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

    public String getNrHor3() {
        return nrHor3;
    }

    public void setNrHor3(String nrHor3) {
        this.nrHor3 = nrHor3;
    }

    public String getNrHor4() {
        return nrHor4;
    }

    public void setNrHor4(String nrHor4) {
        this.nrHor4 = nrHor4;
    }

    public Boolean getFlagSel() { return flagSel; }

    public void setFlagSel(Boolean flagSel) { this.flagSel = flagSel; }

    public Integer getNrDia() { return nrDia; }

    public void setNrDia(Integer nrDia) { this.nrDia = nrDia; }

    public Long getCodigoTrabalhador() {
        return codigoTrabalhador;
    }

    public void setCodigoTrabalhador(Long codigoTrabalhador) {
        this.codigoTrabalhador = codigoTrabalhador;
    }
}
