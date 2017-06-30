package br.com.crescer.musicio.repository;

import br.com.crescer.musicio.entity.Comentario;
import java.math.BigDecimal;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author leonardo.alves
 */
public interface ComentarioRepository extends CrudRepository<Comentario, BigDecimal> {
    
}
