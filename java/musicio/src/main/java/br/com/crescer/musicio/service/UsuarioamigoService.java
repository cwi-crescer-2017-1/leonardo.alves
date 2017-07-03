/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.musicio.service;

import br.com.crescer.musicio.entity.Usuario;
import br.com.crescer.musicio.entity.Usuarioamigo;
import br.com.crescer.musicio.exception.SameUserException;
import br.com.crescer.musicio.model.PostUsuarioModel;
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

}
