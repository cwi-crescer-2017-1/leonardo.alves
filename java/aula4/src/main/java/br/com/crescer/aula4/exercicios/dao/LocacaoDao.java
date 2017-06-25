
package br.com.crescer.aula4.exercicios.dao;

import br.com.crescer.aula4.exercicios.pojo.Locacao;

/** 
 * @author leonardo.alves
 **/
public final class LocacaoDao extends GenericDAO<Locacao, Long> {

    public LocacaoDao () {
        super(Locacao.class);
    }
        
}
