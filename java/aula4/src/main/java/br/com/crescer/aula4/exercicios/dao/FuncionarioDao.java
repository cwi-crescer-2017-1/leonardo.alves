
package br.com.crescer.aula4.exercicios.dao;

import br.com.crescer.aula4.exercicios.pojo.Funcionario;

/** 
 * @author leonardo.alves
 **/
public final class FuncionarioDao extends GenericDAO<Funcionario, Long> {
    
    public FuncionarioDao () {
        super(Funcionario.class);
    }
        
}
