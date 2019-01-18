/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centralcapturasjudicial.model.entity.contacorrente;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author f6323539
 */
@Entity
@Table(name="tab_cc"
    ,catalog="calculobbreu"
)

public class ContaCorrente  implements java.io.Serializable {
//    
    @EmbeddedId    
    private IdConta idConta;
    @Column(name="cpf_cli")
    private String cpfCliente;
    @Column(name="nome_cli")
    private String nomeCliente;
    @Temporal(TemporalType.DATE)
    @Column(name="dt_abtr", length=10)
    private Date dtAbertura;
              
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contaCorrente")
    private List<MesConta> listMesConta = new ArrayList();
     
     
    public ContaCorrente() {
    }
    
    public String[] getCabecalho(int opcao){
        
        if(opcao == 1) {
            String[] cabecalho = {"Data","Nr Histórico","Txt Histórico"," Documento "," Valor ","D/C","Banco","Origem","Lote","Saldo"};
            return cabecalho;
        }
        else {
            String[] cabecalho = {"Data","Nr Histórico","Txt Histórico"," Documento "," Valor ","Saldo"};
            return cabecalho;
        }
    }

    /**
     * @return the idConta
     */
    public IdConta getIdConta() {
        return idConta;
    }

    /**
     * @param idConta the idConta to set
     */
    public void setIdConta(IdConta idConta) {
        this.idConta = idConta;
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
     * @return the dtAbertura
     */
    public Date getDtAbertura() {
        return dtAbertura;
    }

    /**
     * @param dtAbertura the dtAbertura to set
     */
    public void setDtAbertura(Date dtAbertura) {
        this.dtAbertura = dtAbertura;
    }

    /**
     * @return the listMesConta
     */
    public List<MesConta> getListMesConta() {
        return listMesConta;
    }

    /**
     * @param listMesConta the listMesConta to set
     */
    public void setListMesConta(List<MesConta> listMesConta) {
        this.listMesConta = listMesConta;
    }
    
}



