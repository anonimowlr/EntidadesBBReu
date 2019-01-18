/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centralcapturasjudicial.model.entity.cdc;

import centralcapturasjudicial.model.entity.cdc.OperacaoCdc;
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
 * @author f6323539
 */
@Entity
@Table(name="tab_pcl_ope_cdc"
    ,catalog="calculobbreu"
)

public class ParcelaOperacaoCdc implements java.io.Serializable {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name="id", unique=true, nullable=false)
     private Long id;     
     @ManyToOne
     @JoinColumn(name="id_ope")   
     private OperacaoCdc operacaoCdc;     
     @OneToMany(mappedBy = "parcelaOperacaoCdc", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
     private List<PagamentoParcelaCdc> listPagamentoParcelaCdc = new ArrayList();     
     @Column(name="nr_pcl")
     private int nrParcela;     
     @Temporal(TemporalType.DATE) 
     @Column(name="dt_vcto", length=10)
     private Date dtVencimento;     
     @Temporal(TemporalType.DATE) 
     @Column(name="dt_cobr", length=10) 
     private Date dtCobranca;        
     @Temporal(TemporalType.DATE) 
     @Column(name="dt_pgto", length=10)
     private Date dtPagamento;
     @Column(name="vl_cap")
     private Double vlCapital;
     @Column(name="vl_jur")
     private Double vlJuros;

    public ParcelaOperacaoCdc() {
    }    

    public ParcelaOperacaoCdc(OperacaoCdc tabOpeCdc, int nrPcl, Date dtVcto, Date dtCobr, Date dtPgto, Double vlCap, Double vlJur) {
        this.operacaoCdc = tabOpeCdc;
        this.nrParcela = nrPcl;
        this.dtVencimento = dtVcto;
        this.dtCobranca = dtCobr;
        this.dtPagamento = dtPgto;
        this.vlCapital = vlCap;
        this.vlJuros = vlJur;
    }
    
    public HashMap<Integer,String> getValues(){
        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");     
        
        HashMap<Integer,String> values = new HashMap<>();  
        values.put(1, Integer.toString(getNrParcela()));
        
        if(getDtVencimento()!= null) {
            values.put(2, df.format(getDtVencimento())); 
        }
        else {
            values.put(2, ""); 
        }
        
        //values.put(2, df.format(getDtVcto()));
        
        if(getDtCobranca()!= null) {
            values.put(3, df.format(getDtCobranca())); 
        }
        else {
            values.put(3, ""); 
        }
        
        //values.put(3, df.format(getDtCobr())); 
        
        if(getVlJuros()!= null) {
            values.put(4, String.format("%.2f",(getVlJuros())).replace(".", ","));
        }
        else {
            values.put(4, ""); 
        }
        
        //values.put(4, String.format("%.2f",(getVlJur())).replace(".", ","));
        values.put(5, String.format("%.2f",(getVlCapital())).replace(".", ","));
        if(getDtPagamento()== null) {
           values.put(6, ""); 
        }
        else {
           values.put(6, df.format(getDtPagamento())); 
        }   
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
     * @return the operacaoCdc
     */
    public OperacaoCdc getOperacaoCdc() {
        return operacaoCdc;
    }

    /**
     * @param operacaoCdc the operacaoCdc to set
     */
    public void setOperacaoCdc(OperacaoCdc operacaoCdc) {
        this.operacaoCdc = operacaoCdc;
    }

    /**
     * @return the listPagamentoParcelaCdc
     */
    public List<PagamentoParcelaCdc> getListPagamentoParcelaCdc() {
        return listPagamentoParcelaCdc;
    }

    /**
     * @param listPagamentoParcelaCdc the listPagamentoParcelaCdc to set
     */
    public void setListPagamentoParcelaCdc(List<PagamentoParcelaCdc> listPagamentoParcelaCdc) {
        this.listPagamentoParcelaCdc = listPagamentoParcelaCdc;
    }

    /**
     * @return the nrParcela
     */
    public int getNrParcela() {
        return nrParcela;
    }

    /**
     * @param nrParcela the nrParcela to set
     */
    public void setNrParcela(int nrParcela) {
        this.nrParcela = nrParcela;
    }

    /**
     * @return the dtVencimento
     */
    public Date getDtVencimento() {
        return dtVencimento;
    }

    /**
     * @param dtVencimento the dtVencimento to set
     */
    public void setDtVencimento(Date dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    /**
     * @return the dtCobranca
     */
    public Date getDtCobranca() {
        return dtCobranca;
    }

    /**
     * @param dtCobranca the dtCobranca to set
     */
    public void setDtCobranca(Date dtCobranca) {
        this.dtCobranca = dtCobranca;
    }

    /**
     * @return the dtPagamento
     */
    public Date getDtPagamento() {
        return dtPagamento;
    }

    /**
     * @param dtPagamento the dtPagamento to set
     */
    public void setDtPagamento(Date dtPagamento) {
        this.dtPagamento = dtPagamento;
    }

    /**
     * @return the vlCapital
     */
    public Double getVlCapital() {
        return vlCapital;
    }

    /**
     * @param vlCapital the vlCapital to set
     */
    public void setVlCapital(Double vlCapital) {
        this.vlCapital = vlCapital;
    }

    /**
     * @return the vlJuros
     */
    public Double getVlJuros() {
        return vlJuros;
    }

    /**
     * @param vlJuros the vlJuros to set
     */
    public void setVlJuros(Double vlJuros) {
        this.vlJuros = vlJuros;
    }

   
    
}
