
package br.com.crescer.musicio.model;

import java.math.BigDecimal;

/** 
 * @author leonardo.alves
 **/
public final class ComentarioModel {
    
    private String comentario;    
    private BigDecimal idComentario;
    private PostUsuarioModel usuario;
    
    public ComentarioModel (BigDecimal idComentario, String comentario, PostUsuarioModel usuario) {
        
        this.idComentario = idComentario;
        this.comentario = comentario;
        this.usuario = usuario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    public PostUsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(PostUsuarioModel usuario) {
        this.usuario = usuario;
    }

    public BigDecimal getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(BigDecimal idComentario) {
        this.idComentario = idComentario;
    }
    
    
    
}
