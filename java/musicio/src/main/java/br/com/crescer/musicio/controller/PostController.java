
package br.com.crescer.musicio.controller;

import br.com.crescer.musicio.entity.Post;
import br.com.crescer.musicio.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
 * @author leonardo.alves
 **/
@RestController
@RequestMapping("/posts")
public class PostController {
    
    @Autowired
    PostServiceImpl postService;
    
    @PostMapping()
    public Post publicar (@RequestBody Post post) {        
        return postService.publicar(post);
    }
}
