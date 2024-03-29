package br.com.aptare.cefit.trabalhador.entity;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(schema = "SC_TRB", name = "TBL_TRB_LOG")
@Proxy(lazy = true)
public class TrabalhadorLog implements Serializable {

    private static final long serialVersionUID = 175346810900837166L;

    @Id
    @Column(name = "CD_TRB_LOG")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ_TRB_LOG")
    @SequenceGenerator(name = "SQ_TRB_LOG", sequenceName = "SC_TRB.SQ_TRB_LOG")
    private Long codigo;

    @Column(name = "ST_INC_PGR_ANT")
    private Integer situacaoIncAnterior;

    @Column(name = "ST_INC_PGR_NOV")
    private Integer situacaoIncNova;

    @Column(name = "ST_TRB_ANT")
    private Integer situacaoAnterior;

    @Column(name = "ST_TRB_NOV")
    private Integer situacaoNova;

    @Column(name = "DT_OPR")
    private Date dataOperacao;

    @Column(name = "DS_MTV_INT_ATV_TRB")
    private String motivoInativacaoAtivacao;

    @Column(name = "DS_OBS_INT_ATV_TRB")
    private String observacaoInativacaoAtivacao;

    @Column(name = "CD_USR_OPR")
    private Long codigoUsuarioOperacao;

    @Column(name = "DS_OBS_INC")
    private String observacaoSitucaoIngresso;

    @Column(name = "CD_TRB")
    private Long codigoTrabalhador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CD_TRB", insertable = false, updatable = false)
    private Trabalhador trabalhador;

    public Long getCodigo() { return codigo; }

    public void setCodigo(Long codigo) { this.codigo = codigo; }

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

    public Integer getSituacaoAnterior() { return situacaoAnterior; }

    public void setSituacaoAnterior(Integer situacaoAnterior) { this.situacaoAnterior = situacaoAnterior; }

    public Integer getSituacaoNova() { return situacaoNova; }

    public void setSituacaoNova(Integer situacaoNova) { this.situacaoNova = situacaoNova; }

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

    public Trabalhador getTrabalhador() {
        return trabalhador;
    }

    public void setTrabalhador(Trabalhador trabalhador) {
        this.trabalhador = trabalhador;
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
