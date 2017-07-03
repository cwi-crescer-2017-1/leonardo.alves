
package br.com.crescer.musicio.controller;

import br.com.crescer.musicio.entity.Usuario;
import br.com.crescer.musicio.entity.Usuarioamigo;
import br.com.crescer.musicio.model.AmigoComPostModel;
import br.com.crescer.musicio.model.PostUsuarioModel;
import br.com.crescer.musicio.service.UsuarioamigoServiceImpl;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
 * @author leonardo.alves
 **/

@RestController
@RequestMapping("/amizades")
public class AmizadeController {
    
    @Autowired
    UsuarioamigoServiceImpl service;
    
    @GetMapping("{id}")
    public AmigoComPostModel getAmigo (@PathVariable("id") BigDecimal id) {
        return service.pegarAmigo(id);
    }
    
   
    @GetMapping
    public List<PostUsuarioModel> solicitacoesDeAmizade () {
        return service.getSolicitacoes();
    }
    
    @GetMapping("/todos")
    public List<PostUsuarioModel> todosAmigos () {
       return service.getAmigos();
    }
     
    @PutMapping("/aceitar")
    public Usuarioamigo aceitarSolicitacao (@RequestBody Usuario usuario) {
        return service.aceitarSolicitacao(usuario);
    }
    
    @PutMapping("/recusar")
    public Usuarioamigo recusarSolicitacao (@RequestBody Usuario usuario) {
        return service.recusarSolicitacao(usuario);
    }
    
    @PostMapping
    public Usuarioamigo enviarSolicitacao (@RequestBody Usuario usuario) throws Exception {
        return service.enviarSolicitacao(usuario);
    }
}
