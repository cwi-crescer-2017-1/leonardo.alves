
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

/** 
 * @author leonardo.alves
 **/
@Entity
@Table(name = "CURTIDA")
public class Curtida implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CURTIDA")
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CURTIDA")
    @SequenceGenerator(name = "SEQ_CURTIDA", sequenceName = "SEQ_CURTIDA", allocationSize=1)
    private BigDecimal idCurtida;
    //------------------------------
    @JoinColumn(name = "POST_ID_POST", referencedColumnName = "ID_POST")
    @JsonBackReference
    @ManyToOne(optional = false)
    private Post postIdPost;
    //------------------------------
    @JoinColumn(name = "USUARIO_ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @JsonBackReference
    @ManyToOne(optional = false)
    private Usuario usuarioIdUsuario;

    public Curtida() {
    }

    public Curtida(BigDecimal idCurtida) {
        this.idCurtida = idCurtida;
    }

    public BigDecimal getIdCurtida() {
        return idCurtida;
    }

    public void setIdCurtida(BigDecimal idCurtida) {
        this.idCurtida = idCurtida;
    }

    public Post getPostIdPost() {
        return postIdPost;
    }

    public void setPostIdPost(Post postIdPost) {
        this.postIdPost = postIdPost;
    }

    public Usuario getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(Usuario usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCurtida != null ? idCurtida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curtida)) {
            return false;
        }
        Curtida other = (Curtida) object;
        if ((this.idCurtida == null && other.idCurtida != null) || (this.idCurtida != null && !this.idCurtida.equals(other.idCurtida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.musicio.entity.Curtida[ idCurtida=" + idCurtida + " ]";
    }

}
