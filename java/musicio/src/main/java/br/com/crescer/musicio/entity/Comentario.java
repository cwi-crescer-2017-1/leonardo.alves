
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/** 
 * @author leonardo.alves
 **/
@Entity
@Table(name = "COMENTARIO")
public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_COMENTARIO")
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_COMENTARIO")
    @SequenceGenerator(name = "SEQ_COMENTARIO", sequenceName = "SEQ_COMENTARIO", allocationSize=1)
    private BigDecimal idComentario;
    //------------------ 
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1023)
    @Column(name = "COMENTARIO")
    private String comentario;
    //------------------
    @JoinColumn(name = "POST_ID_POST", referencedColumnName = "ID_POST")
    @JsonBackReference
    @ManyToOne(optional = false)
    private Post postIdPost;
    //------------------
    @JoinColumn(name = "USUARIO_ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @JsonBackReference
    @ManyToOne(optional = false)
    private Usuario usuarioIdUsuario;

    public Comentario() {
    }

    public Comentario(BigDecimal idComentario) {
        this.idComentario = idComentario;
    }

    public Comentario(BigDecimal idComentario, String comentario) {
        this.idComentario = idComentario;
        this.comentario = comentario;
    }

    public BigDecimal getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(BigDecimal idComentario) {
        this.idComentario = idComentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
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
        hash += (idComentario != null ? idComentario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentario)) {
            return false;
        }
        Comentario other = (Comentario) object;
        return !((this.idComentario == null && other.idComentario != null) ||
                (this.idComentario != null && !this.idComentario.equals(other.idComentario)));
    }

    @Override
    public String toString() {
        return "br.com.crescer.musicio.entity.Comentario[ idComentario=" + idComentario + " ]";
    }

}
