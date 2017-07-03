
package br.com.crescer.musicio.security;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.springframework.web.filter.GenericFilterBean;

/** 
 * @author leonardo.alves
 **/
public class CustomFilter extends GenericFilterBean {
 
    @Override
    public void doFilter(
      ServletRequest request, 
      ServletResponse response,
      FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);
    }
}