
package br.com.crescer.musicio.model;

import br.com.crescer.musicio.entity.UsuarioBase;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/** 
 * @author leonardo.alves
 **/
public final class AmigoComPostModel extends UsuarioBase {

    private List<PostSemUsuarioModel> posts;
    
    public AmigoComPostModel(BigDecimal idUsuario, String nome, String email, Character sexo, Date dataNascimento, List<PostSemUsuarioModel> posts) {
        super(idUsuario, nome, email, sexo, dataNascimento);
        this.posts = posts;        
    }

    public List<PostSemUsuarioModel> getPosts() {
        return posts;
    }

    public void setPosts(List<PostSemUsuarioModel> posts) {
        this.posts = posts;
    }
    
    
    
}
