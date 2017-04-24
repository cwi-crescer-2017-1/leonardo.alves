import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VestirArmaduraTest {
    @Test
    public void movimentoVestirArmaduraRealmenteFunciona () throws Exception {
        GoldSaint jackieChan = new GoldSaint ("Jackie", "Áries");
        Movimento vestirArmadura = new VestirArmadura(jackieChan);
        vestirArmadura.executar();
        assertTrue(jackieChan.getArmaduraVestida());
    }

    @Test
    public void naoVestirArmadura () throws Exception {
        GoldSaint jackieChan = new GoldSaint ("Jackie", "Áries");
        Movimento vestirArmadura = new VestirArmadura(jackieChan);        
        assertFalse(jackieChan.getArmaduraVestida());
    }
    
    @Test(expected=NullPointerException.class)
    public void vestirArmaduraComSaintNull () throws Exception {
        GoldSaint jackieChan = null;
        Movimento vestirArmadura = new VestirArmadura(jackieChan);        
        vestirArmadura.executar();
    }
}