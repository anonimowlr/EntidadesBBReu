/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centralcapturasjudicial.model.entity.cdc;

import centralcapturasjudicial.model.entity.AbstractEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author f6323539
 */
@Entity
@Table(name="tab_tipo_cpnt_cdc"
    ,catalog="calculobbreu"
)

public class TipoComponenteCdc implements java.io.Serializable , AbstractEntity {
    
    @Id
    @Column(name="id", unique=true, nullable=false, length=3)
    private Long id;
    @Column(name="nm_cpnt")
    private String nome;

    public TipoComponenteCdc() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }  
}
