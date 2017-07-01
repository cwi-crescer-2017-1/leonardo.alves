
package br.com.crescer.musicio.model;

import br.com.crescer.musicio.entity.Comentario;
import br.com.crescer.musicio.entity.Curtida;
import br.com.crescer.musicio.entity.Usuario;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/** 
 * @author leonardo.alves
 **/
public final class PostModel {
    private BigDecimal idPost;
    private String texto;
    private Date dataPost;
    private List<Comentario> comentarioList;
    private List<Curtida> curtidaList;
    private PostUsuarioModel usuario;
    
    
    public PostModel(BigDecimal idPost, 
            String texto, 
            Date dataPost, 
            List<Comentario> comentarios, 
            List<Curtida> curtidas, 
            Usuario usuario){
        
       this.setIdPost(idPost);
       this.setTexto(texto);
       this.setDataPost(dataPost);
       this.setCurtidaList(curtidas);
       this.setComentarioList(comentarios);
      
       PostUsuarioModel umodel = new PostUsuarioModel(
               usuario.getIdUsuario(), 
               usuario.getNome(), 
               usuario.getEmail());
       
        this.setUsuario(umodel);
      
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

    public PostUsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(PostUsuarioModel usuario) {
        this.usuario = usuario;
    }
    
    
}
