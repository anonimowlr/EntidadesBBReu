/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centralcapturasjudicial.model.entity.leasing;

import centralcapturasjudicial.model.entity.AbstractEntity;
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
@Table(name="tab_lcto_lsg")
public class LancamentoLeasing implements Serializable, AbstractEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name="id_opr_lsg")    
    private OperacaoLeasing operacaoLeasing;
    
    @Temporal(TemporalType.DATE)
    @Column(name="dt_lcto")
    private Date dtLancamento;
  
    @Column(name="tx_hst")
    private String txHistorico;
    
    @Column(name="vl_lcto")
    private Double vlLancamento;
    
    @Column(name="vl_sld_arrd")
    private Double vlSaldoArrendamento;
    
    public HashMap<Integer,String> getValues(){
        SimpleDateFormat fd = new SimpleDateFormat("dd/MM/yyyy");
        
        HashMap<Integer,String> values = new HashMap<>();
        values.put(1, fd.format(getDtLancamento()));
        values.put(2, getTxHistorico());
        values.put(3, String.valueOf(getVlLancamento()).replace(".",","));
        values.put(4, String.valueOf(getVlSaldoArrendamento()).replace(".",","));
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
     * @return the operacaoLeasing
     */
    public OperacaoLeasing getOperacaoLeasing() {
        return operacaoLeasing;
    }

    /**
     * @param operacaoLeasing the operacaoLeasing to set
     */
    public void setOperacaoLeasing(OperacaoLeasing operacaoLeasing) {
        this.operacaoLeasing = operacaoLeasing;
    }

    /**
     * @return the dtLancamento
     */
    public Date getDtLancamento() {
        return dtLancamento;
    }

    /**
     * @param dtLancamento the dtLancamento to set
     */
    public void setDtLancamento(Date dtLancamento) {
        this.dtLancamento = dtLancamento;
    }

    /**
     * @return the txHistorico
     */
    public String getTxHistorico() {
        return txHistorico;
    }

    /**
     * @param txHistorico the txHistorico to set
     */
    public void setTxHistorico(String txHistorico) {
        this.txHistorico = txHistorico;
    }

    /**
     * @return the vlLancamento
     */
    public Double getVlLancamento() {
        return vlLancamento;
    }

    /**
     * @param vlLancamento the vlLancamento to set
     */
    public void setVlLancamento(Double vlLancamento) {
        this.vlLancamento = vlLancamento;
    }

    /**
     * @return the vlSaldoArrendamento
     */
    public Double getVlSaldoArrendamento() {
        return vlSaldoArrendamento;
    }

    /**
     * @param vlSaldoArrendamento the vlSaldoArrendamento to set
     */
    public void setVlSaldoArrendamento(Double vlSaldoArrendamento) {
        this.vlSaldoArrendamento = vlSaldoArrendamento;
    }

    
}
