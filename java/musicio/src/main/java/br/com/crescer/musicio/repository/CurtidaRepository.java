package br.com.crescer.musicio.repository;

import br.com.crescer.musicio.entity.Curtida;
import java.math.BigDecimal;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author leonardo.alves
 */
public interface CurtidaRepository extends CrudRepository<Curtida, BigDecimal> {
    
}
