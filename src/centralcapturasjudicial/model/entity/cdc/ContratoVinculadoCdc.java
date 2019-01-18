/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centralcapturasjudicial.model.entity.cdc;
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

/**
 *
 * @author f6323539
 */
@Entity
@Table(name="tab_ctr_vinc_cdc"
    ,catalog="calculobbreu"
)

public class ContratoVinculadoCdc implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    private Long id;
    @ManyToOne
    @JoinColumn(name="id_ope")  
    private OperacaoCdc operacaoCdc;
    @Column(name="nr_ctr")
    private int nrContrato;
    @Column(name="tx_sis")
    private String txSistema;
    @Column(name="nr_age")
    private short nrAgencia;
    @Temporal(TemporalType.DATE) 
    @Column(name="dt_ope", length=10)
    private Date dtOperacao;  
    @Column(name="vl_sdo_dev")
    private Double vlSaldoDevedor;
    @Column(name="vl_sdo_ren")
    private Double vlSaldoRenegociado;

    public ContratoVinculadoCdc() {
    }

    public ContratoVinculadoCdc(OperacaoCdc tabOpeCdc, int nrCtr, String txSis, short nrAge, Date dtOpe, Double vlSdoDev, Double vlSdorRen) {
        this.operacaoCdc = tabOpeCdc;
        this.nrContrato = nrCtr;
        this.txSistema = txSis;
        this.nrAgencia = nrAge;
        this.dtOperacao = dtOpe;
        this.vlSaldoDevedor = vlSdoDev;
        this.vlSaldoRenegociado = vlSdorRen;
    }

    public HashMap<Integer,String> getValues(){
        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        
        HashMap<Integer,String> values = new HashMap<>();
        values.put(1, Integer.toString(getNrContrato()));
        values.put(2, getTxSistema());
        values.put(3, Short.toString(getNrAgencia()));
        if(getDtOperacao()== null) {
           values.put(4, ""); 
        }   
        else {   
           values.put(4, df.format(getDtOperacao()));
        }   
        values.put(5, String.format("%.2f", (getVlSaldoDevedor())).replace(".", ",")); 
        values.put(6, String.format("%.2f", (getVlSaldoRenegociado())).replace(".", ",")); 
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
     * @return the nrContrato
     */
    public int getNrContrato() {
        return nrContrato;
    }

    /**
     * @param nrContrato the nrContrato to set
     */
    public void setNrContrato(int nrContrato) {
        this.nrContrato = nrContrato;
    }

    /**
     * @return the txSistema
     */
    public String getTxSistema() {
        return txSistema;
    }

    /**
     * @param txSistema the txSistema to set
     */
    public void setTxSistema(String txSistema) {
        this.txSistema = txSistema;
    }

    /**
     * @return the nrAgencia
     */
    public short getNrAgencia() {
        return nrAgencia;
    }

    /**
     * @param nrAgencia the nrAgencia to set
     */
    public void setNrAgencia(short nrAgencia) {
        this.nrAgencia = nrAgencia;
    }

    /**
     * @return the dtOperacao
     */
    public Date getDtOperacao() {
        return dtOperacao;
    }

    /**
     * @param dtOperacao the dtOperacao to set
     */
    public void setDtOperacao(Date dtOperacao) {
        this.dtOperacao = dtOperacao;
    }

    /**
     * @return the vlSaldoDevedor
     */
    public Double getVlSaldoDevedor() {
        return vlSaldoDevedor;
    }

    /**
     * @param vlSaldoDevedor the vlSaldoDevedor to set
     */
    public void setVlSaldoDevedor(Double vlSaldoDevedor) {
        this.vlSaldoDevedor = vlSaldoDevedor;
    }

    /**
     * @return the vlSaldoRenegociado
     */
    public Double getVlSaldoRenegociado() {
        return vlSaldoRenegociado;
    }

    /**
     * @param vlSaldoRenegociado the vlSaldoRenegociado to set
     */
    public void setVlSaldoRenegociado(Double vlSaldoRenegociado) {
        this.vlSaldoRenegociado = vlSaldoRenegociado;
    }
}
