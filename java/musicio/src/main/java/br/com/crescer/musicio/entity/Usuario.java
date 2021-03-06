
package br.com.crescer.musicio.entity;

import br.com.crescer.musicio.model.PostUsuarioModel;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.context.annotation.Lazy;

/** 
 * @author leonardo.alves
 **/
@Entity
@Table(name = "USUARIO")
@XmlRootElement
public class Usuario extends UsuarioBase implements Serializable {

    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_USUARIO")
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_USUARIO")
    @SequenceGenerator(name = "SEQ_USUARIO", sequenceName = "SEQ_USUARIO", allocationSize=1)
    private BigDecimal idUsuario;
    //---------------------------
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NOME")
    private String nome;
    //---------------------------
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "EMAIL")
    private String email;
    //---------------------------
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "SENHA")
    private String senha;
    //---------------------------
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEXO")
    
    private Character sexo;
    //---------------------------
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA_NASCIMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataNascimento;
    //---------------------------
    @JsonManagedReference(value="usuario-post")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<Post> postList;
    //---------------------------
    @JsonManagedReference(value ="usuario-usuarioamigo")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "amigo")
    
    private List<Usuarioamigo> amigos;
    /* //---------------------------
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioIdUsuario")
    private List<Usuarioamigo> usuarioamigoList1;
    //--------------------------- */
    @JsonManagedReference(value="usuario-comentario")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<Comentario> comentarioList;
    //---------------------------
    @JsonManagedReference(value = "usuario-curtida")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<Curtida> curtidaList;
    //---------------------------   
    @JsonManagedReference(value = "usuario-permissoes")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<Usuariopermissao> permissoes;
    
    public Usuario() {
        
    }

    public Usuario(BigDecimal idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(BigDecimal idUsuario, String nome, String email, String senha, Character sexo, Date dataNascimento) {
       super(idUsuario, nome, email, sexo, dataNascimento);
       this.senha = senha;
    }    

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public List<Usuarioamigo> getUsuarioamigoList() {
        return amigos;
    }

    public void setUsuarioamigoList(List<Usuarioamigo> usuarioamigoList) {
        this.amigos = usuarioamigoList;
    }
    /*
    public List<Usuarioamigo> getUsuarioamigoList1() {
        return usuarioamigoList1;
    }

    public void setUsuarioamigoList1(List<Usuarioamigo> usuarioamigoList1) {
        this.usuarioamigoList1 = usuarioamigoList1;
    } */

    public List<Comentario> getComentarioList() {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getIdUsuario() != null ? getIdUsuario().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.getIdUsuario() == null && other.getIdUsuario() != null) || (this.getIdUsuario() != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.musicio.entity.Usuario[ idUsuario=" + getIdUsuario() + " ]";
    }

    public List<Usuariopermissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<Usuariopermissao> permissoes) {
        this.permissoes = permissoes;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Character getSexo() {
        return sexo;
    }

    @Override
    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    @Override
    public Date getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public BigDecimal getIdUsuario() {
        return idUsuario;
    }

    @Override
    public void setIdUsuario(BigDecimal idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public PostUsuarioModel converterParaUsuarioModel () {
        return new PostUsuarioModel(this.idUsuario, this.nome, this.email, this.sexo, this.dataNascimento);
    }

}
