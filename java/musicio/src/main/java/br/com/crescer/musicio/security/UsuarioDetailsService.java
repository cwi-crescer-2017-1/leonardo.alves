
package br.com.crescer.musicio.security;


import br.com.crescer.musicio.entity.Usuario;
import br.com.crescer.musicio.repository.UsuarioRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/** 
 * @author leonardo.alves
 **/ 

@Service
public class UsuarioDetailsService implements UserDetailsService {
    
    @Autowired
    UsuarioRepository repositorio;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        Usuario usuario = repositorio.findByEmail(username);
        
        if(usuario == null) 
            throw new UsernameNotFoundException("As credenciais informadas não são válidas.");
        
        List<GrantedAuthority> roles = new ArrayList<>();

        usuario.getPermissoes()
            .stream()
            .forEach((p) -> {
                roles.add(() -> p.getPermissao().getPermissao());
            });

        return new User(usuario.getEmail(), usuario.getSenha(), roles);       
        
    }

}
