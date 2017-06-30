
package br.com.crescer.musicio.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/** 
 * @author leonardo.alves
 **/
@Entity
@Table(name = "PERMISSAO")
public class Permissao implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERMISSAO")
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_PERMISSAO")
    @SequenceGenerator(name = "SEQ_PERMISSAO", sequenceName = "SEQ_PERMISSAO", allocationSize=1)
    private BigDecimal idPermissao;
    //-----------------------------
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 63)
    @Column(name = "PERMISSAO")
    private String permissao;
    //-----------------------------
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "permissao")
    private List<Usuariopermissao> usuarios;
    //-----------------------------
    
    public Permissao() {
    }

    public Permissao(BigDecimal idPermissao) {
        this.idPermissao = idPermissao;
    }

    public Permissao(BigDecimal idPermissao, String permissao) {
        this.idPermissao = idPermissao;
        this.permissao = permissao;
    }

    public BigDecimal getIdPermissao() {
        return idPermissao;
    }

    public void setIdPermissao(BigDecimal idPermissao) {
        this.idPermissao = idPermissao;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }

    public List<Usuariopermissao> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuariopermissao> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPermissao != null ? idPermissao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permissao)) {
            return false;
        }
        Permissao other = (Permissao) object;
        if ((this.idPermissao == null && other.idPermissao != null) || (this.idPermissao != null && !this.idPermissao.equals(other.idPermissao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.musicio.entity.Permissao[ idPermissao=" + idPermissao + " ]";
    }

}
