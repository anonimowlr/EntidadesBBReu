/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centralcapturasjudicial.model.entity.cdc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
 * @author F6323539
 */

@Entity
@Table(name="tab_pgto_pcl_cdc"
    ,catalog="calculobbreu"
)

public class PagamentoParcelaCdc implements java.io.Serializable{
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name="id", unique=true, nullable=false)
     private Long id;
     @ManyToOne
     @JoinColumn(name="id_pcl")    
     private ParcelaOperacaoCdc parcelaOperacaoCdc;
     @OneToMany(mappedBy = "pagamentoParcelaCdc", cascade = CascadeType.ALL,  fetch = FetchType.LAZY)
     private List<ComponentePagamentoParcelaCdc> listComponentePagamentoParcelaCdc = new ArrayList();
     @Column(name="nr_rec")
     private short nrRecebimento;
     @Temporal(TemporalType.DATE)
     @Column(name="dt_rec", length=10)
     private Date DtRecebimento;

    public PagamentoParcelaCdc() {
    }

    public PagamentoParcelaCdc(ParcelaOperacaoCdc tabPclOpeCdc, short nrRec, Date DtRec) {
        this.parcelaOperacaoCdc = tabPclOpeCdc;
        this.nrRecebimento = nrRec;
        this.DtRecebimento = DtRec;
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
     * @return the parcelaOperacaoCdc
     */
    public ParcelaOperacaoCdc getParcelaOperacaoCdc() {
        return parcelaOperacaoCdc;
    }

    /**
     * @param parcelaOperacaoCdc the parcelaOperacaoCdc to set
     */
    public void setParcelaOperacaoCdc(ParcelaOperacaoCdc parcelaOperacaoCdc) {
        this.parcelaOperacaoCdc = parcelaOperacaoCdc;
    }

    /**
     * @return the listComponentePagamentoParcelaCdc
     */
    public List<ComponentePagamentoParcelaCdc> getListComponentePagamentoParcelaCdc() {
        return listComponentePagamentoParcelaCdc;
    }

    /**
     * @param listComponentePagamentoParcelaCdc the listComponentePagamentoParcelaCdc to set
     */
    public void setListComponentePagamentoParcelaCdc(List<ComponentePagamentoParcelaCdc> listComponentePagamentoParcelaCdc) {
        this.listComponentePagamentoParcelaCdc = listComponentePagamentoParcelaCdc;
    }

    /**
     * @return the nrRecebimento
     */
    public short getNrRecebimento() {
        return nrRecebimento;
    }

    /**
     * @param nrRecebimento the nrRecebimento to set
     */
    public void setNrRecebimento(short nrRecebimento) {
        this.nrRecebimento = nrRecebimento;
    }

    /**
     * @return the DtRecebimento
     */
    public Date getDtRecebimento() {
        return DtRecebimento;
    }

    /**
     * @param DtRecebimento the DtRecebimento to set
     */
    public void setDtRecebimento(Date DtRecebimento) {
        this.DtRecebimento = DtRecebimento;
    }

    
    
    
 
}