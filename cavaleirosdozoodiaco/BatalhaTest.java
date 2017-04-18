
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.
junit.Test;

public class BatalhaTest {
    @Test
    public void categoriaIgualPerdeVidaSaint2 ()  throws Exception  {
         Saint zeDoCaixao = new Saint ("Zé do Caixão", new Armadura(new Constelacao("Áries"), Categoria.BRONZE));
         Saint missPurpurina = new Saint("Miss Purpurina", new Armadura(new Constelacao("Áries"), Categoria.BRONZE));
         Batalha zeVsPurpurina = new Batalha(zeDoCaixao, missPurpurina);
         zeVsPurpurina.iniciar();
         assertEquals(90, missPurpurina.getVida(), 0.1);
         assertEquals(100, zeDoCaixao.getVida(), 0.1);
    }
    
    
    @Test 
    public void categoriaMenorPerdeVida ()  throws Exception  {
        Saint tesourinha = new Saint ("Tesourinha", new Armadura(new Constelacao("Áries"), Categoria.OURO));
        Saint yoloMan = new Saint("Vida Loca Jr.", new Armadura(new Constelacao("Áries"), Categoria.BRONZE));
        Batalha tesourinhaVsYolo = new Batalha(yoloMan, tesourinha);
        tesourinhaVsYolo.iniciar();
        assertEquals(90, yoloMan.getVida(), 0.1);
        assertEquals(100, tesourinha.getVida(), 0.1);
    }
    
    /*@Test
    public void saintFicaDesacordado () {
        Saint tesourinha = new Saint ("Tesourinha", new Armadura("Afiadinus", Categoria.OURO));
        tesourinha.perderVida(100);
        assertEquals(Status.DESACORDADO, tesourinha.getStatus());
    }*/
    
    @Test
    public void saintMorre ()  throws Exception  {
        Saint tesourinha = new Saint ("Tesourinha", new Armadura("Áries", Categoria.OURO));
        tesourinha.perderVida(101);
        assertEquals(Status.MORTO, tesourinha.getStatus());
    }
    
}