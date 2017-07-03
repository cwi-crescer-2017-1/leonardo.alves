
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
public final class PostModel extends PostAbstrato {
    private BigDecimal idPost;
    private String texto;
    private Date dataPost;
    private List<ComentarioModel> comentarioList;
    private List<CurtidaModel> curtidaList;
    private PostUsuarioModel usuario;
    
    
    public PostModel(BigDecimal idPost, 
            String texto, 
            Date dataPost, 
            List<ComentarioModel> comentarios, 
            List<CurtidaModel> curtidas, 
            Usuario usuario){
        super(idPost, texto, dataPost, comentarios, curtidas); 
        
        PostUsuarioModel umodel = usuario.converterParaUsuarioModel();       
        this.setUsuario(umodel);
      
    }  

    public PostUsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(PostUsuarioModel usuario) {
        this.usuario = usuario;
    }   
    
}
