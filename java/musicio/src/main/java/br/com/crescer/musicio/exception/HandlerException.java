
package br.com.crescer.musicio.exception;



import javax.persistence.RollbackException;
import org.hibernate.HibernateException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author leonardo.alves
 */
@ControllerAdvice
public class HandlerException {
    
   
    
    @ResponseBody
    @ExceptionHandler(AlreadyFriendsException.class)     
    public ExceptionResponse alreadyFriendsException (final AlreadyFriendsException exception) {
        return new ExceptionResponse(exception.getMessage());
    }    

    
    @ResponseBody
    @ExceptionHandler(SameUserException.class)     
    public ExceptionResponse sameUserException (final SameUserException exception) {
        return new ExceptionResponse(exception.getMessage());
    }    
      
    
    @ResponseBody
    @ExceptionHandler(EmailBeingUsedException.class)    
    public ExceptionResponse emailBeingUsedException (final EmailBeingUsedException exception) {
        return new ExceptionResponse(exception.getMessage());
    } 
    
    
    public static class ExceptionResponse {
        String message;
        
        ExceptionResponse(String message) {
            this.message = message;
        }
    }
    
    
}