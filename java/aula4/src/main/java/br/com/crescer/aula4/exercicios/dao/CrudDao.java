package br.com.crescer.aula4.exercicios.dao;

import java.util.List;
import javax.persistence.EntityManager;

/**
 * @author carloshenrique
 * @param <Entity>
 * @param <ID>
 */
public interface CrudDao<Entity, ID> {
    
    Entity save(Entity e);

    void remove(Entity e);

    Entity loadById(ID id);

    List<Entity> findAll();
    
    EntityManager getEntityManager();
}

