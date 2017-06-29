package br.com.crescer.aula7.repository;

import br.com.crescer.aula7.entity.Funcionario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author leonardo.alves
 */
public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {
    
}
