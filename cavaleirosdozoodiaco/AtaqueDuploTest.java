

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AtaqueDuploTest {
    @Test 
    public void falharNoAtaquePerdeVida () throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint marin = new SilverSaint("Marin", "Cobra");
        seiya.aprenderGolpe(new Golpe("Socao", 10));
        seiya.adicionarMovimento(new AtaqueDuplo(seiya, marin, new DadoFalso(-1)));
        seiya.getProximoMovimento().executar();
        assertEquals(95,  seiya.getVida(), 0.01);
        assertEquals(90, marin.getVida(), 0.01);
    }  
    
    @Test
    public void passarNoTesteNaoPerdeVida () throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint marin = new SilverSaint("Marin", "Cobra");
        seiya.aprenderGolpe(new Golpe("Socao", 10));
        seiya.adicionarMovimento(new AtaqueDuplo(seiya, marin, new DadoFalso(2)));
        seiya.getProximoMovimento().executar();
        assertEquals(100,  seiya.getVida(), 0.01);
        assertEquals(80, marin.getVida(), 0.01);
    }
}
