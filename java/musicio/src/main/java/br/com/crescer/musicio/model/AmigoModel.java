
package br.com.crescer.musicio.model;

import br.com.crescer.musicio.entity.UsuarioBase;
import java.math.BigDecimal;
import java.util.Date;


/** 
 * @author leonardo.alves
 **/
public class AmigoModel extends UsuarioBase {   
   
   public AmigoModel (String nome, String email, 
           Character sexo, BigDecimal idUsuario, Date dataNascimento) {
       super(idUsuario, nome, email, sexo, dataNascimento);
   }
}
