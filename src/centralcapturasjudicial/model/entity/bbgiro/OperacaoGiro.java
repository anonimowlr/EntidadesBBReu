/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centralcapturasjudicial.model.entity.bbgiro;

import centralcapturasjudicial.model.entity.AbstractEntity;
import centralcapturasjudicial.model.entity.bbgiro.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author F5116163
 */
@Entity
@Table(name="tab_opr_giro")
public class OperacaoGiro implements Serializable, AbstractEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @Column(name="tx_tip_opr")
    private String txTipoOperacao;
    @Column(name="nr_age")
    private int nrAgencia;
    @Column(name="tx_lnh_crd")
    private String txLinhaCredito;
    @Column(name="nr_opr")
    private int nrOperacao;
    @Column(name="tx_mtr")
    private String txMutuario;
    @Temporal(TemporalType.DATE)
    @Column(name="dt_prpt")
    private Date dtProposta;
    
    @OneToMany(mappedBy = "operacaoGiro", cascade = CascadeType.ALL, fetch = FetchType.LAZY)    
    private List<ExtratoConsolidado> listExtratoConsolidado;
    @OneToMany(mappedBy = "operacaoGiro", cascade = CascadeType.ALL, fetch = FetchType.LAZY)    
    private List<ItemFinanciado> listItemFinanciado;
    
    @OneToOne(mappedBy = "operacaoGiro", cascade = CascadeType.ALL, fetch = FetchType.LAZY)    
    private Reposicao reposicao;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the txTipoOperacao
     */
    public String getTxTipoOperacao() {
        return txTipoOperacao;
    }

    /**
     * @param txTipoOperacao the txTipoOperacao to set
     */
    public void setTxTipoOperacao(String txTipoOperacao) {
        this.txTipoOperacao = txTipoOperacao;
    }

    /**
     * @return the nrAgencia
     */
    public int getNrAgencia() {
        return nrAgencia;
    }

    /**
     * @param nrAgencia the nrAgencia to set
     */
    public void setNrAgencia(int nrAgencia) {
        this.nrAgencia = nrAgencia;
    }

    /**
     * @return the txLinhaCredito
     */
    public String getTxLinhaCredito() {
        return txLinhaCredito;
    }

    /**
     * @param txLinhaCredito the txLinhaCredito to set
     */
    public void setTxLinhaCredito(String txLinhaCredito) {
        this.txLinhaCredito = txLinhaCredito;
    }

    /**
     * @return the nrOperacao
     */
    public int getNrOperacao() {
        return nrOperacao;
    }

    /**
     * @param nrOperacao the nrOperacao to set
     */
    public void setNrOperacao(int nrOperacao) {
        this.nrOperacao = nrOperacao;
    }

    /**
     * @return the txMutuario
     */
    public String getTxMutuario() {
        return txMutuario;
    }

    /**
     * @param txMutuario the txMutuario to set
     */
    public void setTxMutuario(String txMutuario) {
        this.txMutuario = txMutuario;
    }

    /**
     * @return the dtProposta
     */
    public Date getDtProposta() {
        return dtProposta;
    }

    /**
     * @param dtProposta the dtProposta to set
     */
    public void setDtProposta(Date dtProposta) {
        this.dtProposta = dtProposta;
    }

    /**
     * @return the listExtratoConsolidado
     */
    public List<ExtratoConsolidado> getListExtratoConsolidado() {
        return listExtratoConsolidado;
    }

    /**
     * @param listExtratoConsolidado the listExtratoConsolidado to set
     */
    public void setListExtratoConsolidado(List<ExtratoConsolidado> listExtratoConsolidado) {
        this.listExtratoConsolidado = listExtratoConsolidado;
    }

    /**
     * @return the listItemFinanciado
     */
    public List<ItemFinanciado> getListItemFinanciado() {
        return listItemFinanciado;
    }

    /**
     * @param listItemFinanciado the listItemFinanciado to set
     */
    public void setListItemFinanciado(List<ItemFinanciado> listItemFinanciado) {
        this.listItemFinanciado = listItemFinanciado;
    }

    /**
     * @return the reposicao
     */
    public Reposicao getReposicao() {
        return reposicao;
    }

    /**
     * @param reposicao the reposicao to set
     */
    public void setReposicao(Reposicao reposicao) {
        this.reposicao = reposicao;
    }

    
}
