
package br.com.crescer.musicio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** 
 * @author leonardo.alves
 **/
 @ResponseStatus(HttpStatus.BAD_REQUEST) 
public class InvalidEmailException extends Exception {
    
     public InvalidEmailException () {
        super("O email informado é inválido. Por favor cheque.");
    }
    
    public InvalidEmailException(String msg) {
        super(msg);
    }
    
     public InvalidEmailException(String msg, Throwable cause){
        super(msg, cause);
    }
}
