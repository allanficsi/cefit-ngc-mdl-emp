package br.com.aptare.cefit.trabalhador.entity;

import br.com.aptare.cefit.empregador.entity.Empregador;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(schema = "SC_TRB", name = "TBL_RJC")
@Proxy(lazy = true)
public class TrabalhadorRejeicao implements Serializable {

    private static final long serialVersionUID = 175346810900837166L;

    @Id
    @Column(name = "CD_RJC")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ_TRB_RJC")
    @SequenceGenerator(name = "SQ_TRB_RJC", sequenceName = "SC_TRB.SQ_TRB_RJC")
    private Long codigo;

    @Column(name = "CD_TRB")
    private Long codigoTrabalhador;

    @Column(name = "CD_EMP")
    private Long codigoEmpregador;

    @Column(name = "DS_MTV_RJC")
    private String motivoRejeicao;

    @Column(name = "FG_ATV_RJC")
    private String flagAtivo;

    @Column(name = "CD_INC_USR")
    private Long codigoUsuarioInclusao;

    @Column(name = "DT_INC_USR")
    private Date dataInclusao;

    @Column(name = "CD_ALT_USR")
    private Long codigoUsuarioAlteracao;

    @Column(name = "DT_ALT_USR")
    private Date dataAlteracao;

    @Column(name = "TP_ORG_RJC")
    private Long tipoOrigemRejeicao;

    @Column(name = "CD_MTV_RJC")
    private Long codigoMotivoRejeicao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CD_TRB", insertable = false, updatable = false)
    private Trabalhador trabalhador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CD_EMP", insertable = false, updatable = false)
    private Empregador empregador;

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

    public Trabalhador getTrabalhador() {
        return trabalhador;
    }

    public void setTrabalhador(Trabalhador trabalhador) {
        this.trabalhador = trabalhador;
    }

    public Empregador getEmpregador() {
        return empregador;
    }

    public void setEmpregador(Empregador empregador) {
        this.empregador = empregador;
    }
}
