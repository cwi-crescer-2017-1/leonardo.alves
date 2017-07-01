
package br.com.crescer.musicio.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.springframework.context.annotation.Lazy;

/** 
 * @author leonardo.alves
 **/
@Entity
@Table(name = "USUARIOPERMISSAO")
public class Usuariopermissao implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_USUARIO_PERMISSAO")
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_USUARIOPERMISSAO")
    @SequenceGenerator(name = "SEQ_USUARIOPERMISSAO", sequenceName = "SEQ_USUARIOPERMISSAO", allocationSize=1)
    private BigDecimal idUsuarioPermissao;
    //------------------------------------
    @JoinColumn(name = "PERMISSAO_ID_PERMISSAO", referencedColumnName = "ID_PERMISSAO")
    @ManyToOne(optional = false)
    @JsonBackReference
    private Permissao permissao;
    //------------------------------------
    @JoinColumn(name = "USUARIO_ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    @JsonBackReference(value = "usuario-permissoes")
    private Usuario usuario;

    public Usuariopermissao() {
    }
    
    public Usuariopermissao(Usuario usuario, Permissao permissao){
        this.usuario = usuario;
        this.permissao = permissao;
    }

    public Usuariopermissao(BigDecimal idUsuarioPermissao) {
        this.idUsuarioPermissao = idUsuarioPermissao;
    }

    public BigDecimal getIdUsuarioPermissao() {
        return idUsuarioPermissao;
    }

    public void setIdUsuarioPermissao(BigDecimal idUsuarioPermissao) {
        this.idUsuarioPermissao = idUsuarioPermissao;
    }

    public Permissao getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuarioPermissao != null ? idUsuarioPermissao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuariopermissao)) {
            return false;
        }
        Usuariopermissao other = (Usuariopermissao) object;
        return !((this.idUsuarioPermissao == null && other.idUsuarioPermissao != null) ||
                (this.idUsuarioPermissao != null && !this.idUsuarioPermissao.equals(other.idUsuarioPermissao)));
    }

    @Override
    public String toString() {
        return "br.com.crescer.musicio.entity.Usuariopermissao[ idUsuarioPermissao=" + idUsuarioPermissao + " ]";
    }

}
