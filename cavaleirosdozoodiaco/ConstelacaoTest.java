

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConstelacaoTest {
    @Test
    public void adicionarUmGolpe () {
        Constelacao constelacao = new Constelacao("Zumba");
        Golpe socao = new Golpe("Socão", 7);       
        constelacao.adicionarGolpe(socao); 
        assertEquals(socao, constelacao.getGolpes().get(0));        
    }
    
    @Test
    public void adicionarDoisGolpes () {
        Constelacao constelacao = new Constelacao("Zumba");
        Golpe socao = new Golpe("Socão", 7);
        Golpe socao2 = new Golpe("Socão2", 7);
        constelacao.adicionarGolpe(socao); 
        constelacao.adicionarGolpe(socao2);
        assertEquals(socao, constelacao.getGolpes().get(0));
        assertEquals(socao2, constelacao.getGolpes().get(1));
       
    }
    
    @Test
    public void adicionarTresGolpes () {
        Constelacao constelacao = new Constelacao("Zumba");
        Golpe socao = new Golpe("Socão", 7);
        Golpe socao2 = new Golpe("Socão2", 7);
        Golpe socao3 = new Golpe("Socão3", 7);
        constelacao.adicionarGolpe(socao);
        constelacao.adicionarGolpe(socao2);
        constelacao.adicionarGolpe(socao3);
        assertEquals(socao, constelacao.getGolpes().get(0));
        assertEquals(socao2, constelacao.getGolpes().get(1));
        assertEquals(socao3, constelacao.getGolpes().get(2));
    }
    
    @Test
    public void adicionarGolpeNulo () {
        Constelacao constelacao = new Constelacao("XX");
        constelacao.adicionarGolpe(null);
        assertNull(constelacao.getGolpes().get(0));    
    }
    
    /*@Test(expected=ArrayIndexOutOfBoundsException.class)
    public void adicionarQuatroGolpes () {
        Constelacao constelacao = new Constelacao("Zumba");
        Golpe socao = new Golpe("Socão", 7);
        Golpe socao2 = new Golpe("Socão2", 7);
        Golpe socao3 = new Golpe("Socão3", 7);
        Golpe socao4 = new Golpe("Socão4", 7);
        constelacao.adicionarGolpe(socao);
        constelacao.adicionarGolpe(socao2);
        constelacao.adicionarGolpe(socao3);
        constelacao.adicionarGolpe(socao4);        
    }*/
}