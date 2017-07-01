
package br.com.crescer.musicio.service;

import br.com.crescer.musicio.entity.Permissao;
import br.com.crescer.musicio.entity.Usuario;
import br.com.crescer.musicio.entity.UsuarioBase;
import br.com.crescer.musicio.entity.Usuarioamigo;
import br.com.crescer.musicio.entity.Usuariopermissao;
import br.com.crescer.musicio.model.AmigoModel;
import br.com.crescer.musicio.repository.PermissaoRepository;
import br.com.crescer.musicio.repository.UsuarioRepository;
import br.com.crescer.musicio.repository.UsuarioamigoRepository;
import br.com.crescer.musicio.repository.UsuariopermissaoRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service    
public class UsuarioServiceImpl implements UsuarioService {
    
    @Autowired
    UsuarioRepository repositorio;
    
    @Autowired
    PermissaoRepository permissaoRepo;  
    
    @Autowired
    UsuariopermissaoRepository usuarioPermissaoRepo;
    
    @Autowired
    UsuarioamigoRepository usuarioAmigoRepo;
    
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
    
    @Override
    public String criptografarSenha(String senha) {
        return new BCryptPasswordEncoder().encode(senha);
    }

    @Override
    public void adicionarPermissao(String permissao, Usuario user) {
        Permissao permissaoObj = permissaoRepo.findByPermissao(permissao);
        Usuariopermissao uPermissao = new Usuariopermissao(user, permissaoObj);
        List<Usuariopermissao> permissoes = usuarioPermissaoRepo
                                                .findByUsuarioIdUsuario(user.getIdUsuario());
        permissoes.add(uPermissao);
        
        
        user.setPermissoes(permissoes);        
    }
    
    @Override
    public Usuario findOneByEmail(String email) {
        return repositorio.findOneByEmail(email);
    }

    @Override
    public List<UsuarioBase> getAmigos(Usuario usuario) {
        List<Usuario> amigos = usuarioAmigoRepo.getAmigos(usuario);
        List<UsuarioBase> amigoModel = new ArrayList<>();
        
        for(Usuario a : amigos){
            amigoModel.add(new AmigoModel(a.getNome(), 
                    a.getEmail(), 
                    a.getSexo(),                     
                    a.getIdUsuario(), 
                    a.getDataNascimento()));
        }
           
            
        return amigoModel;
    }

    @Override
    public Usuario findOneByIdUsuario(BigDecimal idUsuario) {
        return repositorio.findOneByIdUsuario(idUsuario);
    }
}
