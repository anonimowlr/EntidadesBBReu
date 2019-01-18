/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centralcapturasjudicial.model.entity.cdc;

import centralcapturasjudicial.model.entity.AbstractEntity;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author f6323539
 */
@Entity
@Table(name="tab_ope_cdc"
    ,catalog="calculobbreu")

public class OperacaoCdc implements java.io.Serializable, AbstractEntity  {
     @Id
     //@Column(name="id")
     //@Id
     //@GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name="id", unique=true, nullable=false)
     private Long id;  
     @Column(name="cpf_cli")
     private String cpfCliente;
     @Column(name="nm_cli")
     private String nomeCliente;
     @OneToMany(mappedBy = "operacaoCdc", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
     private List<ParcelaOperacaoCdc> listParcelaOperacaoCdc = new ArrayList();   
     @OneToMany(mappedBy = "operacaoCdc", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
     private List<ContratoVinculadoCdc> listContratoVinculadoCdc = new ArrayList();     
     @Column(name="nr_age_deb", length=7)
     private String nrAgenciaDebito;
     @Column(name="nr_cta_deb", length=20)
     private String nrContaDebito;   
     @Column(name="vl_tot_fin")
     private Double vlTotalFinanciado;
     @Column(name="vl_sol")
     private Double vlSolicitado;
     @Column(name="vl_iof")
     private Double vlIof;
     @Column(name="vl_jur_care")
     private Double vlJurosCarencia;
     @Column(name="vl_base_calc")
     private Double vlBaseCalculo;
     @Column(name="vl_prest")
     private Double vlPrestacao;
     @Column(name="qt_parc")
     private short qtParcela;
     @Column(name="nr_dia_parc")
     private byte nrDiaParcela;
     @Temporal(TemporalType.DATE)
     @Column(name="dt_prim_pcl", length=10)
     private Date dtPrimeiraParcela;     
     @Temporal(TemporalType.DATE)
     @Column(name="dt_ult_pcl", length=10)
     private Date dtUltimaParcela;
     @Column(name="tx_jur_msl")
     private float txJurosMensal;
     @Column(name="tx_jur_anual")
     private float txJurosAnual;
     @Temporal(TemporalType.DATE) 
     @Column(name="dt_ult_ic", length=10)
     private Date dtUltimoIndice;
     @Temporal(TemporalType.DATE) 
     @Column(name="dt_base_care", length=10)
     private Date dtBaseCarencia;
     @Temporal(TemporalType.DATE) 
     @Column(name="dt_sdo_dev", length=10)
     private Date dtSaldoDevedor;
     @Column(name="vl_sdo_dev")
     private Double vlSaldoDevedor;
     @Column(name="vl_tot_jur")
     private Double vlTotalJuros;
     @Temporal(TemporalType.DATE) 
     @Column(name="dt_pcl_ser", length=10)
     private Date dtParcelaSer;  
     @Column(name="vl_prest_amtz")
     private Double vlPrestacaoAmortizada;
     @Column(name="tx_sit")
     private String txSituacaoCdc;
     @Column(name="chave_func")
     private String chaveFunci;
     //@Temporal(TemporalType.TIMESTAMP)
     //@Column(name = "hor_inc_func", columnDefinition="TIMESTAMP")
     @Column(name="hor_inc_func")
     private LocalDateTime hor_inc_func;

    public OperacaoCdc() {
    }

    public OperacaoCdc(String cpfCli, String nomeCli, String nrAgeDeb, String nrCtaDeb, Double vlTotFin, Double vlSol, Double vlIof, Double vlJurCare, Double vlBaseCalc, Double vlPrest, short qtParc, byte nrDiaPcl, Date dtPrimPcl, Date dtUltPcl, float txJurMsl, float txJurAnual, Date dtUltIc, Date dtBaseCare, Date dtSdoDev, Double vlSdoDev, Double vlTotJur, Date dtPclSer, Double vlPrestAmtz, String txSitCdc, String chaveFunci, LocalDateTime hor_inc_func) {
        this.cpfCliente = cpfCli;
        this.nomeCliente = nomeCli;
        this.nrAgenciaDebito = nrAgeDeb;
        this.nrContaDebito = nrCtaDeb;
        this.vlTotalFinanciado = vlTotFin;
        this.vlSolicitado = vlSol;
        this.vlIof = vlIof;
        this.vlJurosCarencia = vlJurCare;
        this.vlBaseCalculo = vlBaseCalc;
        this.vlPrestacao = vlPrest;
        this.qtParcela = qtParc;
        this.nrDiaParcela = nrDiaPcl;
        this.dtPrimeiraParcela = dtPrimPcl;
        this.dtUltimaParcela = dtUltPcl;
        this.txJurosMensal = txJurMsl;
        this.txJurosAnual = txJurAnual;
        this.dtUltimoIndice = dtUltIc;
        this.dtBaseCarencia = dtBaseCare;
        this.dtSaldoDevedor = dtSdoDev;
        this.vlSaldoDevedor = vlSdoDev;
        this.vlTotalJuros = vlTotJur;
        this.dtParcelaSer = dtPclSer;
        this.vlPrestacaoAmortizada = vlPrestAmtz;
        this.txSituacaoCdc = txSitCdc;
        this.chaveFunci = chaveFunci;
        this.hor_inc_func = hor_inc_func;
    }
    
    public String[] getCabecalhoOperacao(){
                        
        String[] cabecalho = {"Operação","    CPF     ","Situação da Operação","Agência","Conta","Total Financiado", "Valor Solicitado","Valor IOF","Juros Carência","Base Cálculo","Valor Prestação","Qt Parc.",
        "Dia","Prim. Parc.","ÚUlt. Parc.","Juros Mensal", "Juros Anual","Últ. Indice", "Base de Carência","Saldo Devedor","Saldo Devedor","Total Juros"};
        
        return cabecalho;
    }
     
    public String[] getCabecalhoParcelas(){
                        
        String[] cabecalho = {"Parcela","Data Vcto","Data Cobrança","   Juros   ","   Capital   ","Data Pgto","Nr Rec.", "Data Receb.","Componentes do Pgto"," Valor "};
        
        return cabecalho;
    } 
     
    public String[] getCabecalhoContratos(){
                        
        String[] cabecalho = {"Contrato","Sistema","Agência","Operação","Saldo Devedor", "Saldo Renegociado"};
        
        return cabecalho;
    } 
    
    public HashMap<Integer,String> getValues() throws ParseException{
        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
        MaskFormatter mf = new MaskFormatter("###.###.###-##"); 
        mf.setValueContainsLiteralCharacters(false);
        HashMap<Integer,String> values = new HashMap<>();
        values.put(1, Long.toString(getId()));
        values.put(2, mf.valueToString(String.format("%011d", Long.parseLong(getCpfCliente()))));    
        values.put(3, getTxSituacaoCdc());
        values.put(4, getNrAgenciaDebito());
        values.put(5, getNrContaDebito());
        values.put(6, String.format("%.2f", (getVlTotalFinanciado())).replace(".", ",")); 
        values.put(7, String.format("%.2f", (getVlSolicitado())).replace(".", ",")); 
        values.put(8, String.format("%.2f", (getVlIof())).replace(".", ",")); 
        values.put(9, String.format("%.2f", (getVlJurosCarencia())).replace(".", ","));
        
        if(getVlBaseCalculo()!= null) {
            values.put(10, String.format("%.2f", (getVlBaseCalculo())).replace(".", ","));
        }
        else {
            values.put(10, ""); 
        }
        values.put(11, String.format("%.2f",(getVlPrestacao())).replace(".", ","));
        values.put(12, Short.toString(getQtParcela()));
        values.put(13, Byte.toString(getNrDiaParcela()));
        values.put(14, df.format(getDtPrimeiraParcela()));
        
        if(getDtUltimaParcela()!= null) {
            values.put(15, df.format(getDtUltimaParcela()));
        }
        else {
            values.put(15, ""); 
        }
        values.put(16, String.format("%.2f",(getTxJurosMensal())).replace(".", ","));
        values.put(17, String.format("%.2f",(getTxJurosAnual())).replace(".", ","));
        
        if(getDtUltimoIndice()!= null) {
            values.put(18, df.format(getDtUltimoIndice()));
        }
        else {
            values.put(18, ""); 
        }
        if(getDtBaseCarencia()!= null) {
            values.put(19, df.format(getDtBaseCarencia()));
        }
        else {
            values.put(19, ""); 
        }
        values.put(20, df.format(getDtSaldoDevedor()));
        
        if(getVlSaldoDevedor()!= null) {
            values.put(21, String.format("%.2f",(getVlSaldoDevedor())).replace(".", ","));
        }
        else {
            values.put(21, ""); 
        }
        if(getVlTotalJuros()!= null) {
            values.put(22, String.format("%.2f",(getVlTotalJuros())).replace(".", ",")); 
        }
        else {
            values.put(22, ""); 
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
     * @return the cpfCliente
     */
    public String getCpfCliente() {
        return cpfCliente;
    }

    /**
     * @param cpfCliente the cpfCliente to set
     */
    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    /**
     * @return the nomeCliente
     */
    public String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * @param nomeCliente the nomeCliente to set
     */
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    /**
     * @return the listParcelaOperacaoCdc
     */
    public List<ParcelaOperacaoCdc> getListParcelaOperacaoCdc() {
        return listParcelaOperacaoCdc;
    }

    /**
     * @param listParcelaOperacaoCdc the listParcelaOperacaoCdc to set
     */
    public void setListParcelaOperacaoCdc(List<ParcelaOperacaoCdc> listParcelaOperacaoCdc) {
        this.listParcelaOperacaoCdc = listParcelaOperacaoCdc;
    }

    /**
     * @return the listContratoVinculadoCdc
     */
    public List<ContratoVinculadoCdc> getListContratoVinculadoCdc() {
        return listContratoVinculadoCdc;
    }

    /**
     * @param listContratoVinculadoCdc the listContratoVinculadoCdc to set
     */
    public void setListContratoVinculadoCdc(List<ContratoVinculadoCdc> listContratoVinculadoCdc) {
        this.listContratoVinculadoCdc = listContratoVinculadoCdc;
    }

    /**
     * @return the nrAgenciaDebito
     */
    public String getNrAgenciaDebito() {
        return nrAgenciaDebito;
    }

    /**
     * @param nrAgenciaDebito the nrAgenciaDebito to set
     */
    public void setNrAgenciaDebito(String nrAgenciaDebito) {
        this.nrAgenciaDebito = nrAgenciaDebito;
    }

    /**
     * @return the nrContaDebito
     */
    public String getNrContaDebito() {
        return nrContaDebito;
    }

    /**
     * @param nrContaDebito the nrContaDebito to set
     */
    public void setNrContaDebito(String nrContaDebito) {
        this.nrContaDebito = nrContaDebito;
    }

    /**
     * @return the vlTotalFinanciado
     */
    public Double getVlTotalFinanciado() {
        return vlTotalFinanciado;
    }

    /**
     * @param vlTotalFinanciado the vlTotalFinanciado to set
     */
    public void setVlTotalFinanciado(Double vlTotalFinanciado) {
        this.vlTotalFinanciado = vlTotalFinanciado;
    }

    /**
     * @return the vlSolicitado
     */
    public Double getVlSolicitado() {
        return vlSolicitado;
    }

    /**
     * @param vlSolicitado the vlSolicitado to set
     */
    public void setVlSolicitado(Double vlSolicitado) {
        this.vlSolicitado = vlSolicitado;
    }

    /**
     * @return the vlIof
     */
    public Double getVlIof() {
        return vlIof;
    }

    /**
     * @param vlIof the vlIof to set
     */
    public void setVlIof(Double vlIof) {
        this.vlIof = vlIof;
    }

    /**
     * @return the vlJurosCarencia
     */
    public Double getVlJurosCarencia() {
        return vlJurosCarencia;
    }

    /**
     * @param vlJurosCarencia the vlJurosCarencia to set
     */
    public void setVlJurosCarencia(Double vlJurosCarencia) {
        this.vlJurosCarencia = vlJurosCarencia;
    }

    /**
     * @return the vlBaseCalculo
     */
    public Double getVlBaseCalculo() {
        return vlBaseCalculo;
    }

    /**
     * @param vlBaseCalculo the vlBaseCalculo to set
     */
    public void setVlBaseCalculo(Double vlBaseCalculo) {
        this.vlBaseCalculo = vlBaseCalculo;
    }

    /**
     * @return the vlPrestacao
     */
    public Double getVlPrestacao() {
        return vlPrestacao;
    }

    /**
     * @param vlPrestacao the vlPrestacao to set
     */
    public void setVlPrestacao(Double vlPrestacao) {
        this.vlPrestacao = vlPrestacao;
    }

    /**
     * @return the qtParcela
     */
    public short getQtParcela() {
        return qtParcela;
    }

    /**
     * @param qtParcela the qtParcela to set
     */
    public void setQtParcela(short qtParcela) {
        this.qtParcela = qtParcela;
    }

    /**
     * @return the nrDiaParcela
     */
    public byte getNrDiaParcela() {
        return nrDiaParcela;
    }

    /**
     * @param nrDiaParcela the nrDiaParcela to set
     */
    public void setNrDiaParcela(byte nrDiaParcela) {
        this.nrDiaParcela = nrDiaParcela;
    }

    /**
     * @return the dtPrimeiraParcela
     */
    public Date getDtPrimeiraParcela() {
        return dtPrimeiraParcela;
    }

    /**
     * @param dtPrimeiraParcela the dtPrimeiraParcela to set
     */
    public void setDtPrimeiraParcela(Date dtPrimeiraParcela) {
        this.dtPrimeiraParcela = dtPrimeiraParcela;
    }

    /**
     * @return the dtUltimaParcela
     */
    public Date getDtUltimaParcela() {
        return dtUltimaParcela;
    }

    /**
     * @param dtUltimaParcela the dtUltimaParcela to set
     */
    public void setDtUltimaParcela(Date dtUltimaParcela) {
        this.dtUltimaParcela = dtUltimaParcela;
    }

    /**
     * @return the txJurosMensal
     */
    public float getTxJurosMensal() {
        return txJurosMensal;
    }

    /**
     * @param txJurosMensal the txJurosMensal to set
     */
    public void setTxJurosMensal(float txJurosMensal) {
        this.txJurosMensal = txJurosMensal;
    }

    /**
     * @return the txJurosAnual
     */
    public float getTxJurosAnual() {
        return txJurosAnual;
    }

    /**
     * @param txJurosAnual the txJurosAnual to set
     */
    public void setTxJurosAnual(float txJurosAnual) {
        this.txJurosAnual = txJurosAnual;
    }

    /**
     * @return the dtUltimoIndice
     */
    public Date getDtUltimoIndice() {
        return dtUltimoIndice;
    }

    /**
     * @param dtUltimoIndice the dtUltimoIndice to set
     */
    public void setDtUltimoIndice(Date dtUltimoIndice) {
        this.dtUltimoIndice = dtUltimoIndice;
    }

    /**
     * @return the dtBaseCarencia
     */
    public Date getDtBaseCarencia() {
        return dtBaseCarencia;
    }

    /**
     * @param dtBaseCarencia the dtBaseCarencia to set
     */
    public void setDtBaseCarencia(Date dtBaseCarencia) {
        this.dtBaseCarencia = dtBaseCarencia;
    }

    /**
     * @return the dtSaldoDevedor
     */
    public Date getDtSaldoDevedor() {
        return dtSaldoDevedor;
    }

    /**
     * @param dtSaldoDevedor the dtSaldoDevedor to set
     */
    public void setDtSaldoDevedor(Date dtSaldoDevedor) {
        this.dtSaldoDevedor = dtSaldoDevedor;
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
     * @return the vlTotalJuros
     */
    public Double getVlTotalJuros() {
        return vlTotalJuros;
    }

    /**
     * @param vlTotalJuros the vlTotalJuros to set
     */
    public void setVlTotalJuros(Double vlTotalJuros) {
        this.vlTotalJuros = vlTotalJuros;
    }

    /**
     * @return the dtParcelaSer
     */
    public Date getDtParcelaSer() {
        return dtParcelaSer;
    }

    /**
     * @param dtParcelaSer the dtParcelaSer to set
     */
    public void setDtParcelaSer(Date dtParcelaSer) {
        this.dtParcelaSer = dtParcelaSer;
    }

    /**
     * @return the vlPrestacaoAmortizada
     */
    public Double getVlPrestacaoAmortizada() {
        return vlPrestacaoAmortizada;
    }

    /**
     * @param vlPrestacaoAmortizada the vlPrestacaoAmortizada to set
     */
    public void setVlPrestacaoAmortizada(Double vlPrestacaoAmortizada) {
        this.vlPrestacaoAmortizada = vlPrestacaoAmortizada;
    }

    /**
     * @return the txSituacaoCdc
     */
    public String getTxSituacaoCdc() {
        return txSituacaoCdc;
    }

    /**
     * @param txSituacaoCdc the txSituacaoCdc to set
     */
    public void setTxSituacaoCdc(String txSituacaoCdc) {
        this.txSituacaoCdc = txSituacaoCdc;
    }

    /**
     * @return the chaveFunci
     */
    public String getChaveFunci() {
        return chaveFunci;
    }

    /**
     * @param chaveFunci the chaveFunci to set
     */
    public void setChaveFunci(String chaveFunci) {
        this.chaveFunci = chaveFunci;
    }

    /**
     * @return the hor_inc_func
     */
    public LocalDateTime getHor_inc_func() {
        return hor_inc_func;
    }

    /**
     * @param hor_inc_func the hor_inc_func to set
     */
    public void setHor_inc_func(LocalDateTime hor_inc_func) {
        this.hor_inc_func = hor_inc_func;
    }
    
}    



