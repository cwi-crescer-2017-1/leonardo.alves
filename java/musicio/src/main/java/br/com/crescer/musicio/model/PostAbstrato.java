
package br.com.crescer.musicio.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/** 
 * @author leonardo.alves
 **/
public abstract class PostAbstrato {
    
    private BigDecimal idPost;
    private String texto;
    private Date dataPost;
    private List<ComentarioModel> comentarioList;
    private List<CurtidaModel> curtidaList;
    
    public PostAbstrato(BigDecimal idPost, String texto, 
            Date dataPost, List<ComentarioModel> comentarioList, 
            List<CurtidaModel> curtidaList) {
        this.idPost = idPost;
        this.texto = texto;
        this.dataPost= dataPost;
        this.comentarioList = comentarioList;
        this.curtidaList = curtidaList;
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

    public List<ComentarioModel> getComentarioList() {
        return comentarioList;
    }

    public void setComentarioList(List<ComentarioModel> comentarioList) {
        this.comentarioList = comentarioList;
    }

    public List<CurtidaModel> getCurtidaList() {
        return curtidaList;
    }

    public void setCurtidaList(List<CurtidaModel> curtidaList) {
        this.curtidaList = curtidaList;
    }

}
