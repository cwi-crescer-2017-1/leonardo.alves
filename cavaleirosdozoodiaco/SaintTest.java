

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.security.InvalidParameterException;
public class SaintTest{
    @Test
    public void vestirArmaduraDeixaArmaduraVestida ()  throws Exception {
    /* 
       1. Arrange - Montagem dos dados de teste
       2. Act - Invocar a ação a ser testada
       3. Assert - Verificação dos resultados de teste.
       */
      //1
      Armadura escorpiao = new Armadura(new Constelacao("Áries"), Categoria.OURO);
      Saint milo = new Saint("Milo", escorpiao);
      
      //2
      milo.vestirArmadura();
      
      //3
      boolean resultado = milo.getArmaduraVestida();
      assertEquals(true, resultado);
    }
    
    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida ()  throws Exception  {
        BronzeSaint hyoga = new BronzeSaint("Hyoga", new Armadura(new Constelacao("Áries"), Categoria.BRONZE));
        assertEquals(false, hyoga.getArmaduraVestida());
    }
    
    
    @Test 
    public void aoCriarGeneroENaoInformado()  throws Exception {
        Armadura churrumingas = new Armadura(new Constelacao("Áries"), Categoria.OURO);
        Genero genero;
        Saint shalon = new Saint("Shalon", churrumingas);
        assertEquals(Genero.NAO_INFORMADO, shalon.getGenero());
    }
    
    @Test
    public void ePossivelAlterarGenero ()  throws Exception  {
        BronzeSaint x = new BronzeSaint("Eximus", new Armadura(new Constelacao("Áries"), Categoria.BRONZE), Genero.NAO_INFORMADO);
        x.setGenero(Genero.FEMININO);
        assertEquals(Genero.FEMININO, x.getGenero());
    }
    
    @Test
    public void vidaInicialDeveSer100 ()  throws Exception  {
        BronzeSaint x = new BronzeSaint("Eximus", new Armadura(new Constelacao("Áries"), Categoria.BRONZE), Genero.NAO_INFORMADO);
        assertEquals(100, x.getVida(), 0.1);
    }
    
    @Test
    public void saintNasceVivo ()  throws Exception  {
        Saint jackieChan = new Saint ("Jackie", new Armadura(new Constelacao("Áries"), Categoria.OURO), Genero.MASCULINO);
        assertEquals(Status.VIVO, jackieChan.getStatus());
    }
    
    @Test
    public void estaSaintPerdendoVida ()  throws Exception  {
        Saint jackieChan = new Saint ("Jackie", new Armadura(new Constelacao("Áries"), Categoria.OURO), Genero.MASCULINO);
        jackieChan.perderVida(10);
        assertEquals(90, jackieChan.getVida(), 0.1);
    }
    
    @Test
    public void criarSaintNasceCom5SentidosDespertados ()  throws Exception  {
        BronzeSaint jackieChan = new BronzeSaint ("Jackie", new Armadura(new Constelacao("Áries"), Categoria.BRONZE));
        assertEquals(5, jackieChan.getSentidosDespertados());
    }
    
    @Test
    public void saintBronzeTem5Sentidos ()  throws Exception  {
         BronzeSaint jackieChan = new BronzeSaint ("Jackie", new Armadura(new Constelacao("Áries"), Categoria.BRONZE));
         assertEquals(5, jackieChan.getSentidosDespertados());
    }
    
    @Test
    public void saintPrataTem6Sentidos () throws Exception  {
        SilverSaint jackieChan = new SilverSaint ("Jackie", new Armadura(new Constelacao("Áries"), Categoria.PRATA));
        assertEquals(6, jackieChan.getSentidosDespertados());
    }
    

    @Test
    public void saintOuroTem7Sentidos ()  throws Exception  {
         GoldSaint jackieChan = new GoldSaint ("Jackie", new Armadura(new Constelacao("Áries"), Categoria.OURO));
         assertEquals(7, jackieChan.getSentidosDespertados());
    }
    
    @Test(expected=Exception.class)
    public void constelacaoInvalidaDeOuroDeveLancarErro () throws Exception {
        GoldSaint jackieChan = new GoldSaint ("Jackie", new Armadura(new Constelacao("Café"), Categoria.OURO));
    }
    
    @Test(expected=InvalidParameterException.class)
    public void saintRecebeDanoNegativo () throws Exception{
         GoldSaint jackieChan = new GoldSaint ("Jackie", new Armadura(new Constelacao("Áries"), Categoria.OURO));
         jackieChan.perderVida(-30);
    }  
    
    @Test
    public void saintMorre ()  throws Exception  {
        Saint tesourinha = new Saint ("Tesourinha", new Armadura(new Constelacao("Áries"), Categoria.OURO));
        tesourinha.perderVida(101);
        assertEquals(Status.MORTO, tesourinha.getStatus());
    }
    
    @Test
    public void getGolpesRetornaTodosOsGolpesDaConstelacao () throws Exception {
        GoldSaint jackieChan = new GoldSaint ("Jackie", new Armadura(new Constelacao("Áries"), Categoria.OURO));
        Golpe socao = new Golpe("Socão", 7);
        Golpe socao2 = new Golpe("Socão2", 7);
        Golpe socao3 = new Golpe("Socão3", 7);
        jackieChan.getArmadura().getConstelacao().adicionarGolpe(socao);
        jackieChan.getArmadura().getConstelacao().adicionarGolpe(socao2);
        jackieChan.getArmadura().getConstelacao().adicionarGolpe(socao3);
        Constelacao constelacao = new Constelacao("Zumba");
        constelacao.adicionarGolpe(socao);
        constelacao.adicionarGolpe(socao2);
        constelacao.adicionarGolpe(socao3);
        assertEquals(constelacao.getGolpes(), jackieChan.getGolpes());
    }
    
    @Test
    public void saintAprendeGolpe () throws Exception {
        GoldSaint jackieChan = new GoldSaint ("Jackie", new Armadura(new Constelacao("Áries"), Categoria.OURO));
        Golpe socao = new Golpe("Socão", 7);
        jackieChan.aprenderGolpe(socao);
        assertEquals(socao, jackieChan.getArmadura().getConstelacao().getGolpes()[0]);
    }
    
    @Test
    public void saintAprendeOutroGolpe () throws Exception {
        GoldSaint jackieChan = new GoldSaint ("Jackie", new Armadura(new Constelacao("Áries"), Categoria.OURO));
        Golpe socao = new Golpe("Socão", 7);
        Golpe socao2 = new Golpe("Socão", 7);
        jackieChan.aprenderGolpe(socao);
        jackieChan.aprenderGolpe(socao2);
        assertEquals(socao2, jackieChan.getArmadura().getConstelacao().getGolpes()[1]);
    }
    
    
    @Test
    public void saintAtacaComGolpesDiferentes () throws Exception {
        GoldSaint jackieChan = new GoldSaint ("Jackie", new Armadura(new Constelacao("Áries"), Categoria.OURO));
        Golpe socao = new Golpe("Socão", 7);
        Golpe socao2 = new Golpe("Socão2", 7);
        Golpe socao3 = new Golpe("Socão3", 7);
        jackieChan.aprenderGolpe(socao);
        jackieChan.aprenderGolpe(socao2);
        jackieChan.aprenderGolpe(socao3);
        
        assertEquals(socao, jackieChan.getProximoGolpe());
        assertEquals(socao2, jackieChan.getProximoGolpe());
        assertEquals(socao3, jackieChan.getProximoGolpe());
        assertEquals(socao, jackieChan.getProximoGolpe());
        
    }
    
    
}
