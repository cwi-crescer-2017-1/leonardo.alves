
package br.com.crescer.musicio.security;


import br.com.crescer.musicio.entity.Permissao;
import br.com.crescer.musicio.entity.Usuario;
import br.com.crescer.musicio.entity.Usuariopermissao;
import br.com.crescer.musicio.repository.UsuarioRepository;
import br.com.crescer.musicio.repository.UsuariopermissaoRepository;
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
    UsuarioRepository repoUsuario;
    
    @Autowired
    UsuariopermissaoRepository repoPermissoes;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        Usuario usuario = repoUsuario.findOneByEmail(username);
        List<Usuariopermissao> permissoes = 
                repoPermissoes.findByUsuarioIdUsuario(usuario.getIdUsuario());       
      
        List<GrantedAuthority> roles = new ArrayList<>();

        for(Usuariopermissao p : permissoes) {
            String roleName = p.getPermissao().getPermissao();
            roles.add(() -> "ROLE_".concat(roleName));
        }

        return new User(usuario.getEmail(), usuario.getSenha(), roles);       
        
    }

}
