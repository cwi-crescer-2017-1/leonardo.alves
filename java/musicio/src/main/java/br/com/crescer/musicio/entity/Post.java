
package br.com.crescer.musicio.entity;

import br.com.crescer.musicio.model.ComentarioModel;
import br.com.crescer.musicio.model.PostModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/** 
 * @author leonardo.alves
 **/
@Entity
@Table(name = "POST")
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_POST")
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_POST")
    @SequenceGenerator(name = "SEQ_POST", sequenceName = "SEQ_POST", allocationSize=1)
    private BigDecimal idPost;
    //------------------------
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1023)
    @Column(name = "TEXTO")
    private String texto;
    //------------------------
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA_POST")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPost;
    //------------------------
    @JoinColumn(name = "USUARIO_ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @JsonBackReference("usuario-post")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuario;
    //------------------------
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postIdPost")
    private List<Comentario> comentarioList;
    //------------------------
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postIdPost")
    private List<Curtida> curtidaList;

    public Post() {
    }

    public Post(BigDecimal idPost) {
        this.idPost = idPost;
    }

    public Post(BigDecimal idPost, String texto, Date dataPost) {
        this.idPost = idPost;
        this.texto = texto;
        this.dataPost = dataPost;
    }

    public BigDecimal getIdPost() {
        return idPost;
    }

    public void setIdPost(BigDecimal idPost) {
        this.idPost = idPost;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getDataPost() {
        return dataPost;
    }

    public void setDataPost(Date dataPost) {
        this.dataPost = dataPost;
    }

    public Usuario getUsuario() {   
        return this.usuario;
    }    
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public List<Comentario> gusuario() {
        return comentarioList;
    }

    public void setComentarioList(List<Comentario> comentarioList) {
        this.comentarioList = comentarioList;
    }

    public List<Curtida> getCurtidaList() {
        return curtidaList;
    }

    public void setCurtidaList(List<Curtida> curtidaList) {
        this.curtidaList = curtidaList;
    }
    
    public PostModel converterParaPostModel() {
        
        List<ComentarioModel> comentarioDto = new ArrayList<>();  
        
        for(Comentario c : comentarioList) {
            comentarioDto.add(c.converterParaComentarioModel());
        }
       
        return new PostModel(
                this.idPost, 
                this.texto, 
                this.dataPost, 
                comentarioDto,
                this.curtidaList, 
                this.usuario);
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPost != null ? idPost.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Post)) {
            return false;
        }
        Post other = (Post) object;
        return !((this.idPost == null && other.idPost != null) || 
                (this.idPost != null && !this.idPost.equals(other.idPost)));
    }

    @Override
    public String toString() {
        return "br.com.crescer.musicio.entity.Post[ idPost=" + idPost + " ]";
    }

}
