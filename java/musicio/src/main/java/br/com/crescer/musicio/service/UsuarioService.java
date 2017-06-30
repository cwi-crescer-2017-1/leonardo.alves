package br.com.crescer.musicio.service;

import br.com.crescer.musicio.entity.Usuario;
import java.math.BigDecimal;
import org.springframework.data.domain.Page;

/**
 *
 * @author leonardo.alves
 */
public interface UsuarioService {
    
    Usuario save(Usuario usuario);
    Usuario findOne(BigDecimal id);
    Page<Usuario> findByNome (String nome, Page pageable);
    
}
