
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

        Saint milo = new GoldSaint("Milo", "Escorpião");

        //2
        milo.vestirArmadura();

        //3
        boolean resultado = milo.getArmaduraVestida();
        assertEquals(true, resultado);
    }

    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida ()  throws Exception  {
        BronzeSaint hyoga = new BronzeSaint("Hyoga", "Áries");
        System.out.println(hyoga.getId());
        assertEquals(false, hyoga.getArmaduraVestida());
    }

    @Test 
    public void aoCriarGeneroENaoInformado()  throws Exception {     
        Saint shalon = new BronzeSaint("Shalon", "Áries");
        assertEquals(Genero.NAO_INFORMADO, shalon.getGenero());
    }

    @Test
    public void ePossivelAlterarGenero ()  throws Exception  {
        BronzeSaint x = new BronzeSaint("Eximus", "Áries");
        x.setGenero(Genero.FEMININO);
        assertEquals(Genero.FEMININO, x.getGenero());
    }

    @Test
    public void vidaInicialDeveSer100 ()  throws Exception  {
        BronzeSaint x = new BronzeSaint("Eximus", "Áries");
        assertEquals(100, x.getVida(), 0.1);
    }

    @Test
    public void saintNasceVivo ()  throws Exception  {
        Saint jackieChan = new BronzeSaint ("Jackie", "Áries");
        assertEquals(Status.VIVO, jackieChan.getStatus());
    }

    @Test
    public void estaSaintPerdendoVida ()  throws Exception  {
        Saint jackieChan = new BronzeSaint ("Jackie", "Áries");
        jackieChan.perderVida(10);
        assertEquals(90, jackieChan.getVida(), 0.1);
    }

    @Test
    public void criarSaintNasceCom5SentidosDespertados ()  throws Exception  {
        BronzeSaint jackieChan = new BronzeSaint ("Jackie", "Áries");
        assertEquals(5, jackieChan.getSentidosDespertados());
    }

    @Test
    public void saintBronzeTem5Sentidos ()  throws Exception  {
        BronzeSaint jackieChan = new BronzeSaint ("Jackie", "Áries");
        assertEquals(5, jackieChan.getSentidosDespertados());
    }

    @Test
    public void saintPrataTem6Sentidos () throws Exception  {
        SilverSaint jackieChan = new SilverSaint ("Jackie", "Áries");
        assertEquals(6, jackieChan.getSentidosDespertados());
    }

    @Test
    public void saintOuroTem7Sentidos ()  throws Exception  {
        GoldSaint jackieChan = new GoldSaint ("Jackie", "Áries");
        assertEquals(7, jackieChan.getSentidosDespertados());
    }

    @Test(expected=Exception.class)
    public void constelacaoInvalidaDeOuroDeveLancarErro () throws Exception {
        GoldSaint jackieChan = new GoldSaint ("Jackie", "Batata");
    }

    @Test(expected=InvalidParameterException.class)
    public void saintRecebeDanoNegativo () throws Exception{
        GoldSaint jackieChan = new GoldSaint ("Jackie", "Áries");
        jackieChan.perderVida(-30);
    }  

    @Test
    public void saintMorre ()  throws Exception  {
        Saint tesourinha = new BronzeSaint ("Tesourinha", "Áries");
        tesourinha.perderVida(101);
        assertEquals(Status.MORTO, tesourinha.getStatus());
    }

    @Test
    public void getGolpesRetornaTodosOsGolpesDaConstelacao () throws Exception {
        GoldSaint jackieChan = new GoldSaint ("Jackie", "Áries");
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
        GoldSaint jackieChan = new GoldSaint ("Jackie", "Áries");
        Golpe socao = new Golpe("Socão", 7);
        jackieChan.aprenderGolpe(socao);
        assertEquals(socao, jackieChan.getArmadura().getConstelacao().getGolpes().get(0));
        assertEquals(1, jackieChan.getArmadura().getConstelacao().getGolpes().size());
    }

    @Test
    public void saintAprendeOutroGolpe () throws Exception {
        GoldSaint jackieChan = new GoldSaint ("Jackie", "Áries");
        Golpe socao = new Golpe("Socão", 7);
        Golpe socao2 = new Golpe("Socão", 7);
        jackieChan.aprenderGolpe(socao);
        jackieChan.aprenderGolpe(socao2);
        assertEquals(socao2, jackieChan.getArmadura().getConstelacao().getGolpes().get(1));
        assertEquals(2, jackieChan.getArmadura().getConstelacao().getGolpes().size());
    }

    @Test
    public void saintAprendeVariosGolpes () throws Exception {
        GoldSaint jackieChan = new GoldSaint ("Jackie", "Áries");
        Golpe socao = new Golpe("Socão", 7);
        Golpe socao2 = new Golpe("Socão2", 7);
        Golpe socao3 = new Golpe("Socão3", 7);
        Golpe socao4 = new Golpe("Socão4", 7);
        Golpe socao5 = new Golpe("Socão5", 7);
        Golpe socao6 = new Golpe("Socão6", 7);
        jackieChan.aprenderGolpe(socao);
        jackieChan.aprenderGolpe(socao2);
        jackieChan.aprenderGolpe(socao3);
        jackieChan.aprenderGolpe(socao4);
        jackieChan.aprenderGolpe(socao5);
        jackieChan.aprenderGolpe(socao6);
        assertEquals(socao, jackieChan.getArmadura().getConstelacao().getGolpes().get(0));
        assertEquals(socao2, jackieChan.getArmadura().getConstelacao().getGolpes().get(1));
        assertEquals(socao3, jackieChan.getArmadura().getConstelacao().getGolpes().get(2));
        assertEquals(socao4, jackieChan.getArmadura().getConstelacao().getGolpes().get(3));
        assertEquals(socao5, jackieChan.getArmadura().getConstelacao().getGolpes().get(4));
        assertEquals(socao6, jackieChan.getArmadura().getConstelacao().getGolpes().get(5));
        assertEquals(6, jackieChan.getArmadura().getConstelacao().getGolpes().size());
    }

    @Test
    public void saintAtacaComGolpesDiferentes () throws Exception {
        GoldSaint jackieChan = new GoldSaint ("Jackie", "Áries");
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

    @Test
    public void saintTrocaDeMovimentos () throws Exception {
        GoldSaint jackieChan = new GoldSaint ("Jackie", "Áries");
        SilverSaint jackLee = new SilverSaint ("Jack lee", "Áries");
        Golpe socao = new Golpe("Socão", 7);
        Golpe socao2 = new Golpe("Socão2", 7);
        Golpe socao3 = new Golpe("Socão3", 7);
        jackieChan.aprenderGolpe(socao);
        jackieChan.aprenderGolpe(socao2);
        jackieChan.aprenderGolpe(socao3);
        Golpear golpearTRUM = new Golpear(jackieChan, jackLee);
        VestirArmadura vestir = new VestirArmadura(jackieChan);

        jackieChan.adicionarMovimento(golpearTRUM);
        jackieChan.adicionarMovimento(vestir);
        Movimento primeiro =  jackieChan.getProximoMovimento();       
        assertEquals(golpearTRUM, primeiro);
        Movimento segundo = jackieChan.getProximoMovimento();
        assertEquals(vestir, segundo);   
        Movimento primeiroDeNovo = jackieChan.getProximoMovimento();
        assertEquals(golpearTRUM, primeiroDeNovo);
    }
    
    @Test 
    public void golpearNoSaintAdicionaOMovimento () throws Exception {
    Saint jackieChan = new GoldSaint ("Jackie", "Áries");
    Saint jackLee = new SilverSaint ("Jack lee", "Áries");
    Golpe xgolpe = new Golpe("Pow", 10);
    jackieChan.aprenderGolpe(xgolpe);
    Golpear golpe = new Golpear(jackieChan, jackLee);
    
    
    jackieChan.golpear(jackLee);
    assertTrue(golpe.equals(jackieChan.getProximoMovimento()));
    }

    @Test
    public void verificarQuantidadeDeSaintsAposAdicionar1 () throws Exception {
        int  saintsIniciais = Saint.getQtdSaints();
        Saint seyia = new SilverSaint("Seyia", "jaa");
        assertEquals(saintsIniciais + 1, Saint.getQtdSaints());
    }
    
    @Test
    public void verificarQuantidadeDeSaintsAposAdicionar4 () throws Exception {
        int  saintsIniciais = Saint.getQtdSaints();
        Saint seyia = new SilverSaint("Seyia", "Pégaso");
        assertEquals(saintsIniciais + 1, Saint.getQtdSaints());
        Saint shiryu = new SilverSaint("Shiryu", "Dragão");
        assertEquals(saintsIniciais + 2, Saint.getQtdSaints());
        Saint hyoga = new SilverSaint("Hyoga", "Cisne");
        assertEquals(saintsIniciais + 3, Saint.getQtdSaints());
        Saint ikki = new SilverSaint("Ikki", "Fênix");
        assertEquals(saintsIniciais + 4, Saint.getQtdSaints());
    }
    
    @Test
    public void getIdDoSaint () throws Exception {
        
        Saint seyia = new BronzeSaint("Seyia", "Pégaso");
        int  saintsIniciais = Saint.getQtdSaints();
        Saint shiryu = new SilverSaint("Shiryu", "Dragão"); //1
        Saint hyoga = new SilverSaint("Hyoga", "Cisne");    //2
        Saint shun = new SilverSaint("Shun", "Andrômeda");  //3
        Saint ikki = new SilverSaint("Ikki", "Fênix");
        
        assertEquals(saintsIniciais+3, shun.getId());
    
    }    
}