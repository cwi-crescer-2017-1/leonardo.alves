

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SaintTest{
    @Test
    public void vestirArmaduraDeixaArmaduraVestida ()  throws Exception {
    /* 
       1. Arrange - Montagem dos dados de teste
       2. Act - Invocar a ação a ser testada
       3. Assert - Verificação dos resultados de teste.
       */
      //1
      Armadura escorpiao = new Armadura("Áries", Categoria.OURO);
      Saint milo = new Saint("Milo", escorpiao);
      
      //2
      milo.vestirArmadura();
      
      //3
      boolean resultado = milo.getArmaduraVestida();
      assertEquals(true, resultado);
    }
    
    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida ()  throws Exception  {
        BronzeSaint hyoga = new BronzeSaint("Hyoga", new Armadura("cisne", Categoria.BRONZE));
        assertEquals(false, hyoga.getArmaduraVestida());
    }
    
    
    @Test 
    public void aoCriarGeneroENaoInformado()  throws Exception {
        Armadura churrumingas = new Armadura("Áries", Categoria.OURO);
        Genero genero;
        Saint shalon = new Saint("Shalon", churrumingas);
        assertEquals(Genero.NAO_INFORMADO, shalon.getGenero());
    }
    
    @Test
    public void ePossivelAlterarGenero ()  throws Exception  {
        BronzeSaint x = new BronzeSaint("Eximus", new Armadura("xis", Categoria.BRONZE), Genero.NAO_INFORMADO);
        x.setGenero(Genero.FEMININO);
        assertEquals(Genero.FEMININO, x.getGenero());
    }
    
    @Test
    public void vidaInicialDeveSer100 ()  throws Exception  {
        BronzeSaint x = new BronzeSaint("Eximus", new Armadura("xis", Categoria.BRONZE), Genero.NAO_INFORMADO);
        assertEquals(100, x.getVida(), 0.1);
    }
    
    @Test
    public void saintNasceVivo ()  throws Exception  {
        Saint jackieChan = new Saint ("Jackie", new Armadura("Áries", Categoria.OURO), Genero.MASCULINO);
        assertEquals(Status.VIVO, jackieChan.getStatus());
    }
    
    @Test
    public void estaSaintPerdendoVida ()  throws Exception  {
        Saint jackieChan = new Saint ("Jackie", new Armadura("Áries", Categoria.OURO), Genero.MASCULINO);
        jackieChan.perderVida(10);
        assertEquals(90, jackieChan.getVida(), 0.1);
    }
    
    @Test
    public void criarSaintNasceCom5SentidosDespertados ()  throws Exception  {
        BronzeSaint jackieChan = new BronzeSaint ("Jackie", new Armadura("Áries", Categoria.BRONZE));
        assertEquals(5, jackieChan.getSentidosDespertados());
    }
    
    @Test
    public void saintBronzeTem5Sentidos ()  throws Exception  {
         BronzeSaint jackieChan = new BronzeSaint ("Jackie", new Armadura("Ásia", Categoria.BRONZE));
         assertEquals(5, jackieChan.getSentidosDespertados());
    }
    
    @Test
    public void saintPrataTem6Sentidos () throws Exception  {
        SilverSaint jackieChan = new SilverSaint ("Jackie", new Armadura("Ásia", Categoria.PRATA));
        assertEquals(6, jackieChan.getSentidosDespertados());
    }
    

    @Test
    public void saintOuroTem7Sentidos ()  throws Exception  {
         GoldSaint jackieChan = new GoldSaint ("Jackie", new Armadura("Áries", Categoria.OURO));
         assertEquals(7, jackieChan.getSentidosDespertados());
    }
    
    @Test(expected=Exception.class)
    public void constelacaoInvalidaDeOuroDeveLancarErro () throws Exception {
        GoldSaint jackieChan = new GoldSaint ("Jackie", new Armadura("Café", Categoria.OURO));
    }
    
}
