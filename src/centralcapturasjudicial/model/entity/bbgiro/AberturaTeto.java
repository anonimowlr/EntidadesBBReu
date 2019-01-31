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
@Table(name="tab_abtr_teto")
public class AberturaTeto implements Serializable, AbstractEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name="id_opr_giro")    
    private OperacaoGiro operacaoGiro;
    
    @Temporal(TemporalType.DATE)
    @Column(name="dt_inc")
    private Date dtInicio;    
    @Temporal(TemporalType.DATE)
    @Column(name="dt_fim")
    private Date dtFim; 
    @Column(name="vl_taxa")
    private Double vlTaxa;    

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
     * @return the operacaoGiro
     */
    public OperacaoGiro getOperacaoGiro() {
        return operacaoGiro;
    }

    /**
     * @param operacaoGiro the operacaoGiro to set
     */
    public void setOperacaoGiro(OperacaoGiro operacaoGiro) {
        this.operacaoGiro = operacaoGiro;
    }

    /**
     * @return the dtInicio
     */
    public Date getDtInicio() {
        return dtInicio;
    }

    /**
     * @param dtInicio the dtInicio to set
     */
    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }

    /**
     * @return the dtFim
     */
    public Date getDtFim() {
        return dtFim;
    }

    /**
     * @param dtFim the dtFim to set
     */
    public void setDtFim(Date dtFim) {
        this.dtFim = dtFim;
    }

    /**
     * @return the vlTaxa
     */
    public Double getVlTaxa() {
        return vlTaxa;
    }

    /**
     * @param vlTaxa the vlTaxa to set
     */
    public void setVlTaxa(Double vlTaxa) {
        this.vlTaxa = vlTaxa;
    }

    public HashMap<Integer,String> getValues(){
        SimpleDateFormat fd = new SimpleDateFormat("dd/MM/yyyy");
        
        HashMap<Integer,String> values = new HashMap<>();
        
        values.put(1, fd.format(getDtInicio()));
        values.put(2, fd.format(getDtFim()));
        values.put(3, String.format("%.2f", getVlTaxa()).replace(".", ","));
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
