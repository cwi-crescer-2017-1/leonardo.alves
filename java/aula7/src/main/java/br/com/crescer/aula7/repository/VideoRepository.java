package br.com.crescer.aula7.repository;

import br.com.crescer.aula7.entity.Video;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author leonardo.alves
 */
public interface VideoRepository extends CrudRepository<Video, Long> {
    
}
