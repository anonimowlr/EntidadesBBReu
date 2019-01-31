/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centralcapturasjudicial.model.entity.bbgiro;

import centralcapturasjudicial.model.entity.AbstractEntity;
import centralcapturasjudicial.model.entity.bbgiro.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto
    @Column(name="id") // nome coluna 
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
    
    @OneToMany(mappedBy = "operacaoGiro", cascade = CascadeType.ALL, fetch = FetchType.LAZY)    // nome da classe mappedBy
    private List<ExtratoConsolidado> listExtratoConsolidado;
    
    @OneToMany(mappedBy = "operacaoGiro", cascade = CascadeType.ALL, fetch = FetchType.LAZY)    
    private List<ItemFinanciado> listItemFinanciado;
    
    @OneToOne(mappedBy = "operacaoGiro", cascade = CascadeType.ALL, fetch = FetchType.LAZY)    
    private Reposicao reposicao;

    @OneToMany(mappedBy = "operacaoGiro", cascade = CascadeType.ALL, fetch = FetchType.LAZY)    
    private List<AberturaTeto> listAberturaTeto;
    

    public HashMap<Integer,String> getValues(){
//        SimpleDateFormat fd = new SimpleDateFormat("dd/MM/yyyy");
        
        HashMap<Integer,String> values = new HashMap<>();
        
        values.put(1, String.valueOf(getNrAgencia()));
        values.put(2, String.valueOf(getNrOperacao()));
        values.put(3, getTxMutuario());
//        values.put(4, String.valueOf(getVlSaldoArrendamento()).replace(".",","));
//        values.put(1, Integer.toString(getMesCartao().getExtrato().getCartao().getOperacao()));
//        values.put(2, getMesCartao().getDataVencimento().replace(".", "/"));
//        if(Double.toString(getMesCartao().getTxJuros()) != null) {
//            values.put(3, String.format("%.2f", (getMesCartao().getTxJuros())).replace(".", ","));
//        }
//        else {
//            values.put(3, ""); 
//        }
//        values.put(4, getDataTransacao().replace(".", "/"));
//        values.put(5, Integer.toString(getNrCartao()));
//        values.put(6, getDescricao());
//        values.put(7, String.format("%.2f", (getValor())).replace(".", ","));        
//        values.put(8, getMoeda());
        //values.put(9, String.format("%.2f", 1.5));
        //values.put(6, getMes().getDataFaturamento());
                        
        return values;
    }
    
    
    // ctrl shift alt E selecionar tudo refatorar 

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

    /**
     * @return the listAberturaTeto
     */
    public List<AberturaTeto> getListAberturaTeto() {
        return listAberturaTeto;
    }

    /**
     * @param listAberturaTeto the listAberturaTeto to set
     */
    public void setListAberturaTeto(List<AberturaTeto> listAberturaTeto) {
        this.listAberturaTeto = listAberturaTeto;
    }
}
