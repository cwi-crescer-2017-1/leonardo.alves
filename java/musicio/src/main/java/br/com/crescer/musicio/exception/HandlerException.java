
package br.com.crescer.musicio.exception;



import javassist.NotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

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
    
    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)    
    public ExceptionResponse userNotFoundException (final EmailBeingUsedException exception) {
        return new ExceptionResponse(exception.getMessage());
    } 
    
    @ResponseBody
    @ExceptionHandler(InvalidInformationsException.class)    
    public ExceptionResponse invalidInformationsException (final EmailBeingUsedException exception) {
        return new ExceptionResponse(exception.getMessage());
    } 
    
    @ResponseBody
    @ExceptionHandler(NotFoundException.class)    
    public ExceptionResponse notFoundException (final EmailBeingUsedException exception) {
        return new ExceptionResponse(exception.getMessage());
    } 
    
    
    public static class ExceptionResponse {
        String message;
        
        ExceptionResponse(String message) {
            this.message = message;
        }
    }
    
    
}