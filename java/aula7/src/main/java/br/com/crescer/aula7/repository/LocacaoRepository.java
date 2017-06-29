package br.com.crescer.aula7.repository;

import br.com.crescer.aula7.entity.Locacao;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author leonardo.alves
 */
public interface LocacaoRepository extends CrudRepository<Locacao, Long> {
    
}
