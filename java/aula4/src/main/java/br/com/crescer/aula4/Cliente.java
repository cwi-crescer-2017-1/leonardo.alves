
package br.com.crescer.aula4;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author leonardo.alves
 */

@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable {
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CLIENTE")
    private long id;
    
    @Basic(optional = false)
    @Column(name = "NM_CLIENTE")
    private String nome;
  
    public long getId() {
        return id;
    }
   
    public void setId(long id) {
        this.id = id;
    }
   
    public String getNome() {
        return nome;
    }
  
    public void setNome(String nome) {
        this.nome = nome;
    }    
    
}
