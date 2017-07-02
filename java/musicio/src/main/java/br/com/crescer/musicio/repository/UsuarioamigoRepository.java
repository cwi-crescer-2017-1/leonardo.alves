
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
    @Query("select u.amigo from Usuarioamigo u where u.usuario = ?1 and situacao = 'A'")
    List<Usuario>   getAmigos(Usuario usuario);
    
    @Query("select u.amigo from Usuarioamigo u where u.usuario = ?1 and situacao = 'P'")
    List<Usuario>   getSolicitacoes(Usuario usuario);
    
    @Query("select u from Usuarioamigo u where u.usuario = ?1 and u.amigo = ?2")
    Usuarioamigo getSolicitacao (Usuario usuario, Usuario amigo);
}
