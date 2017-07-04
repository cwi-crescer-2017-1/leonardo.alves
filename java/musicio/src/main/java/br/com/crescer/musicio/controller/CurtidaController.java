
package br.com.crescer.musicio.controller;

import br.com.crescer.musicio.entity.Curtida;
import br.com.crescer.musicio.exception.InvalidInformationsException;
import br.com.crescer.musicio.model.CurtidaModel;
import br.com.crescer.musicio.service.CurtidaServiceImpl;
import java.math.BigDecimal;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    public CurtidaModel curtirPost(@RequestBody Curtida curtida) throws InvalidInformationsException{
        return service.curtirPost(curtida.getPostIdPost());
    }
    
    @DeleteMapping("{idPost}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void descurtir (@PathVariable("idPost") BigDecimal idPost) throws NotFoundException {
        service.descurtirPost(idPost); 
    }

}
