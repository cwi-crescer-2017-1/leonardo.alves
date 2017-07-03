
package br.com.crescer.musicio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** 
 * @author leonardo.alves
 **/
 @ResponseStatus(HttpStatus.NOT_FOUND) 
public class UserNotFoundException extends Exception {

     public UserNotFoundException(){
         super("O usuário não foi encontrado!");
     }
     
     public UserNotFoundException (String msg) {
         super(msg);
     }
}
