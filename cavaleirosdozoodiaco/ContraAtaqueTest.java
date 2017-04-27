import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ContraAtaqueTest {
    @Test
    public void verificarSeContraAtaqueNaoPerdeVida () throws Exception{
           Saint seiya = new BronzeSaint("Seiya", "Pégaso");
           Saint seiya2 = new BronzeSaint("Seiya", "Pégaso");
           seiya.aprenderGolpe(new Golpe("soco", 10));
           seiya2.perderVida(60);
           Movimento golpe = new Golpear(seiya, seiya2);
           Movimento defender = new ContraAtaque(seiya, seiya2, new DadoFalso(2));
           
           seiya2.adicionarMovimento(defender);
           seiya.adicionarMovimento(golpe);
           
           seiya2.getProximoMovimento().executar();
           seiya.getProximoMovimento().executar();
           
           assertEquals(40, seiya2.getVida(), 0.01);
           assertEquals(75, seiya.getVida(), 0.01);
    }    
    
    @Test
    public void verificarSeContraAtaqueFalhoPerdeVida () throws Exception {
       Saint seiya = new BronzeSaint("Seiya", "Pégaso");
       Saint seiya2 = new BronzeSaint("Seiya", "Pégaso");
       seiya.aprenderGolpe(new Golpe("soco", 10));           
       Movimento golpe = new Golpear(seiya, seiya2);
       Movimento defender = new ContraAtaque(seiya, seiya2);
       
       seiya2.adicionarMovimento(defender);
       seiya.adicionarMovimento(golpe);
       
       seiya2.getProximoMovimento().executar();
       seiya.getProximoMovimento().executar();
       
       assertEquals(90, seiya2.getVida(), 0.01);
       assertEquals(100, seiya.getVida(), 0.01);
    }
    
    @Test (expected=NullPointerException.class)
    public void contraAtaqueComSaintNuloDefensor () throws Exception {
       Saint seiya = new BronzeSaint("Seiya", "Pégaso");
       Saint seiya2 = null;
       seiya.aprenderGolpe(new Golpe("soco", 10));           
       Movimento golpe = new Golpear(seiya, seiya2);
       Movimento defender = new ContraAtaque(seiya, seiya2);
       
       seiya2.adicionarMovimento(defender);
       seiya.adicionarMovimento(golpe);
       
       seiya2.getProximoMovimento().executar();
       seiya.getProximoMovimento().executar();   
    }
    
    @Test (expected=NullPointerException.class)
    public void contraAtaqueComSaintNuloAtacante () throws Exception {
       Saint seiya = null;
       Saint seiya2 = new BronzeSaint("Seiya", "Pégaso");
       seiya.aprenderGolpe(new Golpe("soco", 10));           
       Movimento golpe = new Golpear(seiya, seiya2);
       Movimento defender = new ContraAtaque(seiya, seiya2);
       
       seiya2.adicionarMovimento(defender);
       seiya.adicionarMovimento(golpe);
       
       seiya2.getProximoMovimento().executar();
       seiya.getProximoMovimento().executar();   
    }
    
    @Test
    public void verificarSeSaintComVidaSuperiorA40NaoContraAtaca () throws Exception{
           Saint seiya = new BronzeSaint("Seiya", "Pégaso");
           Saint seiya2 = new BronzeSaint("Seiya", "Pégaso");
           seiya.aprenderGolpe(new Golpe("soco", 10));           
           Movimento golpe = new Golpear(seiya, seiya2);
           Movimento defender = new ContraAtaque(seiya, seiya2, new DadoFalso(2));
           
           seiya2.adicionarMovimento(defender);
           seiya.adicionarMovimento(golpe);
           
           seiya2.getProximoMovimento().executar();
           seiya.getProximoMovimento().executar();
           
           assertEquals(90, seiya2.getVida(), 0.01);
           assertEquals(100, seiya.getVida(), 0.01);
    }  
    
    @Test
    public void verificarSeSaintComArmaduraNaoContraAtaca () throws Exception{
           Saint seiya = new BronzeSaint("Seiya", "Pégaso");
           Saint seiya2 = new BronzeSaint("Seiya", "Pégaso");
           seiya.aprenderGolpe(new Golpe("soco", 10));
           seiya2.vestirArmadura();
           Movimento golpe = new Golpear(seiya, seiya2);
           Movimento defender = new ContraAtaque(seiya, seiya2, new DadoFalso(2));
           
           seiya2.adicionarMovimento(defender);
           seiya.adicionarMovimento(golpe);
           
           seiya2.getProximoMovimento().executar();
           seiya.getProximoMovimento().executar();
           
           assertEquals(90, seiya2.getVida(), 0.01);
           assertEquals(100, seiya.getVida(), 0.01);
    }  
    
    @Test (expected = NullPointerException.class)
    public void verificarContraAtaqueContraGolpeNulo () throws Exception{
           Saint seiya = new BronzeSaint("Seiya", "Pégaso");
           Saint seiya2 = new BronzeSaint("Seiya", "Pégaso");
           seiya.aprenderGolpe(new Golpe("soco", 10));
           seiya2.perderVida(60);
           Movimento golpe = null;
           Movimento defender = new ContraAtaque(seiya, seiya2, new DadoFalso(2));
           
           seiya2.adicionarMovimento(defender);
           seiya.adicionarMovimento(golpe);
           
           seiya2.getProximoMovimento().executar();
           seiya.getProximoMovimento().executar();
           
           assertEquals(90, seiya2.getVida(), 0.01);
           assertEquals(100, seiya.getVida(), 0.01);                      
    }  
    
}