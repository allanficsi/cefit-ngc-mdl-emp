package br.com.aptare.cefit.trabalhador.entity;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(schema = "SC_TRB",name = "TBL_AGN")
@Proxy(lazy = true)
public class TrabalhadorAgenda implements  Serializable{

    private static final long serialVersionUID = -1166099328752742568L;

    @Id
    @Column(name = "CD_AGN")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ_AGN")
    @SequenceGenerator(name = "SQ_AGN" , sequenceName = " SC_TRB.SQ_AGN")
    private Long codigo;

    @Column(name = "NR_HOR_1")
    private String nrHor1;

    @Column(name = "NR_HOR_2")
    private String nrHor2;

    @Column(name = "NR_HOR_3")
    private String nrHor3;

    @Column(name = "NR_HOR_4")
    private String nrHor4;

    @Column(name = "FG_ATV")
    private boolean fgAtivo;

    @Column(name = "DT_SMN")
    private Long diaSemana;

    @Column(name = "CD_TRB")
    private Long codigoTrabalhador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CD_TRB", insertable = false, updatable = false)
    private Trabalhador trabalhador;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public boolean isFgAtivo() { return fgAtivo; }

    public void setFgAtivo(boolean fgAtivo) { this.fgAtivo = fgAtivo; }

    public Long getCodigoTrabalhador() {
        return codigoTrabalhador;
    }

    public void setCodigoTrabalhador(Long codigoTrabalhador) {
        this.codigoTrabalhador = codigoTrabalhador;
    }

    public Trabalhador getTrabalhador() {
        return trabalhador;
    }

    public void setTrabalhador(Trabalhador trabalhador) {
        this.trabalhador = trabalhador;
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

    public Long getDiaSemana() { return diaSemana; }

    public void setDiaSemana(Long diaSemana) { this.diaSemana = diaSemana; }
}
