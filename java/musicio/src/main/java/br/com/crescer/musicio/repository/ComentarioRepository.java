package br.com.crescer.musicio.repository;

import br.com.crescer.musicio.entity.Comentario;
import br.com.crescer.musicio.entity.Post;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author leonardo.alves
 */
public interface ComentarioRepository extends CrudRepository<Comentario, BigDecimal> {
    
    List<Comentario> findByPostIdPost (Post postIdPost);
    
}
