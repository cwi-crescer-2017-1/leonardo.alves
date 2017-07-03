
package br.com.crescer.musicio.controller;

import br.com.crescer.musicio.entity.Usuario;
import br.com.crescer.musicio.entity.UsuarioBase;
import br.com.crescer.musicio.exception.EmailBeingUsedException;
import br.com.crescer.musicio.exception.InvalidEmailException;
import br.com.crescer.musicio.exception.InvalidInformationsException;
import br.com.crescer.musicio.exception.UserNotFoundException;
import br.com.crescer.musicio.model.PostUsuarioModel;
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
      public Map<String, Object> usuarioLogado(Authentication authentication) throws UserNotFoundException  {
          try {
                PostUsuarioModel u = Optional.ofNullable(authentication)
                    .map(Authentication::getPrincipal)
                    .map(User.class::cast)
                    .map(User::getUsername)
                    .map(service::findOneByEmail)
                    .map(Usuario::converterParaUsuarioModel)
                    .orElse(null);
            final HashMap<String, Object> hashMap = new HashMap<>();         
          
          hashMap.put("dados", u);
          return hashMap;
            
        } catch (Exception e) {
            throw new UserNotFoundException("Usuário ou senha inválido.");
        }
          
      }    
      
    @GetMapping("/pesquisa/{pesquisa}")
    public List<PostUsuarioModel> pesquisarUsuarios (@PathVariable("pesquisa") String nome) {
        return service.pesquisarUsuarios(nome);
    }
        
   
    @PostMapping(consumes = "application/json")
    public Usuario cadastrarUsuario (@RequestBody Usuario usuario) throws InvalidEmailException, EmailBeingUsedException {
       service.verificarSeEmailEstaEmUso(usuario.getEmail());
            
        usuario.setSenha(
            service.criptografarSenha(usuario.getSenha())
        );
        
        service.adicionarPermissao("USR", usuario);
        
        try {
            return service.save(usuario);
            
        } catch (Exception e) {
            throw new InvalidEmailException();
        }
   
    }  
    
    @PutMapping(consumes = "application/json")
    public Usuario editarUsuario (@RequestBody Usuario usuario) throws UserNotFoundException, InvalidInformationsException {
        Usuario usuarioVelho = service.findOneByEmail(usuario.getEmail());
        
        if(usuarioVelho.getNome() == null)
            throw new InvalidInformationsException("O nome é inválido");
        
        if(usuarioVelho.getDataNascimento() == null)
            throw new InvalidInformationsException("A data de nascimento não pode ser nula");
        
        if(usuarioVelho.getSexo() == null)
            throw new InvalidInformationsException("O sexo não pode ser nulo");
        
        if(usuarioVelho.getEmail() == null)
            throw new InvalidInformationsException("Erro ao enviar as informações para o servidor.");
        
        if(usuarioVelho == null)
            throw new UserNotFoundException();
        
        if(usuario.getSenha() == null) {
            usuario.setSenha(usuarioVelho.getSenha());
        } else {
            usuario.setSenha(service.criptografarSenha(usuario.getSenha()));
        }            
        
        usuarioVelho = usuario;
        return service.save(usuarioVelho);
    }
    
    @GetMapping("/{id}/amigos")
    public List<UsuarioBase> pegarAmigos (@PathVariable("id") BigDecimal id) {
        Usuario usuario = service.findOneByIdUsuario(id);
        return service.getAmigos(usuario);
    }
}
