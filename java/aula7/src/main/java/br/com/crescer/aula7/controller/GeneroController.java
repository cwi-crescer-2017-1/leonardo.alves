package br.com.crescer.aula7.controller;

import br.com.crescer.aula7.entity.GeneroEntity;
import br.com.crescer.aula7.repository.GeneroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author leonardo.alves
 */

@RestController
@RequestMapping(value = "api/generos")
public class GeneroController {
    
    @Autowired
    GeneroRepository repositorio;
    
    @GetMapping("/{id}")
    public GeneroEntity hello (@PathVariable("id") Long id) {
        return repositorio.findOne(id);
    }
    
    @GetMapping
    public List<GeneroEntity> kk () {
        return (List) repositorio.findAll();
    }
}
