package br.com.crescer.musicio.repository;

import br.com.crescer.musicio.entity.Post;
import br.com.crescer.musicio.entity.Usuario;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author leonardo.alves
 */
public interface PostRepository extends PagingAndSortingRepository<Post, BigDecimal> {    
    @Query("select p from Post p where p.usuario in ?1 order by p.dataPost desc")
    Page<Post> pegarPostsAmigosUsuario(Collection<Usuario> usuario, Pageable pageable);
    
    @Query("select p from Post p where p.usuario = ?1 order by p.dataPost desc")
    List<Post> pegarPostsDoAmigo(Usuario amigo);
    
    Post findByIdPost(BigDecimal idPost);
}
