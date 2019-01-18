/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centralcapturasjudicial.model.entity.contacorrente;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author f6323539
 */
@Entity
@Table(name="tab_lcto_cc"
    ,catalog="calculobbreu"    
)

public class LancamentoConta  implements java.io.Serializable {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name="id", unique=true, nullable=false)
     private long id;   
     @ManyToOne()
     @JoinColumn(name="id_mes") 
     private MesConta mesConta;
     @Temporal(TemporalType.DATE)
     @Column(name="dt_lcto", length=10)
     private Date dtLancamento;
     @Column(name="nr_hst")
     private Integer nrHistorico;
     @Column(name="tx_hst", length=50)
     private String txHistorico;
     @Column(name="nr_doc", length=20)
     private String nrDocumento;
     @Column(name="vl_doc", precision=22, scale=0)
     private Double vlDocumento;
     @Column(name="in_ope_lcto", length=1)
     private Character inOperacaoLancamento;
     @Column(name="vl_sdo", precision=22, scale=0)
     private Double vlSaldo;
     @Column(name="nr_bco")
     private Integer nrBanco;
     @Column(name="nr_orig")
     private Integer nrOrigem;
     @Column(name="nr_lote")
     private Integer nrLote;

    public LancamentoConta() {
    }
	
    public LancamentoConta(long idLcto) {
        this.id = id;
    }
    
    public LancamentoConta(MesConta tabMesCc,  Date dtLcto, Integer nrHst, String txHst, String nrDoc, Double vlDoc, Character inOpeLcto, Double vlSdo, Integer nrBco, Integer nrOrig, Integer nrLote) {
       this.mesConta = tabMesCc;
       this.dtLancamento = dtLcto;
       this.nrHistorico = nrHst;
       this.txHistorico = txHst;
       this.nrDocumento = nrDoc;
       this.vlDocumento = vlDoc;
       this.inOperacaoLancamento = inOpeLcto;
       this.vlSaldo = vlSdo;
       this.nrBanco = nrBco;
       this.nrOrigem = nrOrig;
       this.nrLote = nrLote;
    }
   
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }    
    
    public HashMap<Integer,String> getValues(int opcao){
        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        HashMap<Integer,String> values = new HashMap<>();
        
        if(opcao == 1) { // Prestação de contas
            values.put(1, df.format(getDtLancamento()));
            values.put(2, String.format("%03d", getNrHistorico()));
            values.put(3, getTxHistorico());
            values.put(4, getNrDocumento()); 
            values.put(5, String.format("%.2f", (getVlDocumento())).replace(".", ","));
            values.put(6, Character.toString(getInOperacaoLancamento()));
            if(getNrBanco()== null)  {
                values.put(7, "");
            }
            else {
                values.put(7, Integer.toString(getNrBanco()));
            } 
            if(getNrOrigem()== null)  {
                 values.put(8, "");
            }
            else {
                values.put(8, Integer.toString(getNrOrigem()));
            } 
            if(getNrLote() == null)  {
                 values.put(9, "");
            }
            else {
                values.put(9, Integer.toString(getNrLote()));
            } 
            values.put(10, String.format("%.2f", (getVlSaldo())).replace(".", ","));
        }    
        else { // Revisional    
            values.put(1, df.format(getDtLancamento()));
            if(Character.toString(getInOperacaoLancamento()).equals("D")) {
               values.put(2, "3000"); 
            }
            else {
               values.put(2, "8000"); 
            }
            values.put(3, getTxHistorico());
            values.put(4, getNrDocumento()); 
            values.put(5, String.format("%.2f", (getVlDocumento())).replace(".", ","));
            values.put(6, String.format("%.2f", (getVlSaldo())).replace(".", ","));
        }
        return values;
    }

    /**
     * @return the mesConta
     */
    public MesConta getMesConta() {
        return mesConta;
    }

    /**
     * @param mesConta the mesConta to set
     */
    public void setMesConta(MesConta mesConta) {
        this.mesConta = mesConta;
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
     * @return the nrHistorico
     */
    public Integer getNrHistorico() {
        return nrHistorico;
    }

    /**
     * @param nrHistorico the nrHistorico to set
     */
    public void setNrHistorico(Integer nrHistorico) {
        this.nrHistorico = nrHistorico;
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
     * @return the nrDocumento
     */
    public String getNrDocumento() {
        return nrDocumento;
    }

    /**
     * @param nrDocumento the nrDocumento to set
     */
    public void setNrDocumento(String nrDocumento) {
        this.nrDocumento = nrDocumento;
    }

    /**
     * @return the vlDocumento
     */
    public Double getVlDocumento() {
        return vlDocumento;
    }

    /**
     * @param vlDocumento the vlDocumento to set
     */
    public void setVlDocumento(Double vlDocumento) {
        this.vlDocumento = vlDocumento;
    }

    /**
     * @return the inOperacaoLancamento
     */
    public Character getInOperacaoLancamento() {
        return inOperacaoLancamento;
    }

    /**
     * @param inOperacaoLancamento the inOperacaoLancamento to set
     */
    public void setInOperacaoLancamento(Character inOperacaoLancamento) {
        this.inOperacaoLancamento = inOperacaoLancamento;
    }

    /**
     * @return the vlSaldo
     */
    public Double getVlSaldo() {
        return vlSaldo;
    }

    /**
     * @param vlSaldo the vlSaldo to set
     */
    public void setVlSaldo(Double vlSaldo) {
        this.vlSaldo = vlSaldo;
    }

    /**
     * @return the nrBanco
     */
    public Integer getNrBanco() {
        return nrBanco;
    }

    /**
     * @param nrBanco the nrBanco to set
     */
    public void setNrBanco(Integer nrBanco) {
        this.nrBanco = nrBanco;
    }

    /**
     * @return the nrOrigem
     */
    public Integer getNrOrigem() {
        return nrOrigem;
    }

    /**
     * @param nrOrigem the nrOrigem to set
     */
    public void setNrOrigem(Integer nrOrigem) {
        this.nrOrigem = nrOrigem;
    }

    /**
     * @return the nrLote
     */
    public Integer getNrLote() {
        return nrLote;
    }

    /**
     * @param nrLote the nrLote to set
     */
    public void setNrLote(Integer nrLote) {
        this.nrLote = nrLote;
    }
}



