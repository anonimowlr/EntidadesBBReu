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
@Table(name="tab_opr_lsg")
public class OperacaoLeasing implements Serializable, AbstractEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name="id_cli_lsg")  
    private ClienteLeasing clienteLeasing;
    
    @Column(name="nr_ctr")
    private Long nrContrato;
    @Column(name="tx_cst_arrd")
    private String txCustoArrendamento;
    @Column(name="tx_idx")
    private String txIndexador;
    @Column(name="nr_dia_vnct_pcl_msl")
    private int nrDiaVencimentoParcelaMensal;
    @Column(name="tx_pz")
    private String txPrazo;
    @Temporal(TemporalType.DATE)
    @Column(name="dt_ass_tra")
    private Date dtAssinaturaTra;
    @Temporal(TemporalType.DATE)
    @Column(name="dt_vnct_prmo_pcl")
    private Date dtVencimentoPrimeiraParcela;
    @Column(name="vl_bem")
    private Double vlBem;
    
    @OneToMany(mappedBy = "operacaoLeasing", cascade = CascadeType.ALL, fetch = FetchType.LAZY)    
    private List<LancamentoLeasing> listLancamentoLeasing;

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
     * @return the clienteLeasing
     */
    public ClienteLeasing getClienteLeasing() {
        return clienteLeasing;
    }

    /**
     * @param clienteLeasing the clienteLeasing to set
     */
    public void setClienteLeasing(ClienteLeasing clienteLeasing) {
        this.clienteLeasing = clienteLeasing;
    }

    /**
     * @return the nrContrato
     */
    public Long getNrContrato() {
        return nrContrato;
    }

    /**
     * @param nrContrato the nrContrato to set
     */
    public void setNrContrato(Long nrContrato) {
        this.nrContrato = nrContrato;
    }

    /**
     * @return the txCustoArrendamento
     */
    public String getTxCustoArrendamento() {
        return txCustoArrendamento;
    }

    /**
     * @param txCustoArrendamento the txCustoArrendamento to set
     */
    public void setTxCustoArrendamento(String txCustoArrendamento) {
        this.txCustoArrendamento = txCustoArrendamento;
    }

    /**
     * @return the txIndexador
     */
    public String getTxIndexador() {
        return txIndexador;
    }

    /**
     * @param txIndexador the txIndexador to set
     */
    public void setTxIndexador(String txIndexador) {
        this.txIndexador = txIndexador;
    }

    /**
     * @return the nrDiaVencimentoParcelaMensal
     */
    public int getNrDiaVencimentoParcelaMensal() {
        return nrDiaVencimentoParcelaMensal;
    }

    /**
     * @param nrDiaVencimentoParcelaMensal the nrDiaVencimentoParcelaMensal to set
     */
    public void setNrDiaVencimentoParcelaMensal(int nrDiaVencimentoParcelaMensal) {
        this.nrDiaVencimentoParcelaMensal = nrDiaVencimentoParcelaMensal;
    }

    /**
     * @return the txPrazo
     */
    public String getTxPrazo() {
        return txPrazo;
    }

    /**
     * @param txPrazo the txPrazo to set
     */
    public void setTxPrazo(String txPrazo) {
        this.txPrazo = txPrazo;
    }

    /**
     * @return the dtAssinaturaTra
     */
    public Date getDtAssinaturaTra() {
        return dtAssinaturaTra;
    }

    /**
     * @param dtAssinaturaTra the dtAssinaturaTra to set
     */
    public void setDtAssinaturaTra(Date dtAssinaturaTra) {
        this.dtAssinaturaTra = dtAssinaturaTra;
    }

    /**
     * @return the dtVencimentoPrimeiraParcela
     */
    public Date getDtVencimentoPrimeiraParcela() {
        return dtVencimentoPrimeiraParcela;
    }

    /**
     * @param dtVencimentoPrimeiraParcela the dtVencimentoPrimeiraParcela to set
     */
    public void setDtVencimentoPrimeiraParcela(Date dtVencimentoPrimeiraParcela) {
        this.dtVencimentoPrimeiraParcela = dtVencimentoPrimeiraParcela;
    }

    /**
     * @return the vlBem
     */
    public Double getVlBem() {
        return vlBem;
    }

    /**
     * @param vlBem the vlBem to set
     */
    public void setVlBem(Double vlBem) {
        this.vlBem = vlBem;
    }

    /**
     * @return the listLancamentoLeasing
     */
    public List<LancamentoLeasing> getListLancamentoLeasing() {
        return listLancamentoLeasing;
    }

    /**
     * @param listLancamentoLeasing the listLancamentoLeasing to set
     */
    public void setListLancamentoLeasing(List<LancamentoLeasing> listLancamentoLeasing) {
        this.listLancamentoLeasing = listLancamentoLeasing;
    }

    
}
