package br.com.crescer.musicio.service;

import br.com.crescer.musicio.entity.Usuario;
import br.com.crescer.musicio.entity.UsuarioBase;
import br.com.crescer.musicio.exception.EmailBeingUsedException;
import br.com.crescer.musicio.model.PostUsuarioModel;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author leonardo.alves
 */
public interface UsuarioService {
    
    Usuario save(Usuario usuario);
    Usuario findOne(BigDecimal id);
    void verificarSeEmailEstaEmUso(String email) throws EmailBeingUsedException;
    Page<Usuario> findByNome (String nome, Page pageable);
    String criptografarSenha(String senha);
    void adicionarPermissao(String permissao, Usuario user);
    Usuario findOneByEmail(String email);
    List<UsuarioBase> getAmigos(Usuario usuario);
    List<PostUsuarioModel> pesquisarUsuarios(String nome);
    Usuario findOneByIdUsuario(BigDecimal idUsuario);
}
