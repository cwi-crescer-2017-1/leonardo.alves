
package br.com.crescer.musicio.service;

import br.com.crescer.musicio.entity.Curtida;
import br.com.crescer.musicio.entity.Post;
import br.com.crescer.musicio.entity.Usuario;
import br.com.crescer.musicio.exception.InvalidInformationsException;
import br.com.crescer.musicio.model.CurtidaModel;
import br.com.crescer.musicio.repository.CurtidaRepository;
import br.com.crescer.musicio.repository.PostRepository;
import br.com.crescer.musicio.repository.UsuarioRepository;
import br.com.crescer.musicio.security.SessionAttr;
import java.math.BigDecimal;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import static org.springframework.http.RequestEntity.post;
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
    public CurtidaModel curtirPost(Post post) throws InvalidInformationsException {
        Curtida curtida = new Curtida();        
        curtida.setPostIdPost(postRepo.findByIdPost(post.getIdPost()));
        curtida.setUsuarioIdUsuario(getUsuario());
        
        try {
            repositorio.save(curtida);
        } catch (DataIntegrityViolationException e) {            
            throw new InvalidInformationsException("Você já curtiu isso!");
        }
        
        return curtida.converterParaCurtidaModel();
    }

    @Override
    public void descurtirPost(BigDecimal idPost) throws NotFoundException {
        Post post = postRepo.findByIdPost(idPost);
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
