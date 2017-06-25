
package br.com.crescer.aula4.exercicios.dao;

import br.com.crescer.aula4.exercicios.pojo.Genero;

/** 
 * @author leonardo.alves
 **/
public final class GeneroDao extends GenericDAO<Genero, Long> {
    
    public GeneroDao () { 
        super(Genero.class);
    }
    
}
