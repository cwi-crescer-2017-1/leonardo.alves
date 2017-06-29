
package br.com.crescer.aula7.controller;

import br.com.crescer.aula7.entity.Locacao;
import br.com.crescer.aula7.repository.LocacaoRepository;
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
@RequestMapping("api/locacoes")
public class LocacaoController extends AbstractController<Locacao> {
    
    @Autowired
    LocacaoRepository repositorio;

    @Override
    @GetMapping("{id}")
    public Locacao findOne(@PathVariable("id") Long id) {
        return repositorio.findOne(id);
    }

    @Override
    @GetMapping
    public Iterable<Locacao> findAll() {
        return repositorio.findAll();
    }

    @Override
    @PostMapping
    public Locacao post(Locacao t) {
        return repositorio.save(t);
    }

    @Override
    @DeleteMapping
    public void delete(Locacao t) {
        repositorio.delete(t);
    }

}
