/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centralcapturasjudicial.model.entity.bbgiro;

import centralcapturasjudicial.model.entity.AbstractEntity;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author F5116163
 */
@Entity
@Table(name="tab_rpc")
public class Reposicao implements Serializable, AbstractEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @OneToOne(fetch = FetchType.LAZY)  
    @JoinColumn(name="id_opr_giro")
    private OperacaoGiro operacaoGiro;
    
    @Temporal(TemporalType.DATE)
    @Column(name="dt_lcto")
    private Date dtLancamento;    
    @Column(name="tx_ogm_lcto")
    private String txOrigemLancamento;

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
     * @return the txOrigemLancamento
     */
    public String getTxOrigemLancamento() {
        return txOrigemLancamento;
    }

    /**
     * @param txOrigemLancamento the txOrigemLancamento to set
     */
    public void setTxOrigemLancamento(String txOrigemLancamento) {
        this.txOrigemLancamento = txOrigemLancamento;
    }
    

    
}
