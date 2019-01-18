/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centralcapturasjudicial.model.entity.contacorrente;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author f6323539
 */
@Entity
@Table(name="tab_mes_cc"
    ,catalog="calculobbreu"
)
public class MesConta  implements java.io.Serializable {


@Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="id", unique=true, nullable=false)
     private long id;
     @ManyToOne()
     @JoinColumns( {
     @JoinColumn(name="nr_age"), @JoinColumn(name="nr_cta")})
     private ContaCorrente contaCorrente;
     @Column(name="dt_per_lcto", length=7)
     private String dtPeriodoLancamento;
     @Temporal(TemporalType.DATE)
     @Column(name="dt_sdo_ant", length=10)
     private Date dtSaldoAnterior;
     @Column(name="vl_sdo_ant", precision=22, scale=0)
     private Double vlSaldoAnterior;     
     @Column(name="vl_lim", precision=22, scale=0)
     private Double vlLimite;
     @Temporal(TemporalType.DATE)
     @Column(name="dt_vcto", length=10)
     private Date dtVencimento;   
     @Column(name="chave_func")
     private String chaveFunci;
     @Column(name="hor_inc_func")
     private LocalDateTime hor_inc_func;
     @OneToMany(cascade = CascadeType.ALL, mappedBy = "mesConta")
     private List<LancamentoConta> listLancamentoConta = new ArrayList();

    public String getChaveFunci() {
        return chaveFunci;
    }

    public void setChaveFunci(String chaveFunci) {
        this.chaveFunci = chaveFunci;
    }

    public LocalDateTime getHor_inc_func() {
        return hor_inc_func;
    }

    public void setHor_inc_func(LocalDateTime hor_inc_func) {
        this.hor_inc_func = hor_inc_func;
    }     

    public MesConta() {
    }
	
    public MesConta(ContaCorrente tabCc) {
        this.contaCorrente = tabCc;
    }
    public MesConta(ContaCorrente tabCc, String dtPerLcto, Date dtSdoAnt, Double vlSdoAnt, Double vlLim, Date dtVcto, List tabLctoCcs) {
       this.contaCorrente = tabCc;
       this.dtPeriodoLancamento = dtPerLcto;
       this.dtSaldoAnterior = dtSdoAnt;
       this.vlSaldoAnterior = vlSdoAnt;
       this.vlLimite = vlLim;
       this.dtVencimento = dtVcto;
       this.listLancamentoConta = tabLctoCcs;
    }
   
    public long getId() {
        return this.id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the contaCorrente
     */
    public ContaCorrente getContaCorrente() {
        return contaCorrente;
    }

    /**
     * @param contaCorrente the contaCorrente to set
     */
    public void setContaCorrente(ContaCorrente contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    /**
     * @return the dtPeriodoLancamento
     */
    public String getDtPeriodoLancamento() {
        return dtPeriodoLancamento;
    }

    /**
     * @param dtPeriodoLancamento the dtPeriodoLancamento to set
     */
    public void setDtPeriodoLancamento(String dtPeriodoLancamento) {
        this.dtPeriodoLancamento = dtPeriodoLancamento;
    }

    /**
     * @return the dtSaldoAnterior
     */
    public Date getDtSaldoAnterior() {
        return dtSaldoAnterior;
    }

    /**
     * @param dtSaldoAnterior the dtSaldoAnterior to set
     */
    public void setDtSaldoAnterior(Date dtSaldoAnterior) {
        this.dtSaldoAnterior = dtSaldoAnterior;
    }

    /**
     * @return the vlSaldoAnterior
     */
    public Double getVlSaldoAnterior() {
        return vlSaldoAnterior;
    }

    /**
     * @param vlSaldoAnterior the vlSaldoAnterior to set
     */
    public void setVlSaldoAnterior(Double vlSaldoAnterior) {
        this.vlSaldoAnterior = vlSaldoAnterior;
    }

    /**
     * @return the vlLimite
     */
    public Double getVlLimite() {
        return vlLimite;
    }

    /**
     * @param vlLimite the vlLimite to set
     */
    public void setVlLimite(Double vlLimite) {
        this.vlLimite = vlLimite;
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
     * @return the listLancamentoConta
     */
    public List<LancamentoConta> getListLancamentoConta() {
        return listLancamentoConta;
    }

    /**
     * @param listLancamentoConta the listLancamentoConta to set
     */
    public void setListLancamentoConta(List<LancamentoConta> listLancamentoConta) {
        this.listLancamentoConta = listLancamentoConta;
    }
    
    


}



