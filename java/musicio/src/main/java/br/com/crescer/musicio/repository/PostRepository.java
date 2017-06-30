package br.com.crescer.musicio.repository;

import br.com.crescer.musicio.entity.Post;
import java.math.BigDecimal;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author leonardo.alves
 */
public interface PostRepository extends PagingAndSortingRepository<Post, BigDecimal> {    
    
    //Page<Post> findByUsuarioIdUsuario();
    
}
