
package br.com.crescer.musicio.service;

import br.com.crescer.musicio.entity.Usuario;
import br.com.crescer.musicio.repository.UsuarioRepository;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

    
public class UsuarioServiceImpl implements UsuarioService {
    
    @Autowired
    UsuarioRepository repositorio;
    
    @Override
    public Usuario save(Usuario usuario) {
        return repositorio.save(usuario);
    }

    @Override
    public Usuario findOne(BigDecimal id) {
        return repositorio.findOne(id);
    }

    @Override
    public Page<Usuario> findByNome(String nome, Page pageable) {
        return repositorio.findAll(new PageRequest(0, 5));
    }
}
