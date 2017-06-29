package br.com.crescer.aula7.repository;

import br.com.crescer.aula7.entity.Genero;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author leonardo.alves
 */
public interface GeneroRepository extends CrudRepository<Genero, Long> {
    
}
