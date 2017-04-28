import java.util.ArrayList;
public abstract class ExercitoDeSaints extends ListaSaints{    
public abstract class ExercitoDeSaints extends ListaSaints{  
    
    protected int valorCategoriaSaint = 1;   
    protected Saint proximoSaint;    
    
    protected void proximoValorCategoria () {
        if(this.valorCategoriaSaint < 3) this.valorCategoriaSaint++; 
            else this.valorCategoriaSaint = 1;
          
    }
    
    
    protected Saint getProximoSaintNaCategoria () {
        
        return buscarPorCategoria(this.valorCategoriaSaint).get(0);
    }
    public void alistar(Saint saint) {
        adicionar(saint);
    }

    public abstract Saint proximoSaint ();
}