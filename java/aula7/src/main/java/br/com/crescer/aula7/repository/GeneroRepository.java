package br.com.crescer.aula7.repository;

import br.com.crescer.aula7.entity.GeneroEntity;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author leonardo.alves
 */
public interface GeneroRepository extends CrudRepository<GeneroEntity, Long> {
    
}
