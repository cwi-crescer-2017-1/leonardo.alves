import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GolpearTest {
    @Test 
    public void golpearBronzeSemArmaduraVestida() throws Exception {
        Saint saintTest = new BronzeSaint("Shyriu", "Áries");
        Saint saintTest2 = new BronzeSaint("Shyriu", "Áries");
        Golpe golpe = new Golpe("Paulada", 10);
        saintTest.aprenderGolpe(golpe);
        Movimento golpear = new Golpear(saintTest, saintTest2);
        golpear.executar();

        assertEquals(100,saintTest.getVida(), 0.01);
        assertEquals(90,saintTest2.getVida(), 0.01);
    }    
    
     @Test 
    public void golpearSilverSemArmaduraVestida() throws Exception {
        Saint saintTest = new SilverSaint("Shyriu", "Áries");
        Saint saintTest2 = new BronzeSaint("Shyriu", "Áries");
        Golpe golpe = new Golpe("Paulada", 10);
        saintTest.aprenderGolpe(golpe);
        Movimento golpear = new Golpear(saintTest, saintTest2);
        golpear.executar();

        assertEquals(100,saintTest.getVida(), 0.01);
        assertEquals(90,saintTest2.getVida(), 0.01);
    }    
    
     @Test 
    public void golpearGoldSemArmaduraVestida() throws Exception {
        Saint saintTest = new GoldSaint("Shyriu", "Áries");
        Saint saintTest2 = new BronzeSaint("Shyriu", "Áries");
        Golpe golpe = new Golpe("Paulada", 10);
        saintTest.aprenderGolpe(golpe);
        Movimento golpear = new Golpear(saintTest, saintTest2);
        golpear.executar();

        assertEquals(100,saintTest.getVida(), 0.01);
        assertEquals(90,saintTest2.getVida(), 0.01);
    }    

    @Test
    public void bronzeSaintGolpearComArmaduraMultiplicaPor2 () throws Exception {
        Saint saintTest = new BronzeSaint("Shyriu", "Áries");
        Saint saintTest2 = new BronzeSaint("Shyriu", "Áries");
        Golpe golpe = new Golpe("Paulada", 10);
        saintTest.vestirArmadura();
        saintTest.aprenderGolpe(golpe);
        Movimento golpear = new Golpear(saintTest, saintTest2);
        golpear.executar();

        assertEquals(100,saintTest.getVida(), 0.01);
        assertEquals(80,saintTest2.getVida(), 0.01);
    }

    @Test
    public void silverSaintGolpearComArmaduraMultiplicaPor3 () throws Exception {
        Saint saintTest = new SilverSaint("Shyriu", "Áries");
        Saint saintTest2 = new BronzeSaint("Shyriu", "Áries");
        Golpe golpe = new Golpe("Paulada", 10);
        saintTest.vestirArmadura();
        saintTest.aprenderGolpe(golpe);
        Movimento golpear = new Golpear(saintTest, saintTest2);
        golpear.executar();

        assertEquals(100,saintTest.getVida(), 0.01);
        assertEquals(70,saintTest2.getVida(), 0.01);
    }

    @Test
    public void goldSaintGolpearComArmaduraMultiplicaPor4 () throws Exception {
        Saint saintTest = new GoldSaint("Shyriu", "Áries");
        Saint saintTest2 = new BronzeSaint("Shyriu", "Áries");
        Golpe golpe = new Golpe("Paulada", 10);
        saintTest.vestirArmadura();
        saintTest.aprenderGolpe(golpe);
        Golpear golpear = new Golpear(saintTest, saintTest2);
        golpear.executar();

        assertEquals(100,saintTest.getVida(), 0.01);
        assertEquals(60,saintTest2.getVida(), 0.01);
    }
}