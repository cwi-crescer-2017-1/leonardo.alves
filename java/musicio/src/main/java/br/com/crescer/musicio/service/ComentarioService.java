
package br.com.crescer.musicio.service;

import br.com.crescer.musicio.entity.Comentario;
import br.com.crescer.musicio.model.ComentarioModel;

/**
 *
 * @author leonardo.alves
 */
public interface ComentarioService {
    
    ComentarioModel comentar(Comentario comentario);
    
    
}
