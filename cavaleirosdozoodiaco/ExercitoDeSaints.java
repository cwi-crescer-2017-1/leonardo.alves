import java.util.ArrayList;
public abstract class ExercitoDeSaints extends ListaSaints{    
    
    public void alistar(Saint saint) {
        adicionar(saint);
    }

    public abstract Saint proximoSaint ();
}