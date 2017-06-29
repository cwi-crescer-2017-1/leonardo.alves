
package br.com.crescer.aula7.controller;

import br.com.crescer.aula7.entity.Funcionario;
import br.com.crescer.aula7.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
 * @author leonardo.alves
 **/
@RestController
@RequestMapping(value="/api/funcionarios")
public class FuncionarioController extends AbstractController<Funcionario> {
    @Autowired
    FuncionarioRepository repositorio;

    @Override
    @GetMapping("{id}")
    public Funcionario findOne(@PathVariable("id") Long id) {
        return repositorio.findOne(id);
    }

    @Override
    @GetMapping
    public Iterable<Funcionario> findAll() {
        return repositorio.findAll();
    }

    @Override
    @PostMapping
    public Funcionario post(Funcionario t) {
        return repositorio.save(t);
    }

    @Override
    @DeleteMapping
    public void delete(Funcionario t) {
        repositorio.delete(t);
    }
    
    
}
