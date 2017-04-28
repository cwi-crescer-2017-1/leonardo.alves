import java.security.InvalidParameterException;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GuerraEntreExercitosTest {
    @Test
    public void guerraEntreExercitos () throws Exception {
        ExercitoDeSaints defensoresDeAthena = new ExercitoQueAtacaEmOrdemHierarquica();
        defensoresDeAthena.alistar(new GoldSaint("Aiolia", "Leão"));
        defensoresDeAthena.alistar(new BronzeSaint("Hyoga", "Cisne"));
        defensoresDeAthena.alistar(new SilverSaint("Marin", "Águia"));
        defensoresDeAthena.alistar(new BronzeSaint("Seiya", "Pégaso"));
        defensoresDeAthena.alistar(new GoldSaint("Shura", "Capricórnio"));
        defensoresDeAthena.alistar(new BronzeSaint("Shiryu", "Dragão"));
        
        ExercitoDeSaints impostores = new ExercitoQueAtacaEmOrdemAlternada();
        impostores.alistar(new SilverSaint("Misty", "Lagarto"));
        impostores.alistar(new GoldSaint("Máscara da Morte", "Câncer"));
        impostores.alistar(new BronzeSaint("Ikki", "Fênix"));
        impostores.alistar(new GoldSaint("Saga", "Gêmeos"));
        impostores.alistar(new SilverSaint("Algol", "Perseu"));
        impostores.alistar(new GoldSaint("Afrodite", "Peixes"));
        
        GuerraEntreExercitos guerra = new GuerraEntreExercitos(defensoresDeAthena, impostores);
        guerra.iniciar();
        //apos a guerra, todos os saints devem sair fora dos exercitos, logo
        //os dois exercitos devem ter a sua lista de saints com o tamanho 0
        assertEquals(0, defensoresDeAthena.todos().size());
        assertEquals(0, impostores.todos().size());
    }
    
    @Test(expected=InvalidParameterException.class)
    public void guerraEntreExercitosSemSaints () throws Exception {
        ExercitoDeSaints defensoresDeAthena = new ExercitoQueAtacaEmOrdemHierarquica();
        ExercitoDeSaints impostores = new ExercitoQueAtacaEmOrdemAlternada();
        GuerraEntreExercitos guerra = new GuerraEntreExercitos(defensoresDeAthena, impostores);
        guerra.iniciar();
    }
    
    @Test(expected=NullPointerException.class)
    public void guerraEntreExercitosComUmNulo () throws Exception {
        ExercitoDeSaints defensoresDeAthena = null;
        ExercitoDeSaints impostores = new ExercitoQueAtacaEmOrdemAlternada();
        GuerraEntreExercitos guerra = new GuerraEntreExercitos(defensoresDeAthena, impostores);
        guerra.iniciar();        
    }
    
     
    @Test(expected=NullPointerException.class)
    public void guerraEntreExercitosComDoisNulos () throws Exception {        
        ExercitoDeSaints defensoresDeAthena = null;
        ExercitoDeSaints impostores = null;
        GuerraEntreExercitos guerra = new GuerraEntreExercitos(defensoresDeAthena, impostores);
        guerra.iniciar();        
    }
}