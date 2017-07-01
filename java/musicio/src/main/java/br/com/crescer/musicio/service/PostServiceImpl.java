
package br.com.crescer.musicio.service;

import br.com.crescer.musicio.entity.Post;
import br.com.crescer.musicio.entity.Usuario;
import br.com.crescer.musicio.repository.PostRepository;
import br.com.crescer.musicio.repository.UsuarioRepository;
import br.com.crescer.musicio.security.SessionAttr;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
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
    SessionAttr sessionAttributes;
    
    @Override
    public Post publicar(Post post) {
        sessionAttributes.init();
        Usuario usuario = usuarioRepo.findOneByEmail(sessionAttributes.getUsername());
        
        post.setUsuario(usuario);        
        post.setDataPost(new Date());
        
        return repositorio.save(post);        
    }

}
