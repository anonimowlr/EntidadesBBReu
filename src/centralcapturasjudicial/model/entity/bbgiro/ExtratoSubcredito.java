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
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="tab_exto_sub_crd")
public class ExtratoSubcredito implements Serializable, AbstractEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name="id_item_fncd")    
    private ItemFinanciado itemFinanciado;
    
    @Temporal(TemporalType.DATE)
    @Column(name="dt_mvt")
    private Date dtMovimento;    
    @Column(name="tx_efe_opr")
    private String txEfeitoOperacao;
    @Column(name="tx_dcr_lcto")
    private String txDescricaoLancamento;
    @Column(name="vl_lcto")
    private Double vlLancamento;    

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
     * @return the dtMovimento
     */
    public Date getDtMovimento() {
        return dtMovimento;
    }

    /**
     * @param dtMovimento the dtMovimento to set
     */
    public void setDtMovimento(Date dtMovimento) {
        this.dtMovimento = dtMovimento;
    }

    /**
     * @return the txEfeitoOperacao
     */
    public String getTxEfeitoOperacao() {
        return txEfeitoOperacao;
    }

    /**
     * @param txEfeitoOperacao the txEfeitoOperacao to set
     */
    public void setTxEfeitoOperacao(String txEfeitoOperacao) {
        this.txEfeitoOperacao = txEfeitoOperacao;
    }

    /**
     * @return the txDescricaoLancamento
     */
    public String getTxDescricaoLancamento() {
        return txDescricaoLancamento;
    }

    /**
     * @param txDescricaoLancamento the txDescricaoLancamento to set
     */
    public void setTxDescricaoLancamento(String txDescricaoLancamento) {
        this.txDescricaoLancamento = txDescricaoLancamento;
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

    
    
}
