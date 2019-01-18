/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centralcapturasjudicial.model.entity.cartao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author f8940147
 */
@Entity
@Table(name="tab_mes")
public class MesCartao implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @EmbeddedId
    private Long id;
    @JoinColumn(name="fatura")
    @ManyToOne//(cascade = CascadeType.ALL)
    private ExtratoCartao extrato;    
    private double txJuros;
    private String dataVencimento;
    private String dataFaturamento;
    private double saldoReal;
    private double saldoDolar;
    private double saldoTotal;
    //@Transient
    @OneToMany(mappedBy = "mesCartao", cascade=CascadeType.ALL)
    private List<LancamentoCartao> listLancamentoCartao;
    

    public MesCartao() {
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
     * @return the extrato
     */
    public ExtratoCartao getExtrato() {
        return extrato;
    }

    /**
     * @param extrato the extrato to set
     */
    public void setExtrato(ExtratoCartao extrato) {
        this.extrato = extrato;
    }

    /**
     * @return the txJuros
     */
    public double getTxJuros() {
        return txJuros;
    }

    /**
     * @param txJuros the txJuros to set
     */
    public void setTxJuros(double txJuros) {
        this.txJuros = txJuros;
    }

    /**
     * @return the dataVencimento
     */
    public String getDataVencimento() {
        return dataVencimento;
    }

    /**
     * @param dataVencimento the dataVencimento to set
     */
    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    /**
     * @return the dataFaturamento
     */
    public String getDataFaturamento() {
        return dataFaturamento;
    }

    /**
     * @param dataFaturamento the dataFaturamento to set
     */
    public void setDataFaturamento(String dataFaturamento) {
        this.dataFaturamento = dataFaturamento;
    }

    /**
     * @return the saldoReal
     */
    public double getSaldoReal() {
        return saldoReal;
    }

    /**
     * @param saldoReal the saldoReal to set
     */
    public void setSaldoReal(double saldoReal) {
        this.saldoReal = saldoReal;
    }

    /**
     * @return the saldoDolar
     */
    public double getSaldoDolar() {
        return saldoDolar;
    }

    /**
     * @param saldoDolar the saldoDolar to set
     */
    public void setSaldoDolar(double saldoDolar) {
        this.saldoDolar = saldoDolar;
    }

    /**
     * @return the saldoTotal
     */
    public double getSaldoTotal() {
        return saldoTotal;
    }

    /**
     * @param saldoTotal the saldoTotal to set
     */
    public void setSaldoTotal(double saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    /**
     * @return the listLancamentoCartao
     */
    public List<LancamentoCartao> getListLancamentoCartao() {
        return listLancamentoCartao;
    }

    /**
     * @param listLancamentoCartao the listLancamentoCartao to set
     */
    public void setListLancamentoCartao(List<LancamentoCartao> listLancamentoCartao) {
        this.listLancamentoCartao = listLancamentoCartao;
    }

      
    
    
}
