
package br.com.crescer.musicio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** 
 * @author leonardo.alves
 **/
 @ResponseStatus(HttpStatus.CONFLICT) 
public class EmailBeingUsedException extends Exception {
    
    public EmailBeingUsedException(String msg){
        super(msg);
    }
    
    public EmailBeingUsedException() {
        super("O email informado já existe no sistema.");
    }
    
    public EmailBeingUsedException (String msg, Throwable cause) {
        super(msg, cause);
    }

}
