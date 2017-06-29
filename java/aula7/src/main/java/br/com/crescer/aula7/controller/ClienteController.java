
package br.com.crescer.aula7.controller;

import br.com.crescer.aula7.entity.Cliente;
import br.com.crescer.aula7.repository.ClienteRepository;
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
@RequestMapping(value="api/clientes")
public class ClienteController extends AbstractController<Cliente>  {
    @Autowired
    ClienteRepository repositorio;

    @Override
    @GetMapping("{id}")
    public Cliente findOne(@PathVariable("id") Long id) {
        return repositorio.findOne(id);
    }

    @Override
    @GetMapping
    public Iterable findAll() {
        return repositorio.findAll();
    }

    @Override
    @PostMapping
    public Cliente post(Cliente t) {
        return repositorio.save(t);
    }

    @Override
    @DeleteMapping
    public void delete(Cliente t) {
        repositorio.delete(t);
    }       
}
    