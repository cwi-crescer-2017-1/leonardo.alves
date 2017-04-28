import java.util.ArrayList;
public abstract class ExercitoDeSaints extends ListaSaints{    
public abstract class ExercitoDeSaints extends ListaSaints{  
    
    protected int valorCategoriaSaint = 1;   
    
    protected void proximoValorCategoria () {
        if(this.valorCategoriaSaint < 3) this.valorCategoriaSaint++; 
            else this.valorCategoriaSaint = 1;
          
    }
    
    public void alistar(Saint saint) {
        adicionar(saint);
    }

    public abstract Saint proximoSaint ();
}