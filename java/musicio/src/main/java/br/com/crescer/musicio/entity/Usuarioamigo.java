
package br.com.crescer.musicio.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

/** 
 * @author leonardo.alves
 **/
@Entity
@Table(name = "USUARIOAMIGO")
public class Usuarioamigo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_USUARIO_AMIGO")
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_USUARIOAMIGO")
    @SequenceGenerator(name = "SEQ_USUARIOAMIGO", sequenceName = "SEQ_USUARIOAMIGO", allocationSize=1)
    private BigDecimal idUsuarioAmigo;
    //---------------------------------
    @Basic(optional = false)
    @NotNull
    @Column(name = "SITUACAO")
    private Character situacao;
    //---------------------------------
    @JoinColumn(name = "AMIGO_ID_USUARIO", referencedColumnName = "ID_USUARIO")
    
    @ManyToOne(optional = false)
    @JsonBackReference("usuario-usuarioamigo")
    private Usuario amigo;
    //---------------------------------    
    @JoinColumn(name = "USUARIO_ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @JsonIgnore
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Usuarioamigo() {
    }

    public Usuarioamigo(BigDecimal idUsuarioAmigo) {
        this.idUsuarioAmigo = idUsuarioAmigo;
    }

    public Usuarioamigo(BigDecimal idUsuarioAmigo, Character situacao) {
        this.idUsuarioAmigo = idUsuarioAmigo;
        this.situacao = situacao;
    }

    public BigDecimal getIdUsuarioAmigo() {
        return idUsuarioAmigo;
    }

    public void setIdUsuarioAmigo(BigDecimal idUsuarioAmigo) {
        this.idUsuarioAmigo = idUsuarioAmigo;
    }

    public Character getSituacao() {
        return situacao;
    }

    public void setSituacao(Character situacao) {
        this.situacao = situacao;
    }

    public Usuario getAmigo() {
        return amigo;
    }

    public void setAmigo(Usuario amigo) {
        this.amigo = amigo;
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
        hash += (idUsuarioAmigo != null ? idUsuarioAmigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof Usuarioamigo)) {
            return false;
        }
        Usuarioamigo other = (Usuarioamigo) object;
        return !((this.idUsuarioAmigo == null && other.idUsuarioAmigo != null) ||
                (this.idUsuarioAmigo != null && !this.idUsuarioAmigo.equals(other.idUsuarioAmigo)));
    }

    @Override
    public String toString() {
        return "br.com.crescer.musicio.entity.Usuarioamigo[ idUsuarioAmigo=" + idUsuarioAmigo + " ]";
    }

}
