
package br.com.crescer.musicio.controller;

import br.com.crescer.musicio.entity.Usuario;
import br.com.crescer.musicio.service.UsuarioServiceImpl;
import java.math.BigDecimal;
import java.util.List;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.security.core.userdetails.User;



import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
 * @author leonardo.alves
 **/
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    @Autowired
    UsuarioServiceImpl service;
    
//    @GetMapping
//    //@Secured("ROLE_ADM")
//     public String teste () {        
//        return "aaa";
//    }    
    
    @GetMapping("/currentUser")
      public Map<String, Object> usuarioLogado(Authentication authentication) {
          User u = Optional.ofNullable(authentication)
                  .map(Authentication::getPrincipal)
                  .map(User.class::cast)
                  .orElse(null);
          final HashMap<String, Object> hashMap = new HashMap<>();
          hashMap.put("dados", u);
          return hashMap;
      }    
        
   
    @PostMapping(consumes = "application/json")
    public Usuario cadastrarUsuario (@RequestBody Usuario usuario) {
        usuario.setSenha(
            service.criptografarSenha(usuario.getSenha())
        );
        
        service.adicionarPermissao("USR", usuario);
        
        return service.save(usuario);
    }  
    
    @PutMapping(consumes = "application/json")
    public Usuario editarUsuario (Usuario usuario) {
        Usuario usuarioVelho = service.findOneByEmail(usuario.getEmail());
        usuarioVelho = usuario;
        return service.save(usuarioVelho);
    }
    
    @GetMapping("/{id}/amigos")
    public List<Usuario> pegarAmigos (@PathVariable("id") BigDecimal id) {
        Usuario usuario = service.findOneByIdUsuario(id);
        return service.getAmigos(usuario);
    }
}
