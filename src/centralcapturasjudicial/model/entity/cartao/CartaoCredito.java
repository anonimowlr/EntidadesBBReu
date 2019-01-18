/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centralcapturasjudicial.model.entity.cartao;

import centralcapturasjudicial.model.entity.cartao.ExtratoCartao;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author f8940147
 */
@Entity
@Table(name="tab_cartao_credito")
public class CartaoCredito implements Serializable {
    
    @Id
    @Column(name="id_cartao")
    private int operacao;
    @Column(name="produtoModalidade")
    private String modalidade;
    @OneToMany(mappedBy = "cartao", cascade = CascadeType.ALL)
    
    private List<ExtratoCartao> listExtratoCartao;
    
    /**
     * @return the operacao
     */
    public int getOperacao() {
        return operacao;
    }

    /**
     * @param operacao the operacao to set
     */
    public void setOperacao(int operacao) {
        this.operacao = operacao;
    }

    /**
     * @return the Modalidade
     */
    public String getModalidade() {
        return modalidade;
    }

    /**
     * @param Modalidade the Modalidade to set
     */
    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    /**
     * @return the listExtratoCartao
     */
    public List<ExtratoCartao> getListExtratoCartao() {
        return listExtratoCartao;
    }

    /**
     * @param listExtratoCartao the listExtratoCartao to set
     */
    public void setListExtratoCartao(List<ExtratoCartao> listExtratoCartao) {
        this.listExtratoCartao = listExtratoCartao;
    }
    
    @Override
    public String toString() {
        return Integer.toString(getOperacao())+ "   " + getModalidade();
    }
}
