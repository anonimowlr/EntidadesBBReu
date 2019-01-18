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
@Table(name="tab_item_fncd")
public class ItemFinanciado implements Serializable, AbstractEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name="id_opr_giro")    
    private OperacaoGiro operacaoGiro;
  
    @Column(name="tx_item_fncd")
    private String txItemFinanciado;
    @Column(name="tx_sub_crd")
    private String txSubcredito;

    @OneToMany(mappedBy = "itemFinanciado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)    
    private List<ExtratoSubcredito> listExtratoSubcredito;
    @OneToMany(mappedBy = "itemFinanciado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)    
    private List<EncargoSubcredito> listEncargoSubcredito;

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
     * @return the txItemFinanciado
     */
    public String getTxItemFinanciado() {
        return txItemFinanciado;
    }

    /**
     * @param txItemFinanciado the txItemFinanciado to set
     */
    public void setTxItemFinanciado(String txItemFinanciado) {
        this.txItemFinanciado = txItemFinanciado;
    }

    /**
     * @return the txSubcredito
     */
    public String getTxSubcredito() {
        return txSubcredito;
    }

    /**
     * @param txSubcredito the txSubcredito to set
     */
    public void setTxSubcredito(String txSubcredito) {
        this.txSubcredito = txSubcredito;
    }

    /**
     * @return the listExtratoSubcredito
     */
    public List<ExtratoSubcredito> getListExtratoSubcredito() {
        return listExtratoSubcredito;
    }

    /**
     * @param listExtratoSubcredito the listExtratoSubcredito to set
     */
    public void setListExtratoSubcredito(List<ExtratoSubcredito> listExtratoSubcredito) {
        this.listExtratoSubcredito = listExtratoSubcredito;
    }

    /**
     * @return the listEncargoSubcredito
     */
    public List<EncargoSubcredito> getListEncargoSubcredito() {
        return listEncargoSubcredito;
    }

    /**
     * @param listEncargoSubcredito the listEncargoSubcredito to set
     */
    public void setListEncargoSubcredito(List<EncargoSubcredito> listEncargoSubcredito) {
        this.listEncargoSubcredito = listEncargoSubcredito;
    }

    
}
