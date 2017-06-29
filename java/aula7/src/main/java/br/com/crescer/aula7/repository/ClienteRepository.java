package br.com.crescer.aula7.repository;

import br.com.crescer.aula7.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

/** 
 * @author leonardo.alves
 **/
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
