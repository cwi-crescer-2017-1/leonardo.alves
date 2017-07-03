package br.com.crescer.musicio.repository;

import br.com.crescer.musicio.entity.Curtida;
import br.com.crescer.musicio.entity.Post;
import br.com.crescer.musicio.entity.Usuario;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author leonardo.alves
 */
public interface CurtidaRepository extends CrudRepository<Curtida, BigDecimal> {
    
    List<Curtida> findByPostIdPost(Post postIdPost);
    
    
    @Query("select c from Curtida c where c.postIdPost = ?1 and c.usuario = ?2")
    Curtida findCurtida(Post postidpost, Usuario usuario);
}
