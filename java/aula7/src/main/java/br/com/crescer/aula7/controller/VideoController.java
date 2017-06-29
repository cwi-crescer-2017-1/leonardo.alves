
package br.com.crescer.aula7.controller;

import br.com.crescer.aula7.entity.Video;
import br.com.crescer.aula7.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
 * @author leonardo.alves
 **/

@RestController
@RequestMapping("api/videos")
public class VideoController extends AbstractController<Video> {

    @Autowired
    VideoRepository repositorio;

    @Override
    @GetMapping("{id}")
    public Video findOne(@PathVariable("id") Long id) {
        return repositorio.findOne(id);
    }

    @Override
    @GetMapping
    public Iterable<Video> findAll() {
        return repositorio.findAll();
    }

    @Override
    @PostMapping
    public Video post(Video t) {
        return repositorio.save(t);
    }

    @Override
    public void delete(Video t) {
        repositorio.delete(t);
    }   
    
}
