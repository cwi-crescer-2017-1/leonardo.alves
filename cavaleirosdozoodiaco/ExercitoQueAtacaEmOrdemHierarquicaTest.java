import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExercitoQueAtacaEmOrdemHierarquicaTest {
    @Test
    public void exercitoAtacaEmOrderHierarquica () throws Exception{
        ExercitoDeSaints defensoresDeAthena = new ExercitoQueAtacaEmOrdemHierarquica();
        Saint hyoga = new BronzeSaint("Hyoga","Cisne");
        Saint marin = new SilverSaint("Marin", "Águia");
        Saint aiolia = new GoldSaint("Aiolia", "Leão");        
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        Saint shura = new GoldSaint("Shura", "Capricórnio");
        defensoresDeAthena.alistar(new GoldSaint("Aiolia", "Leão"));
        defensoresDeAthena.alistar(new BronzeSaint("Hyoga", "Cisne"));
        defensoresDeAthena.alistar(new SilverSaint("Marin", "Águia"));
        defensoresDeAthena.alistar(new BronzeSaint("Seiya", "Pégaso"));
        defensoresDeAthena.alistar(new GoldSaint("Shura", "Capricórnio"));
        defensoresDeAthena.alistar(new BronzeSaint("Shiryu", "Dragão"));
        
        assertEquals(hyoga, defensoresDeAthena.proximoSaint());        
        assertEquals(seiya ,defensoresDeAthena.proximoSaint());
        assertEquals(shiryu ,defensoresDeAthena.proximoSaint());
        assertEquals(marin ,defensoresDeAthena.proximoSaint());
        assertEquals(aiolia ,defensoresDeAthena.proximoSaint());
        assertEquals(shura ,defensoresDeAthena.proximoSaint());
        
    }
    
    @Test
    public void exercitoSemBronze () throws Exception {
         ExercitoDeSaints defensoresDeAthena = new ExercitoQueAtacaEmOrdemHierarquica();
        
        Saint marin = new SilverSaint("Marin", "Águia");
        Saint aiolia = new GoldSaint("Aiolia", "Leão");     
        Saint shura = new GoldSaint("Shura", "Capricórnio");
        
        defensoresDeAthena.alistar(new GoldSaint("Aiolia", "Leão"));        
        defensoresDeAthena.alistar(new SilverSaint("Marin", "Águia"));        
        defensoresDeAthena.alistar(new GoldSaint("Shura", "Capricórnio"));        
       
        assertEquals(marin ,defensoresDeAthena.proximoSaint());
        assertEquals(aiolia ,defensoresDeAthena.proximoSaint());
        assertEquals(shura ,defensoresDeAthena.proximoSaint());
    
    }
    
    @Test
    public void exercitoSemPrata() throws Exception {
         ExercitoDeSaints defensoresDeAthena = new ExercitoQueAtacaEmOrdemHierarquica();
        Saint hyoga = new BronzeSaint("Hyoga","Cisne");        
        Saint aiolia = new GoldSaint("Aiolia", "Leão");        
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        Saint shura = new GoldSaint("Shura", "Capricórnio");
        
        defensoresDeAthena.alistar(new GoldSaint("Aiolia", "Leão"));
        defensoresDeAthena.alistar(new BronzeSaint("Hyoga", "Cisne"));       
        defensoresDeAthena.alistar(new BronzeSaint("Seiya", "Pégaso"));
        defensoresDeAthena.alistar(new GoldSaint("Shura", "Capricórnio"));
        defensoresDeAthena.alistar(new BronzeSaint("Shiryu", "Dragão"));
        
        assertEquals(hyoga, defensoresDeAthena.proximoSaint());        
        assertEquals(seiya ,defensoresDeAthena.proximoSaint());
        assertEquals(shiryu ,defensoresDeAthena.proximoSaint());        
        assertEquals(aiolia ,defensoresDeAthena.proximoSaint());
        assertEquals(shura ,defensoresDeAthena.proximoSaint());
    }
    
    @Test
    public void exercitoSemOuro () throws Exception {
         ExercitoDeSaints defensoresDeAthena = new ExercitoQueAtacaEmOrdemHierarquica();
        Saint hyoga = new BronzeSaint("Hyoga","Cisne");
        Saint marin = new SilverSaint("Marin", "Águia");               
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        
        
        defensoresDeAthena.alistar(new BronzeSaint("Hyoga", "Cisne"));
        defensoresDeAthena.alistar(new SilverSaint("Marin", "Águia"));
        defensoresDeAthena.alistar(new BronzeSaint("Seiya", "Pégaso"));       
        defensoresDeAthena.alistar(new BronzeSaint("Shiryu", "Dragão"));
        
        assertEquals(hyoga, defensoresDeAthena.proximoSaint());        
        assertEquals(seiya ,defensoresDeAthena.proximoSaint());
        assertEquals(shiryu ,defensoresDeAthena.proximoSaint());
        assertEquals(marin ,defensoresDeAthena.proximoSaint());       
    }
    
    @Test
    public void exercitoHierarquicoNulo () throws Exception{
        ExercitoDeSaints defensoresDeAthena = new ExercitoQueAtacaEmOrdemHierarquica();       
        assertNull(defensoresDeAthena.proximoSaint());    
    }
    
}