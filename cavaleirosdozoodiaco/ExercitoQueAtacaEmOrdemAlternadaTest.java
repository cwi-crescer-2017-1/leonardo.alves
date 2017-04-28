

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExercitoQueAtacaEmOrdemAlternadaTest {
    @Test
    public void exercitoAtacaAlternado () throws Exception{
        ExercitoDeSaints impostores = new ExercitoQueAtacaEmOrdemAlternada();
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint deathmask = new GoldSaint("Máscara da Morte", "Câncer");
        Saint ikki = new BronzeSaint("Ikki", "Fênix");
        Saint saga = new GoldSaint("Saga", "Gêmeos");
        Saint algol = new SilverSaint("Algol", "Perseu");
        Saint afrodite = new GoldSaint("Afrodite", "Peixes");
        
        impostores.alistar(new SilverSaint("Misty", "Lagarto"));
        impostores.alistar(new GoldSaint("Máscara da Morte", "Câncer"));
        impostores.alistar(new BronzeSaint("Ikki", "Fênix"));
        impostores.alistar(new GoldSaint("Saga", "Gêmeos"));
        impostores.alistar(new SilverSaint("Algol", "Perseu"));
        impostores.alistar(new GoldSaint("Afrodite", "Peixes"));
                        
        assertEquals(ikki, impostores.proximoSaint());        
        assertEquals(misty ,impostores.proximoSaint());
        assertEquals(deathmask, impostores.proximoSaint());
        assertEquals(algol,impostores.proximoSaint());
        assertEquals(saga, impostores.proximoSaint());
        assertEquals(afrodite,impostores.proximoSaint());
    }
    
    @Test
    public void exercitoSemBronze () throws Exception {
        ExercitoDeSaints impostores = new ExercitoQueAtacaEmOrdemAlternada();
        
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint deathmask = new GoldSaint("Máscara da Morte", "Câncer");       
        Saint saga = new GoldSaint("Saga", "Gêmeos");
        Saint algol = new SilverSaint("Algol", "Perseu");
        Saint afrodite = new GoldSaint("Afrodite", "Peixes");
        
        impostores.alistar(new SilverSaint("Misty", "Lagarto"));
        impostores.alistar(new GoldSaint("Máscara da Morte", "Câncer"));        
        impostores.alistar(new GoldSaint("Saga", "Gêmeos"));
        impostores.alistar(new SilverSaint("Algol", "Perseu"));
        impostores.alistar(new GoldSaint("Afrodite", "Peixes"));                        
            
        assertEquals(misty ,impostores.proximoSaint());
        assertEquals(deathmask, impostores.proximoSaint());
        assertEquals(algol,impostores.proximoSaint());
        assertEquals(saga, impostores.proximoSaint());
        assertEquals(afrodite,impostores.proximoSaint());
    }
    
    @Test
    public void exercitoSemPrata () throws Exception {
        ExercitoDeSaints impostores = new ExercitoQueAtacaEmOrdemAlternada();
       
        Saint deathmask = new GoldSaint("Máscara da Morte", "Câncer");
        Saint ikki = new BronzeSaint("Ikki", "Fênix");
        Saint saga = new GoldSaint("Saga", "Gêmeos");        
        Saint afrodite = new GoldSaint("Afrodite", "Peixes");
        
       
        impostores.alistar(new GoldSaint("Máscara da Morte", "Câncer"));
        impostores.alistar(new BronzeSaint("Ikki", "Fênix"));
        impostores.alistar(new GoldSaint("Saga", "Gêmeos"));       
        impostores.alistar(new GoldSaint("Afrodite", "Peixes"));
                        
        assertEquals(ikki, impostores.proximoSaint());        
        assertEquals(deathmask, impostores.proximoSaint());        
        assertEquals(saga, impostores.proximoSaint());
        assertEquals(afrodite,impostores.proximoSaint());
    }
    
    @Test
    public void exercitoSemOuro () throws Exception {
        ExercitoDeSaints impostores = new ExercitoQueAtacaEmOrdemAlternada();
        
        Saint misty = new SilverSaint("Misty", "Lagarto");       
        Saint ikki = new BronzeSaint("Ikki", "Fênix");       
        Saint algol = new SilverSaint("Algol", "Perseu");        
        
        impostores.alistar(new SilverSaint("Misty", "Lagarto"));       
        impostores.alistar(new BronzeSaint("Ikki", "Fênix"));      
        impostores.alistar(new SilverSaint("Algol", "Perseu"));
        
                        
        assertEquals(ikki, impostores.proximoSaint());        
        assertEquals(misty ,impostores.proximoSaint());
        assertEquals(algol,impostores.proximoSaint());


    }
    
    @Test
    public void exercitoNulo () throws Exception {
        ExercitoDeSaints impostores = new ExercitoQueAtacaEmOrdemAlternada();
        assertNull(impostores.proximoSaint());
    }

}