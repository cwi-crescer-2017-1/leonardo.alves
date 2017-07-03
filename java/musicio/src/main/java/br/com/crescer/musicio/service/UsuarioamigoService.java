
package br.com.crescer.musicio.service;

import br.com.crescer.musicio.entity.Usuario;
import br.com.crescer.musicio.entity.UsuarioBase;
import br.com.crescer.musicio.entity.Usuarioamigo;
import br.com.crescer.musicio.exception.UserNotFoundException;
import br.com.crescer.musicio.model.PostUsuarioModel;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author leonardo.alves
 */
public interface UsuarioamigoService {
    
    List<PostUsuarioModel> getSolicitacoes ();
    List<PostUsuarioModel> getAmigos();
    Usuarioamigo aceitarSolicitacao (Usuario amigo);
    Usuarioamigo recusarSolicitacao (Usuario amigo);
    Usuarioamigo enviarSolicitacao(Usuario amigo) throws Exception;
    UsuarioBase pegarAmigo(BigDecimal id) throws UserNotFoundException;

}
