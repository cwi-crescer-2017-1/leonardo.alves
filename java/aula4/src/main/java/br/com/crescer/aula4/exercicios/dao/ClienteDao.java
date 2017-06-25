
package br.com.crescer.aula4.exercicios.dao;

import br.com.crescer.aula4.exercicios.pojo.Cliente;

/** 
 * @author leonardo.alves
 **/
public final class ClienteDao extends GenericDAO<Cliente, Long> {
    
    public ClienteDao(){
        super(Cliente.class);
    }
    
}
