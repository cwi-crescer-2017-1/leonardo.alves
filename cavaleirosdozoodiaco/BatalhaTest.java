
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.
junit.Test;

public class BatalhaTest {
    @Test
    public void categoriaIgualPerdeBatalhaSaint2 ()  throws Exception  {
        Golpe golpe = new Golpe("Paulada", 10);
        Saint zeDoCaixao = new BronzeSaint ("Zé do Caixão", "Áries");         
        Saint missPurpurina = new BronzeSaint("Miss Purpurina", "Áries");  

        missPurpurina.aprenderGolpe(golpe);
        zeDoCaixao.aprenderGolpe(golpe);

        Golpear golpear = new Golpear(zeDoCaixao, missPurpurina);
        Golpear golpear2 = new Golpear(missPurpurina, zeDoCaixao);

        zeDoCaixao.adicionarMovimento(golpear);
        missPurpurina.adicionarMovimento(golpear2);

        Batalha zeVsPurpurina = new Batalha(zeDoCaixao, missPurpurina);
        zeVsPurpurina.iniciar();
        assertEquals(0, missPurpurina.getVida(), 0.1);
        assertEquals(10, zeDoCaixao.getVida(), 0.1);
    }

    @Test 
    public void categoriaMenorPerdeBatalha ()  throws Exception  {
        Golpe golpe = new Golpe("Paulada", 10);
        Saint zeDoCaixao = new BronzeSaint ("Zé do Caixão", "Áries");         
        Saint missPurpurina = new SilverSaint("Miss Purpurina", "Áries");  

        missPurpurina.aprenderGolpe(golpe);
        zeDoCaixao.aprenderGolpe(golpe);

        Golpear golpear = new Golpear(zeDoCaixao, missPurpurina);
        Golpear golpear2 = new Golpear(missPurpurina, zeDoCaixao);

        zeDoCaixao.adicionarMovimento(golpear);
        missPurpurina.adicionarMovimento(golpear2);

        Batalha zeVsPurpurina = new Batalha(zeDoCaixao, missPurpurina);
        zeVsPurpurina.iniciar();
        assertEquals(10, missPurpurina.getVida(), 0.1);
        assertEquals(0, zeDoCaixao.getVida(), 0.1);
    }

    /*@Test
    public void saintFicaDesacordado () {
    Saint tesourinha = new BronzeSaint ("Tesourinha", new Armadura("Afiadinus", Categoria.OURO));
    tesourinha.perderVida(100);
    assertEquals(Status.DESACORDADO, tesourinha.getStatus());
    }*/

}