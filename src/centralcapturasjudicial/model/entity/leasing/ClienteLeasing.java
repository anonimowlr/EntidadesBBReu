/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centralcapturasjudicial.model.entity.leasing;

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
@Table(name="tab_cli_lsg")
public class ClienteLeasing implements Serializable, AbstractEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @OneToMany(mappedBy = "operacaoLeasing", cascade = CascadeType.ALL, fetch = FetchType.LAZY)    
    private OperacaoLeasing operacaoLeasing;
    
    @Column(name="nr_mci_cli")
    private Long nrMciCliente;
    @Column(name="tx_nm_cli")
    private String txNomeCliente;
    @Column(name="tx_cpf_cnpj_cli")
    private String txCpfCnpjCliente;

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
     * @return the nrMciCliente
     */
    public Long getNrMciCliente() {
        return nrMciCliente;
    }

    /**
     * @param nrMciCliente the nrMciCliente to set
     */
    public void setNrMciCliente(Long nrMciCliente) {
        this.nrMciCliente = nrMciCliente;
    }

    /**
     * @return the txNomeCliente
     */
    public String getTxNomeCliente() {
        return txNomeCliente;
    }

    /**
     * @param txNomeCliente the txNomeCliente to set
     */
    public void setTxNomeCliente(String txNomeCliente) {
        this.txNomeCliente = txNomeCliente;
    }

    /**
     * @return the txCpfCnpjCliente
     */
    public String getTxCpfCnpjCliente() {
        return txCpfCnpjCliente;
    }

    /**
     * @param txCpfCnpjCliente the txCpfCnpjCliente to set
     */
    public void setTxCpfCnpjCliente(String txCpfCnpjCliente) {
        this.txCpfCnpjCliente = txCpfCnpjCliente;
    }
    
    

    
}
