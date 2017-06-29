package br.com.crescer.aula7.controller;

import br.com.crescer.aula7.entity.Genero;
import br.com.crescer.aula7.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author leonardo.alves
 */

@RestController
@RequestMapping(value = "api/generos")
public class GeneroController extends AbstractController<Genero> {
    
    @Autowired
    GeneroRepository repositorio;

    @Override
    @GetMapping("{id}")
    public Genero findOne(@PathVariable("id") Long id) {
        return repositorio.findOne(id);
    }

    @Override
    @GetMapping
    public Iterable findAll() {
        return repositorio.findAll();
    }

    @Override
    @PostMapping
    public Genero post(Genero t) {
        return repositorio.save(t);
    }

    @Override
    @DeleteMapping
    public void delete(Genero t) {
        repositorio.delete(t);
    }  

}
