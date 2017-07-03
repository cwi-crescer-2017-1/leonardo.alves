/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.musicio.service;

import br.com.crescer.musicio.entity.Post;
import br.com.crescer.musicio.model.CurtidaModel;
import javassist.NotFoundException;

/**
 *
 * @author leonardo.alves
 */
public interface CurtidaService {
    
    public CurtidaModel curtirPost(Post post);
    public void descurtirPost(Post post) throws NotFoundException;
}
