
package br.com.crescer.musicio.model;

import br.com.crescer.musicio.entity.Curtida;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/** 
 * @author leonardo.alves
 **/
public class PostSemUsuarioModel extends PostAbstrato{
    
    public PostSemUsuarioModel(BigDecimal idPost, 
            String texto, Date dataPost, 
            List<ComentarioModel> comentarioList, 
            List<Curtida> curtidaList) {
        
        super(idPost, texto, dataPost, comentarioList, curtidaList);
    }
    
}
