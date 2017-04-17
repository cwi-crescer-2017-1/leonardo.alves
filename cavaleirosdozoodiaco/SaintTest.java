

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SaintTest{
    @Test
    public void vestirArmaduraDeixaArmaduraVestida () {
    /* 
       1. Arrange - Montagem dos dados de teste
       2. Act - Invocar a ação a ser testada
       3. Assert - Verificação dos resultados de teste.
       */
      //1
      Armadura escorpiao = new Armadura("Escorpião", Categoria.OURO);
      Saint milo = new Saint("Milo", escorpiao);
      
      //2
      milo.vestirArmadura();
      
      //3
      boolean resultado = milo.getArmaduraVestida();
      assertEquals(true, resultado);
    }
    
    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida () {
        Saint hyoga = new Saint("Hyoga", new Armadura("cisne", Categoria.BRONZE));
        assertEquals(false, hyoga.getArmaduraVestida());
    }
    
    
    @Test 
    public void aoCriarGeneroENaoInformado(){
        Armadura churrumingas = new Armadura("Churrumingas", Categoria.OURO);
        Genero genero;
        Saint shalon = new Saint("Shalon", churrumingas);
        assertEquals(Genero.NAO_INFORMADO, shalon.getGenero());
    }
    
    @Test
    public void ePossivelAlterarGenero () {
        Saint x = new Saint("Eximus", new Armadura("xis", Categoria.BRONZE), Genero.NAO_INFORMADO);
        x.setGenero(Genero.FEMININO);
        assertEquals(Genero.FEMININO, x.getGenero());
    }
    
    @Test
    public void vidaInicialDeveSer100 () {
        Saint x = new Saint("Eximus", new Armadura("xis", Categoria.BRONZE), Genero.NAO_INFORMADO);
        assertEquals(100, x.getVida(), 0.1);
    }
    
    @Test
    public void saintNasceVivo () {
        Saint jackieChan = new Saint ("Jackie", new Armadura("Ásia", Categoria.OURO), Genero.MASCULINO);
        assertEquals(Status.VIVO, jackieChan.getStatus());
    }
    
    @Test
    public void estaSaintPerdendoVida () {
        Saint jackieChan = new Saint ("Jackie", new Armadura("Ásia", Categoria.OURO), Genero.MASCULINO);
        jackieChan.perderVida(10);
        assertEquals(90, jackieChan.getVida(), 0.1);
    }
    
}
