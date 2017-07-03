
package br.com.crescer.musicio.service;

import br.com.crescer.musicio.entity.Solicitacao;
import br.com.crescer.musicio.entity.Usuario;
import br.com.crescer.musicio.entity.Usuarioamigo;
import br.com.crescer.musicio.exception.AlreadyFriendsException;
import br.com.crescer.musicio.exception.SameUserException;
import br.com.crescer.musicio.model.AmigoComPostModel;
import br.com.crescer.musicio.model.PostSemUsuarioModel;
import br.com.crescer.musicio.model.PostUsuarioModel;
import br.com.crescer.musicio.repository.PostRepository;
import br.com.crescer.musicio.repository.UsuarioRepository;
import br.com.crescer.musicio.repository.UsuarioamigoRepository;
import br.com.crescer.musicio.security.SessionAttr;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** 
 * @author leonardo.alves
 **/
@Service
public class UsuarioamigoServiceImpl implements UsuarioamigoService {

    @Autowired
    UsuarioamigoRepository repositorio;
    
    @Autowired
    SessionAttr sessionAttributes;
            
    @Autowired
    UsuarioRepository usuarioRepo;
    
    @Autowired
    PostRepository postRepo;
    
    @Override
    public List<PostUsuarioModel> getSolicitacoes() {
        
        List<PostUsuarioModel> usuariosDto = new ArrayList<>();
        
         repositorio.getSolicitacoes(getUsuario())
                 .forEach((u) -> usuariosDto.add(u.converterParaUsuarioModel()));
        return usuariosDto;
    }

    @Override
    public Usuarioamigo aceitarSolicitacao(Usuario amigo) { 
        Usuarioamigo amizadeinversa = 
                repositorio.pegarSolicitacaoPendente(getUsuario(), amigo);
        
        //faz o relacionamento de  u <-> a, ou seja, unicamente bidirecional
        if(amizadeinversa == null) {
            amizadeinversa = new Usuarioamigo();
            amizadeinversa.setUsuario(getUsuario());
            amizadeinversa.setAmigo(amigo);
        }
        
        amizadeinversa.setSituacao('A');
        repositorio.save(amizadeinversa);
        
        return responderSolicitacao(Solicitacao.ACEITO, amigo);
    }
    
    @Override
    public Usuarioamigo recusarSolicitacao(Usuario amigo) {
       return responderSolicitacao(Solicitacao.RECUSADO, amigo);
    }
    
    private Usuarioamigo responderSolicitacao(Solicitacao solicitacao, Usuario amigo) {
        Usuarioamigo amizade = getSolicitacao(amigo);     
                
        amizade.setSituacao(solicitacao.getSituacao());
        
        repositorio.save(amizade);
        return amizade;
    }
    
    private Usuarioamigo getSolicitacao(Usuario amigo) {
         amigo = usuarioRepo.findOneByIdUsuario(amigo.getIdUsuario());
        Usuario usuario = getUsuario();
        
        return repositorio.getSolicitacao(amigo, usuario);
    }
    
    private Usuario getUsuario() {
        sessionAttributes.init();
        return usuarioRepo.findOneByEmail(sessionAttributes.getUsername());
    }

    @Override
    public List<PostUsuarioModel> getAmigos() {
        List<PostUsuarioModel> amigosDto = new ArrayList<>();
        
        repositorio.getAmigos(getUsuario())
                 .forEach((u) -> amigosDto.add(u.converterParaUsuarioModel()));
         
        return amigosDto;
    }

    @Override
    public Usuarioamigo enviarSolicitacao(Usuario amigo) throws Exception{
       Usuario userAmigo = usuarioRepo.findOneByIdUsuario(amigo.getIdUsuario());
       
       if(userAmigo.getIdUsuario() == getUsuario().getIdUsuario())
           throw new SameUserException("Não é possível adicionar a si mesmo!");       
       
       if(repositorio.verificarSeSaoAmigos(getUsuario(), userAmigo) > 0) 
           throw new AlreadyFriendsException();
       
       Usuarioamigo jaExisteSolicitacao = 
               repositorio.pegarSolicitacaoPendente(getUsuario(), userAmigo);
       
       //essa verificação evita que o manager envie dados duplicados pro banco,
       //o que resultaria em uma exception, já que a chave composta (u <-> a) é unica
       if(jaExisteSolicitacao != null){
           return  repositorio.save(jaExisteSolicitacao);
       }
       
        Usuarioamigo amizade = new Usuarioamigo();
        amizade.setAmigo(userAmigo);
        amizade.setUsuario(getUsuario());
        amizade.setSituacao('P');
        return repositorio.save(amizade);                          
    }

    @Override
    public AmigoComPostModel pegarAmigo(BigDecimal id) {
        Usuario amigoDto = usuarioRepo.findOneByIdUsuario(id);
        List<PostSemUsuarioModel> postsDto = new ArrayList<>();
        postRepo.pegarPostsDoAmigo(amigoDto)
               .forEach(a -> postsDto.add(a.converterParaPostSemUserModel()));
        
       return new AmigoComPostModel(amigoDto.getIdUsuario(), 
               amigoDto.getEmail(), amigoDto.getSexo(), 
               amigoDto.getDataNascimento(), postsDto);
    }
}
