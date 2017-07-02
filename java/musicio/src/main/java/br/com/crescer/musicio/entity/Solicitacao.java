
package br.com.crescer.musicio.entity;

/** 
 * @author leonardo.alves
 **/
public enum Solicitacao {
    ACEITO('A'), PENDENTE('P'), RECUSADO('R');    
 
    public Character situacao;
    
    Solicitacao(Character situacao) {
        this.situacao = situacao;
    }
    
    public Character getSituacao() {
        return this.situacao;
    }
}
