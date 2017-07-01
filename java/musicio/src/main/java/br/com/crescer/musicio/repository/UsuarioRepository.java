package br.com.crescer.musicio.repository;

import br.com.crescer.musicio.entity.Usuario;
import java.math.BigDecimal;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 *
 * @author leonardo.alves
 */
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, BigDecimal> {
    
    
    
    Page<Usuario> findAll ();
    Usuario findOneByIdUsuario(BigDecimal idUsuario);
    Usuario findOneByEmail (String email);
    
}
