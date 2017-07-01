
package br.com.crescer.musicio.repository;

import br.com.crescer.musicio.entity.Usuario;
import br.com.crescer.musicio.entity.Usuarioamigo;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author leonardo.alves
 */
public interface UsuarioamigoRepository extends PagingAndSortingRepository<Usuarioamigo, BigDecimal> {
//    
//    Page<Usuario> findByUsuarioIdUsuario();
//    
//    Page<Usuario> findBySituacao();
    @Query("select u.amigo from Usuarioamigo u where u.usuario = ?1 ")
    List<Usuario>   getAmigos(Usuario usuario);
}
