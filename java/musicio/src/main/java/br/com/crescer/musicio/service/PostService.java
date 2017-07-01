
package br.com.crescer.musicio.service;

import br.com.crescer.musicio.entity.Post;
import br.com.crescer.musicio.model.PostModel;
import java.math.BigDecimal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author leonardo.alves
 */
public interface PostService {
    
    Post publicar(Post post);
    Page<PostModel> pegarPosts(Pageable pageable);
    Post findByIdPost (BigDecimal idPost);
}
