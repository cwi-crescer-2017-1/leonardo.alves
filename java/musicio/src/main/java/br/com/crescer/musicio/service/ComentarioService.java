
package br.com.crescer.musicio.service;

import br.com.crescer.musicio.entity.Comentario;
import br.com.crescer.musicio.model.ComentarioModel;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author leonardo.alves
 */
public interface ComentarioService {
    
    Comentario comentar(Comentario comentario);
    
    
}
