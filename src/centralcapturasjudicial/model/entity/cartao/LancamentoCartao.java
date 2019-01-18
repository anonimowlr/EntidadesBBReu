/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centralcapturasjudicial.model.entity.cartao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author f8940147
 */
@Entity
@Table(name="tab_lancamento")
public class LancamentoCartao implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dataTransacao;    
    private int nrCartao;
    private String descricao;
    private double valor;
    private String moeda;    
//    @JoinColumns({
//        @JoinColumn(name="nr_mes", referencedColumnName = "nrMes"),
//        @JoinColumn(name="ano", referencedColumnName = "ano")
//    })
    @JoinColumn(name="mesCartao")
    @ManyToOne//(cascade = CascadeType.ALL)
    private MesCartao mesCartao;

    public LancamentoCartao() {
    }
            
    public HashMap<Integer,String> getValues(){
        
        HashMap<Integer,String> values = new HashMap<>();
        values.put(1, Integer.toString(getMesCartao().getExtrato().getCartao().getOperacao()));
        values.put(2, getMesCartao().getDataVencimento().replace(".", "/"));
        if(Double.toString(getMesCartao().getTxJuros()) != null) {
            values.put(3, String.format("%.2f", (getMesCartao().getTxJuros())).replace(".", ","));
        }
        else {
            values.put(3, ""); 
        }
        values.put(4, getDataTransacao().replace(".", "/"));
        values.put(5, Integer.toString(getNrCartao()));
        values.put(6, getDescricao());
        values.put(7, String.format("%.2f", (getValor())).replace(".", ","));        
        values.put(8, getMoeda());
        //values.put(9, String.format("%.2f", 1.5));
        //values.put(6, getMes().getDataFaturamento());
                        
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
     * @return the dataTransacao
     */
    public String getDataTransacao() {
        return dataTransacao;
    }

    /**
     * @param dataTransacao the dataTransacao to set
     */
    public void setDataTransacao(String dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    /**
     * @return the nrCartao
     */
    public int getNrCartao() {
        return nrCartao;
    }

    /**
     * @param nrCartao the nrCartao to set
     */
    public void setNrCartao(int nrCartao) {
        this.nrCartao = nrCartao;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the moeda
     */
    public String getMoeda() {
        return moeda;
    }

    /**
     * @param moeda the moeda to set
     */
    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    /**
     * @return the mesCartao
     */
    public MesCartao getMesCartao() {
        return mesCartao;
    }

    /**
     * @param mesCartao the mesCartao to set
     */
    public void setMesCartao(MesCartao mesCartao) {
        this.mesCartao = mesCartao;
    }
    
    
    
}
