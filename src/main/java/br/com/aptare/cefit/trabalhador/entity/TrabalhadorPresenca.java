package br.com.aptare.cefit.trabalhador.entity;

import br.com.aptare.cefit.trabalhador.entity.filtro.PresencaFiltro;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(schema = "SC_TRB", name = "TBL_PRS")
@Proxy(lazy = true)
public class TrabalhadorPresenca implements Serializable {

    private static final long serialVersionUID = 6658579563229208685L;

    @Id
    @Column(name = "CD_PRS")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ_TRB_PRS")
    @SequenceGenerator(name = "SQ_TRB_PRS", sequenceName = "SC_TRB.SQ_TRB_PRS")
    private Long codigo;

    @Column(name = "CD_TRB")
    private Long codigoTrabalhador;

    @Column(name = "DT_PRS")
    private Date dataPresenca;

    @Column(name = "NR_HOR1")
    private String nrHor1;

    @Column(name = "NR_HOR2")
    private String nrHor2;

    @Column(name = "CD_INC_USR")
    private Long codigoUsuarioInclusao;

    @Column(name = "DT_INC_USR")
    private Date dataInclusao;

    @Column(name = "CD_ALT_USR")
    private Long codigoUsuarioAlteracao;

    @Column(name = "DT_ALT_USR")
    private Date dataAlteracao;

    @Column(name = "FG_ATV_PRS")
    private String flagAtivoPresenca;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CD_TRB", insertable = false, updatable = false)
    private Trabalhador trabalhador;

    @Transient
    PresencaFiltro filtro;

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

    public Trabalhador getTrabalhador() {
        return trabalhador;
    }

    public void setTrabalhador(Trabalhador trabalhador) {
        this.trabalhador = trabalhador;
    }

    public PresencaFiltro getFiltro() {
        return filtro;
    }

    public void setFiltro(PresencaFiltro filtro) {
        this.filtro = filtro;
    }
}
