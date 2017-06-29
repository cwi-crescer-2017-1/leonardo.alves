
package br.com.crescer.aula7.controller;

/** 
 * @author leonardo.alves
 * @param <T> Entidade a ser manipulada.
 **/

public abstract class AbstractController <T> { 
    
    public abstract T findOne(Long id);
    public abstract Iterable<T> findAll ();    
    public abstract T post (T t);
    public abstract void delete (T t);
//  TODO:  public abstract T update(T t);    
    
}
