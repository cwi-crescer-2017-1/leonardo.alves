
package br.com.crescer.musicio.controller;

import br.com.crescer.musicio.entity.Comentario;
import br.com.crescer.musicio.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
 * @author leonardo.alves
 **/
@RestController
@RequestMapping("/comentarios")
public class ComentarioController {
    
    @Autowired
    ComentarioService comentarioService;
    
    @PostMapping
    public Comentario comentar(@RequestBody Comentario comentario) {
        return comentarioService.comentar(comentario);
    }
}
