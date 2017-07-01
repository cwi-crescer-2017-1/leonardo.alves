
package br.com.crescer.musicio.service;

import br.com.crescer.musicio.entity.Post;
import br.com.crescer.musicio.entity.Usuario;
import br.com.crescer.musicio.entity.Usuarioamigo;
import br.com.crescer.musicio.model.PostModel;
import br.com.crescer.musicio.repository.PostRepository;
import br.com.crescer.musicio.repository.UsuarioRepository;
import br.com.crescer.musicio.repository.UsuarioamigoRepository;
import br.com.crescer.musicio.security.SessionAttr;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/** 
 * @author leonardo.alves
 **/
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository repositorio;
    
    @Autowired
    UsuarioRepository usuarioRepo;
    
    @Autowired
    UsuarioamigoRepository amigosRepo;   
    
    @Autowired
    SessionAttr sessionAttributes;
    
    @Override
    public Post publicar(Post post) {
        sessionAttributes.init();
        Usuario usuario = getUsuario();
        
        post.setUsuario(usuario);        
        post.setDataPost(new Date());
        
        return repositorio.save(post);        
    }

    @Override
    public Page<PostModel> pegarPosts(Pageable pageable) {
        Usuario usuario;
        List<Usuario> todosEmComum;
        Page<Post> posts;
        Page<PostModel> postsDto;
        
        usuario = getUsuario(); 
        
        {
            todosEmComum = amigosRepo.getAmigos(usuario);            
            todosEmComum.add(usuario);  
        }
        
        posts = repositorio.pegarPostsAmigosUsuario(todosEmComum, pageable);        
        postsDto = posts.map((p) -> p.converterParaPostModel());
        
        return postsDto;
    }
    
    private Usuario getUsuario () {
        sessionAttributes.init();
        return usuarioRepo.findOneByEmail(sessionAttributes.getUsername());
    }

}
