import java.util.ArrayList;
public abstract class ExercitoDeSaints extends ListaSaints{  
    
    protected int valorCategoriaSaint = 1;   
    protected Saint proximoSaint;    
    
    public int tamanhoDoExercito () {
        return this.todos().size();
    }
    
    protected void proximoValorCategoria () {
        if(this.valorCategoriaSaint < 3) this.valorCategoriaSaint++; 
            else this.valorCategoriaSaint = 1;
          
    }
    
    protected boolean existeSaintNaCategoria () {
        return (buscarPorCategoria(this.valorCategoriaSaint).size() != 0) ?
            true : false;       
    }
    
    protected Saint getProximoSaintNaCategoria () {
        
        return buscarPorCategoria(this.valorCategoriaSaint).get(0);
    }
    
    protected void removerSaintDaCategoria (Saint saintJaAtacou) {
        remover(saintJaAtacou);
    }
    
    public void alistar(Saint saint) {
        adicionar(saint);
    }

    public abstract Saint proximoSaint ();
}