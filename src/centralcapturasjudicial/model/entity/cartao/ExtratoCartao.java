/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centralcapturasjudicial.model.entity.cartao;

import centralcapturasjudicial.model.entity.AbstractEntity;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name="tab_extrato_cartao")
public class ExtratoCartao implements Serializable, AbstractEntity {
    
    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@ManyToOne
    @JoinColumn(name="cartao_operacao")//é utilizado para nomearmos a coluna que possui a chave-estrangeira requerida pela associação
    
    @ManyToOne(cascade = CascadeType.ALL)
    /*
    @ManyToOne->Tem-se a classe ExtratoCartao que 
    possui um cartao.
    
    Cada CartaoCredito pode estar em nenhum ou muitos
    ExtratoCartao
    
    Após criado o relacionamento de muitos para um (@ManyToOne)
    , é possível criar o relacionamento de um para muitos 
    na tabela de CartaoCredito, dessa forma podemos ter 
    acesso a lista de ExtratoCartao que se relaciona com o 
    CartaoCredito em questão
    
    @JoinColumn, define qual coluna é responsável pela
    ligação entre os objetos.
    */
    private CartaoCredito cartao;
    @Column(name="cpf_cli")
    private String cpfCliente;
    @Column(name="nome_cli")
    private String nomeCliente;
    @Column(name="chave_func")
    private String chaveFunci;
    @Column(name="hor_inc_func")
    private LocalDateTime hor_inc_func;
    //@Transient
    @OneToMany(mappedBy = "extrato", cascade = CascadeType.ALL)
    private List<MesCartao> listMesCartao;

    public ExtratoCartao() {        
    }


    
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String[] getCabecalho(){
                        
        String[] cabecalho = {"Conta","Vencimento","Taxa %","Data Lançamento","Nr Cartão", "Descrição Lançamento","Valor Lançamento","Moeda"};
        
        return cabecalho;
    }

    /**
     * @return the cartao
     */
    public CartaoCredito getCartao() {
        return cartao;
    }

    /**
     * @param cartao the cartao to set
     */
    public void setCartao(CartaoCredito cartao) {
        this.cartao = cartao;
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

    /**
     * @return the listMesCartao
     */
    public List<MesCartao> getListMesCartao() {
        return listMesCartao;
    }

    /**
     * @param listMesCartao the listMesCartao to set
     */
    public void setListMesCartao(List<MesCartao> listMesCartao) {
        this.listMesCartao = listMesCartao;
    }
    
    
}
