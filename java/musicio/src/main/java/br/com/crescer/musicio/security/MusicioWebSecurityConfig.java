
package br.com.crescer.musicio.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/** 
 * @author leonardo.alves
 **/
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class MusicioWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsuarioDetailsService usuarioService;
    
    
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                    .antMatchers(HttpMethod.POST, "api/usuarios")
                    .permitAll()
                    .and()  
                .authorizeRequests().anyRequest().authenticated()
                    .and()
                    .httpBasic()
                    .and()
                .logout()
                    .logoutUrl("/logout")
                    .deleteCookies("JSESSIONID")
                    .permitAll()
                    .and()
                .cors().disable()
                .csrf().disable();
    }
    
    @Autowired
    public void setDetailsService(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(usuarioService);
    }
}
