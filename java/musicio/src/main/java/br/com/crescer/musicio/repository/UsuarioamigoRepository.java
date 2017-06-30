
package br.com.crescer.musicio.repository;

import br.com.crescer.musicio.entity.Usuario;
import br.com.crescer.musicio.entity.Usuarioamigo;
import java.math.BigDecimal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
}
