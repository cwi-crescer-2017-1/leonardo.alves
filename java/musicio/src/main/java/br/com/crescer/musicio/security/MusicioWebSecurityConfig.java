
package br.com.crescer.musicio.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

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
        RestAuthenticationEntryPoint entryPoint = new RestAuthenticationEntryPoint();
      
        
        httpSecurity                
                .authorizeRequests().antMatchers("/currentUser").permitAll()
                .and()
                .authorizeRequests().antMatchers(HttpMethod.POST, "/usuarios").permitAll()
                .and()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .httpBasic() 
                .authenticationEntryPoint(entryPoint)
                .and()               
                .cors()                                                        
                .and()
                .csrf().disable();
        httpSecurity
                .addFilterAfter(new CustomFilter(), BasicAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity webSecurity) throws Exception {
        webSecurity.ignoring().antMatchers("/usuarios/login");
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("PUT", "DELETE", "GET", "OPTIONS", "POST");
            }
        };
    }

    @Autowired
    public void setDetailsService(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
