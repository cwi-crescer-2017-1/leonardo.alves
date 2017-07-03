
package br.com.crescer.musicio.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component("restAuthenticationEntryPoint")
public class RestAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authenticationException) throws IOException, ServletException {
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);        
        response.getOutputStream().print("{ \"message\": \"" + "Usuario ou senha invalidos." + "\" }");
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {
        setRealmName("Musicio");
        super.afterPropertiesSet();
    }
}