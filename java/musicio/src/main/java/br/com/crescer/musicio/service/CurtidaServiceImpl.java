
package br.com.crescer.musicio.service;

import br.com.crescer.musicio.entity.Curtida;
import br.com.crescer.musicio.entity.Post;
import br.com.crescer.musicio.entity.Usuario;
import br.com.crescer.musicio.model.CurtidaModel;
import br.com.crescer.musicio.repository.CurtidaRepository;
import br.com.crescer.musicio.repository.PostRepository;
import br.com.crescer.musicio.repository.UsuarioRepository;
import br.com.crescer.musicio.security.SessionAttr;
import java.math.BigDecimal;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** 
 * @author leonardo.alves
 **/

@Service
public class CurtidaServiceImpl implements CurtidaService {
    
    @Autowired
    CurtidaRepository repositorio;
    
    @Autowired
    UsuarioRepository usuarioRepo;
    
    @Autowired
    PostRepository postRepo;
    
    @Autowired
    SessionAttr sessionAttributes;   
    

    @Override
    public CurtidaModel curtirPost(Post post) {
        Curtida curtida = new Curtida();        
        curtida.setPostIdPost(postRepo.findByIdPost(post.getIdPost()));
        curtida.setUsuarioIdUsuario(getUsuario());
        repositorio.save(curtida);
        
        return curtida.converterParaCurtidaModel();
    }

    @Override
    public void descurtirPost(Post post) throws NotFoundException {
        Curtida curtida =repositorio.findCurtida(post, getUsuario());
        
        if(curtida == null)
            throw new NotFoundException("Você ainda não curtiu esse post");
        
        repositorio.delete(curtida);        
    }
    
    
    private Usuario getUsuario() {
        sessionAttributes.init();
        return usuarioRepo.findOneByEmail(sessionAttributes.getUsername());
    }

}
