
package br.com.crescer.musicio.security;

import java.util.Collection;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

/** 
 * @author leonardo.alves
 **/

@Component
public final class SessionAttr {
    
    private Authentication authentication;
    private SecurityContext securityContext;
    private User sessionUser;    
   
    public void init () {
        securityContext = SecurityContextHolder.getContext();  
        authentication  = securityContext.getAuthentication();      
        sessionUser = (User) authentication.getPrincipal(); 
    }
    
    public User getUserFromSession () {
        return sessionUser;
    }
    
    public String getUsername () {
        return sessionUser.getUsername();
    }
    
    public Collection<GrantedAuthority> getAuthorities () {
        return sessionUser.getAuthorities();
    }

}
