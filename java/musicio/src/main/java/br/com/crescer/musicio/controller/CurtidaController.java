
package br.com.crescer.musicio.controller;

import br.com.crescer.musicio.entity.Curtida;
import br.com.crescer.musicio.model.CurtidaModel;
import br.com.crescer.musicio.service.CurtidaServiceImpl;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
 * @author leonardo.alves
 **/
@RestController
@RequestMapping("/curtidas")
public class CurtidaController {
    
    @Autowired
    CurtidaServiceImpl service;
    
    @PostMapping
    public CurtidaModel curtirPost(@RequestBody Curtida curtida){
        return service.curtirPost(curtida.getPostIdPost());
    }
    
    @DeleteMapping
    public void descurtir (@RequestBody Curtida curtida) throws NotFoundException {
        service.descurtirPost(curtida.getPostIdPost());                
    }

}
