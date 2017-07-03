
package br.com.crescer.musicio.exception;

/** 
 * @author leonardo.alves
 **/
public class AlreadyFriendsException extends Exception {

    
    public AlreadyFriendsException () {
        super("O usuário já é seu amigo!");
    }
    
    public AlreadyFriendsException(String msg) {
        super(msg);
    }
    
     public AlreadyFriendsException(String msg, Throwable cause){
        super(msg, cause);
    }


}
