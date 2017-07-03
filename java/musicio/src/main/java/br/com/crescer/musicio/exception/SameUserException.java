
package br.com.crescer.musicio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** 
 * @author leonardo.alves
 **/
 @ResponseStatus(HttpStatus.CONFLICT) 
public class SameUserException extends Exception{
    
    public SameUserException () {
        super("O usuário que efetua a ação é o mesmo usuário alvo. Os usuário precisam ser diferentes.");
    }
    
    public SameUserException(String msg) {
        super(msg);
    }
    
     public SameUserException(String msg, Throwable cause){
        super(msg, cause);
    }

}
