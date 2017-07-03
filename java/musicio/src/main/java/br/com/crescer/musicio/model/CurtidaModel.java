
package br.com.crescer.musicio.model;

import java.math.BigDecimal;

/** 
 * @author leonardo.alves
 **/
public class CurtidaModel {
    
    private String nomeUsuario;
    private BigDecimal postIdPost;
    private BigDecimal idUsuario;
    
    public CurtidaModel (String nomeUsuario, BigDecimal postIdPost, BigDecimal idUsuario) {
        this.nomeUsuario = nomeUsuario;
        this.postIdPost = postIdPost;
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public BigDecimal getPostIdPost() {
        return postIdPost;
    }

    public void setPostIdPost(BigDecimal postIdPost) {
        this.postIdPost = postIdPost;
    }

    public BigDecimal getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(BigDecimal idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    

}
