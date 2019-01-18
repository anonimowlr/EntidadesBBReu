/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centralcapturasjudicial.model.entity.cdc;

/**
 *
 * @author f6323539
 */


import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

@Entity
@Table(name="tab_cpnt_pgto_cdc"
    ,catalog="calculobbreu"
)

public class ComponentePagamentoParcelaCdc implements java.io.Serializable {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name="id", unique=true, nullable=false)
     private Long id;
     @ManyToOne
     @JoinColumn(name="id_pgto")       
     private PagamentoParcelaCdc pagamentoParcelaCdc;         
     @ManyToOne
     @JoinColumn(name="cd_cpnt")
     private TipoComponenteCdc tipoComponenteCdc;
     @Column(name="vl_cpnt")
     private Double vlComponente;

    public ComponentePagamentoParcelaCdc() {
    }

    public ComponentePagamentoParcelaCdc(PagamentoParcelaCdc tabPgtoPclCdc, TipoComponenteCdc tabTipCpntCdc, Double vlCpnt) {
        this.pagamentoParcelaCdc = tabPgtoPclCdc;
        this.tipoComponenteCdc = tabTipCpntCdc;
        this.vlComponente = vlCpnt;
    }
    
    public HashMap<Integer,String> getValues(){
        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        
        HashMap<Integer,String> values = new HashMap<>();
        values.put(1, Integer.toString(getPagamentoParcelaCdc().getParcelaOperacaoCdc().getNrParcela()));
        values.put(2, df.format(getPagamentoParcelaCdc().getParcelaOperacaoCdc().getDtVencimento()));
        
        if(getPagamentoParcelaCdc().getParcelaOperacaoCdc().getDtCobranca()!= null) {
            values.put(3, df.format(getPagamentoParcelaCdc().getParcelaOperacaoCdc().getDtCobranca()));
        }
        else {
            values.put(3, ""); 
        }
        
        //values.put(3, df.format(getTabPgtoPclCdc().getTabPclOpeCdc().getDtCobr()));//ERRO AKI
        
        if(getPagamentoParcelaCdc().getParcelaOperacaoCdc().getVlJuros()!= null) {
            values.put(4, String.format("%.2f",(getPagamentoParcelaCdc().getParcelaOperacaoCdc().getVlJuros())).replace(".", ","));
        }
        else {
            values.put(4, ""); 
        }
        
        //values.put(4, String.format("%.2f",(getTabPgtoPclCdc().getTabPclOpeCdc().getVlJur())).replace(".", ","));
        values.put(5, String.format("%.2f",(getPagamentoParcelaCdc().getParcelaOperacaoCdc().getVlCapital())).replace(".", ","));
        if(getPagamentoParcelaCdc().getParcelaOperacaoCdc().getDtPagamento()!= null) {
           values.put(6, df.format(getPagamentoParcelaCdc().getParcelaOperacaoCdc().getDtPagamento())); 
        }   
        else {
           values.put(6, ""); 
        }
        values.put(7, Short.toString(getPagamentoParcelaCdc().getNrRecebimento()));
        values.put(8, df.format(getPagamentoParcelaCdc().getDtRecebimento()));
        values.put(9, getTipoComponenteCdc().getNome());
        values.put(10, String.format("%.2f", (getVlComponente())).replace(".", ",")); 
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
     * @return the pagamentoParcelaCdc
     */
    public PagamentoParcelaCdc getPagamentoParcelaCdc() {
        return pagamentoParcelaCdc;
    }

    /**
     * @param pagamentoParcelaCdc the pagamentoParcelaCdc to set
     */
    public void setPagamentoParcelaCdc(PagamentoParcelaCdc pagamentoParcelaCdc) {
        this.pagamentoParcelaCdc = pagamentoParcelaCdc;
    }

    /**
     * @return the tipoComponenteCdc
     */
    public TipoComponenteCdc getTipoComponenteCdc() {
        return tipoComponenteCdc;
    }

    /**
     * @param tipoComponenteCdc the tipoComponenteCdc to set
     */
    public void setTipoComponenteCdc(TipoComponenteCdc tipoComponenteCdc) {
        this.tipoComponenteCdc = tipoComponenteCdc;
    }

    /**
     * @return the vlComponente
     */
    public Double getVlComponente() {
        return vlComponente;
    }

    /**
     * @param vlComponente the vlComponente to set
     */
    public void setVlComponente(Double vlComponente) {
        this.vlComponente = vlComponente;
    }
}
