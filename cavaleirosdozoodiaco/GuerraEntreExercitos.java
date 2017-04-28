import java.security.InvalidParameterException;
public class GuerraEntreExercitos  {
    private ExercitoDeSaints exercito1, exercito2;
    private final int tamanhoDosExercitos;
    public GuerraEntreExercitos (ExercitoDeSaints exercito1, ExercitoDeSaints exercito2) {
        if(exercito1.todos().size() == 0 && exercito2.todos().size() == 0) {
            throw new InvalidParameterException("Pelo menos um dos dois exércitos é nulo");
        }
        this.exercito1 = exercito1;
        this.exercito2 = exercito2;   
        tamanhoDosExercitos = exercito1.tamanhoDoExercito();
    }    
    
    public void iniciar () {
        for(int i = 0; i < tamanhoDosExercitos; i++) {
            Batalha x1 = new Batalha(exercito1.proximoSaint(), exercito2.proximoSaint());        
        }        
    }    
}