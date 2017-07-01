
package br.com.crescer.musicio.service;

import br.com.crescer.musicio.entity.Comentario;
import br.com.crescer.musicio.entity.Post;
import br.com.crescer.musicio.entity.Usuario;
import br.com.crescer.musicio.model.ComentarioModel;
import br.com.crescer.musicio.model.PostUsuarioModel;
import br.com.crescer.musicio.repository.ComentarioRepository;
import br.com.crescer.musicio.repository.PostRepository;
import br.com.crescer.musicio.repository.UsuarioRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioServiceImpl implements ComentarioService {

    @Autowired
    ComentarioRepository repositorio;
    
    @Autowired
    UsuarioRepository usuarioRepo;
    
    @Autowired
    PostRepository postRepo;
    
    @Override
    public Comentario comentar(Comentario comentario) {
        String emailUsuario = comentario.getUsuario().getEmail();        
        Usuario usuario = usuarioRepo.findOneByEmail(emailUsuario);
        Post post = postRepo.findByIdPost(comentario.getPostIdPost().getIdPost());
        
        comentario.setUsuarioIdUsuario(usuario);
        comentario.setPostIdPost(post);
        
//        PostUsuarioModel usuarioModel = new PostUsuarioModel(usuario.getIdUsuario(),
//                usuario.getNome(), usuario.getEmail());          
        
        return repositorio.save(comentario);
    }
}
