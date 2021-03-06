/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centralcapturasjudicial.model.entity.bbgiro;

import centralcapturasjudicial.model.entity.AbstractEntity;
import centralcapturasjudicial.model.entity.bbgiro.*;
import centralcapturasjudicial.model.entity.cdc.ParcelaOperacaoCdc;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author F5116163
 */
@Entity
@Table(name="tab_encg_sub_crd")
public class EncargoSubcredito implements Serializable, AbstractEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name="id_item_fncd")    
    private ItemFinanciado itemFinanciado;
    
    @Column(name="tx_base_clc_encg")
    private String txBaseCalculoEncargo;
    @Column(name="tx_tipo_encg")
    private String txTipoEncargo;
    @Column(name="tx_perc")
    private String txPercentual;
    @Column(name="tx_moe")
    private String txMoeda;   

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
     * @return the itemFinanciado
     */
    public ItemFinanciado getItemFinanciado() {
        return itemFinanciado;
    }

    /**
     * @param itemFinanciado the itemFinanciado to set
     */
    public void setItemFinanciado(ItemFinanciado itemFinanciado) {
        this.itemFinanciado = itemFinanciado;
    }

    /**
     * @return the txBaseCalculoEncargo
     */
    public String getTxBaseCalculoEncargo() {
        return txBaseCalculoEncargo;
    }

    /**
     * @param txBaseCalculoEncargo the txBaseCalculoEncargo to set
     */
    public void setTxBaseCalculoEncargo(String txBaseCalculoEncargo) {
        this.txBaseCalculoEncargo = txBaseCalculoEncargo;
    }

    /**
     * @return the txTipoEncargo
     */
    public String getTxTipoEncargo() {
        return txTipoEncargo;
    }

    /**
     * @param txTipoEncargo the txTipoEncargo to set
     */
    public void setTxTipoEncargo(String txTipoEncargo) {
        this.txTipoEncargo = txTipoEncargo;
    }

    /**
     * @return the txPercentual
     */
    public String getTxPercentual() {
        return txPercentual;
    }

    /**
     * @param txPercentual the txPercentual to set
     */
    public void setTxPercentual(String txPercentual) {
        this.txPercentual = txPercentual;
    }

    /**
     * @return the txMoeda
     */
    public String getTxMoeda() {
        return txMoeda;
    }

    /**
     * @param txMoeda the txMoeda to set
     */
    public void setTxMoeda(String txMoeda) {
        this.txMoeda = txMoeda;
    }

    public HashMap<Integer,String> getValues(){
        SimpleDateFormat fd = new SimpleDateFormat("dd/MM/yyyy");
        
        HashMap<Integer,String> values = new HashMap<>();
        
        values.put(1, getTxBaseCalculoEncargo());
        values.put(2, getTxTipoEncargo());
        values.put(3, getTxPercentual());
        values.put(4, getTxMoeda());

       
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
    
}
