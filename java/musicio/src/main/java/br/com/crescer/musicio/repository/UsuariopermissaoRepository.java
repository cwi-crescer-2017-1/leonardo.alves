/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.musicio.repository;

import br.com.crescer.musicio.entity.Usuariopermissao;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author leonardo.alves
 */
public interface UsuariopermissaoRepository extends CrudRepository<Usuariopermissao, BigDecimal>{
    
    List<Usuariopermissao> findByUsuarioIdUsuario (BigDecimal id);
    
}
