
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
public class ListaSaintsTest {
    @Test
    public void adicionarSaint () throws Exception{
        ListaSaints saints = new ListaSaints();
        Saint saintTest = new BronzeSaint("Shyriu", "Áries");

        saints.adicionar(saintTest);

        assertEquals(saintTest, saints.get(0));
    }

    @Test
    public void pegarTodosSaints () throws Exception {
        ListaSaints saints = new ListaSaints();
        ArrayList<Saint> arrayTest = new ArrayList<> ();
        Saint saintTest = new BronzeSaint("Shyriu", "Áries");
        Saint saintTest2 = new BronzeSaint("Shyriu", "Áries");
        Saint saintTest3 = new BronzeSaint("Shyriu", "Áries");

        saints.adicionar(saintTest);
        saints.adicionar(saintTest2);
        saints.adicionar(saintTest3);
        arrayTest.add(saintTest);
        arrayTest.add(saintTest2);
        arrayTest.add(saintTest3);

        assertEquals(saints.todos(), arrayTest);
    }

    @Test
    public void removerSaint () throws Exception {
        ListaSaints saints = new ListaSaints();
        Saint saintTest = new BronzeSaint("Shyriu", "Áries");
        Saint saintTest2 = new BronzeSaint("Shyriu", "Áries");
        saints.adicionar(saintTest);
        saints.adicionar(saintTest2);

        saints.remover(saintTest);

        assertEquals(saints.todos().size(), 1);
    }

    @Test
    public void buscarSaintPorNome () throws Exception {
        ListaSaints saints = new ListaSaints();
        Saint saintTest = new BronzeSaint("Shyriu", "Áries");
        Saint saintTest2 = new BronzeSaint("Shalon", "Áries");
        saints.adicionar(saintTest);
        saints.adicionar(saintTest2);

        assertEquals(saints.buscarPorNome("Shyriu"), saints.get(0));
    }

    @Test
    public void buscarSaintComRepeticaoPorNome () throws Exception {
        ListaSaints saints = new ListaSaints();
        Saint saintTest = new BronzeSaint("Shyriu", "Áries");
        Saint saintTest2 = new BronzeSaint("Shalon", "Áries");
        Saint saintTest3 = new BronzeSaint("Shalon", "Áries");
        saints.adicionar(saintTest);
        saints.adicionar(saintTest2);
        saints.adicionar(saintTest3);

        assertEquals(saints.buscarPorNome("Shalon"), saints.get(1));
    }

    @Test
    public void buscarSaintInexistentePorNome () throws Exception {
        ListaSaints saints = new ListaSaints();
        Saint saintTest = new BronzeSaint("Shyriu", "Áries");
        Saint saintTest2 = new BronzeSaint("Shalon", "Áries");
        saints.adicionar(saintTest);
        saints.adicionar(saintTest2);

        assertNull(saints.buscarPorNome("Ximbas"));
    }

    @Test
    public void buscarSaintComListaVazia() throws Exception {
        ListaSaints saints = new ListaSaints();       

        assertNull(saints.buscarPorNome("Ximbas"));
    }

    
    @Test
    public void buscarSaintsPorCategoria () throws Exception {
        ListaSaints saints = new ListaSaints();
        ArrayList<Saint> arrayTest = new ArrayList<> ();
        Saint saintTest = new GoldSaint("Shyriu", "Áries");
        Saint saintTest2 = new BronzeSaint("Shalon", "Áries");
        Saint saintTest3 = new SilverSaint("Shalon", "Áries");
        Saint saintTest4 = new BronzeSaint("Shalon", "Áries");
        saints.adicionar(saintTest);
        saints.adicionar(saintTest2);
        saints.adicionar(saintTest3);
        saints.adicionar(saintTest4);
        arrayTest.add(saintTest2);
        arrayTest.add(saintTest4);        
        assertEquals(saints.buscarPorCategoria(Categoria.BRONZE), arrayTest);      
    }

    @Test
    public void buscarSaintsInexistentePorCategoria () throws Exception {
        ListaSaints saints = new ListaSaints();

        Saint saintTest = new BronzeSaint("Shyriu", "Áries");
        Saint saintTest2 = new BronzeSaint("Shalon", "Áries");
        Saint saintTest3 = new BronzeSaint("Shalon", "Áries");
        Saint saintTest4 = new BronzeSaint("Shalon", "Áries");
        saints.adicionar(saintTest);
        saints.adicionar(saintTest2);
        saints.adicionar(saintTest3);
        saints.adicionar(saintTest4);    
        ArrayList<Saint> arrayTest = saints.buscarPorCategoria(Categoria.OURO);
        assertEquals(0, arrayTest.size());

    }

    @Test
    public void buscarSaintsPorStatus () throws Exception {
        ListaSaints saints = new ListaSaints();
        ArrayList<Saint> arrayTest = new ArrayList<> ();
        Saint saintTest = new BronzeSaint("Shyriu", "Áries");
        Saint saintTest2 = new BronzeSaint("Shalon", "Áries");
        Saint saintTest3 = new BronzeSaint("Shalon", "Áries");
        Saint saintTest4 = new BronzeSaint("Shalon", "Áries");
        saintTest.perderVida(100);
        saintTest3.perderVida(100);
        saints.adicionar(saintTest);
        saints.adicionar(saintTest2);
        saints.adicionar(saintTest3);
        saints.adicionar(saintTest4);
        arrayTest.add(saintTest);
        arrayTest.add(saintTest3);

        assertEquals(saints.buscarPorStatus(Status.MORTO), arrayTest);

    }
    @Test
    public void pegarSaintMaiorVida () throws Exception {
        ListaSaints saints = new ListaSaints();

        Saint saintTest = new BronzeSaint("Shyriu", "Áries");
        Saint saintTest2 = new BronzeSaint("Shalon", "Áries");
        Saint saintTest3 = new BronzeSaint("Shalon", "Áries");
        Saint saintTest4 = new BronzeSaint("Shalon", "Áries");
        saintTest.perderVida(32);
        saintTest3.perderVida(74);
        saintTest2.perderVida(1);        
        saints.adicionar(saintTest);
        saints.adicionar(saintTest2);
        saints.adicionar(saintTest3);
        saints.adicionar(saintTest4);        

        assertEquals(saints.getSaintMaiorVida().getVida(), 100, 0.001);

    }
    @Test
    public void pegarSaintMaiorVidaSemLista () {
        ListaSaints saints = new ListaSaints();
        assertNull(saints.getSaintMaiorVida());
    }

    @Test
    public void pegarPrimeiroSaintMaiorVidaComMaisDeUmIgual () throws Exception {
        ListaSaints saints = new ListaSaints();

        Saint saintTest = new BronzeSaint("Shyriu", "Áries");
        Saint saintTest2 = new BronzeSaint("Xerere", "Áries");
        Saint saintTest3 = new BronzeSaint("Shalon", "Áries");
        Saint saintTest4 = new BronzeSaint("Shalon", "Áries");
        saintTest.perderVida(32);
        saintTest3.perderVida(74);
        saintTest2.perderVida(1);  
        saintTest4.perderVida(1);
        saints.adicionar(saintTest);
        saints.adicionar(saintTest2);
        saints.adicionar(saintTest3);
        saints.adicionar(saintTest4);        

        assertEquals(saints.getSaintMaiorVida().getNome(), "Xerere");        

    }

    @Test
    public void pegarSaintMenorVida () throws Exception {
        ListaSaints saints = new ListaSaints();

        Saint saintTest = new BronzeSaint("Shyriu", "Áries");
        Saint saintTest2 = new BronzeSaint("Shalon", "Áries");
        Saint saintTest3 = new BronzeSaint("Shalon", "Áries");
        Saint saintTest4 = new BronzeSaint("Shalon", "Áries");
        saintTest.perderVida(32);
        saintTest3.perderVida(74);
        saintTest2.perderVida(1);        
        saints.adicionar(saintTest);
        saints.adicionar(saintTest2);
        saints.adicionar(saintTest3);
        saints.adicionar(saintTest4);        

        assertEquals(saints.getSaintMenorVida().getVida(), 26, 0.001);

    }
    
    @Test
    public void pegarSaintMenorVidaSemLista () {
        ListaSaints saints = new ListaSaints();
        assertNull(saints.getSaintMenorVida());
    }

    @Test
    public void pegarPrimeiroSaintMenorVidaComMaisDeUmIgual () throws Exception {
        ListaSaints saints = new ListaSaints();

        Saint saintTest = new BronzeSaint("Shyriu", "Áries");
        Saint saintTest2 = new BronzeSaint("Ximbas", "Áries");
        Saint saintTest3 = new BronzeSaint("Shalon", "Áries");
        Saint saintTest4 = new BronzeSaint("Shalon", "Áries");
        saintTest.perderVida(32);
        saintTest3.perderVida(74);
        saintTest2.perderVida(99);
        saintTest4.perderVida(99);
        saints.adicionar(saintTest);
        saints.adicionar(saintTest2);
        saints.adicionar(saintTest3);
        saints.adicionar(saintTest4);        

        assertEquals(saints.getSaintMenorVida().getNome(), "Ximbas");

    }
    
    @Test
    public void ordenarSaints () throws Exception {
        ListaSaints saints = new ListaSaints();

        Saint saintTest = new BronzeSaint("Shyriu", "Áries");
        Saint saintTest2 = new BronzeSaint("Shalon", "Áries");
        Saint saintTest3 = new BronzeSaint("Shalon", "Áries");
        Saint saintTest4 = new BronzeSaint("Shalon", "Áries");
        saintTest.perderVida(99);
        saintTest2.perderVida(98);
        saintTest3.perderVida(97);   
        saintTest4.perderVida(10);
        saints.adicionar(saintTest);       
        saints.adicionar(saintTest2);
        saints.adicionar(saintTest3);
        saints.adicionar(saintTest4);        

        saints.ordenar();

        assertEquals(saints.get(0), saints.getSaintMenorVida());
        assertEquals(saints.get(3), saints.getSaintMaiorVida());
    }

    @Test
    public void ordenarSaintsJaOrdenados() throws Exception {
        ListaSaints saints = new ListaSaints();

        Saint saintTest = new BronzeSaint("Shyriu", "Áries");
        Saint saintTest2 = new BronzeSaint("Shalon", "Áries");
        Saint saintTest3 = new BronzeSaint("Shalon", "Áries");
        Saint saintTest4 = new BronzeSaint("Shalon", "Áries");
        saintTest.perderVida(40);
        saintTest2.perderVida(30);
        saintTest3.perderVida(20);   
        saintTest4.perderVida(10);
        saints.adicionar(saintTest);       
        saints.adicionar(saintTest2);
        saints.adicionar(saintTest3);
        saints.adicionar(saintTest4);        

        saints.ordenar();

        assertEquals(saints.get(0), saints.getSaintMenorVida());
        assertEquals(saints.get(3), saints.getSaintMaiorVida());
    }  

    @Test
    public void ordenarSaintsAscendentemente () throws Exception {
        ListaSaints saints = new ListaSaints();

        Saint saintTest = new BronzeSaint("Shyriu", "Áries");
        Saint saintTest2 = new BronzeSaint("Shalon", "Áries");
        Saint saintTest3 = new BronzeSaint("Shalon", "Áries");
        Saint saintTest4 = new BronzeSaint("Shalon", "Áries");
        saintTest.perderVida(99);
        saintTest2.perderVida(98);
        saintTest3.perderVida(97);   
        saintTest4.perderVida(10);
        saints.adicionar(saintTest);       
        saints.adicionar(saintTest2);
        saints.adicionar(saintTest3);
        saints.adicionar(saintTest4);        

        saints.ordenar(TipoOrdenacao.ASCENDENTE);

        assertEquals(saints.get(0), saints.getSaintMenorVida());
        assertEquals(saints.get(3), saints.getSaintMaiorVida());
    }

    @Test
    public void ordenarSaintsJaOrdenadosAscendentemente () throws Exception {
        ListaSaints saints = new ListaSaints();

        Saint saintTest = new BronzeSaint("Shyriu", "Áries");
        Saint saintTest2 = new BronzeSaint("Shalon", "Áries");
        Saint saintTest3 = new BronzeSaint("Shalon", "Áries");
        Saint saintTest4 = new BronzeSaint("Shalon", "Áries");
        saintTest.perderVida(40);
        saintTest2.perderVida(30);
        saintTest3.perderVida(20);   
        saintTest4.perderVida(10);
        saints.adicionar(saintTest);       
        saints.adicionar(saintTest2);
        saints.adicionar(saintTest3);
        saints.adicionar(saintTest4);        

        saints.ordenar(TipoOrdenacao.ASCENDENTE);

        assertEquals(saints.get(0), saints.getSaintMenorVida());
        assertEquals(saints.get(3), saints.getSaintMaiorVida());
    }  

    @Test
    public void ordenarSaintsDescendentemente () throws Exception {
        ListaSaints saints = new ListaSaints();

        Saint saintTest = new BronzeSaint("Shyriu", "Áries");
        Saint saintTest2 = new BronzeSaint("Shalon", "Áries");
        Saint saintTest3 = new BronzeSaint("Shalon", "Áries");
        Saint saintTest4 = new BronzeSaint("Shalon", "Áries");
        saintTest.perderVida(99);
        saintTest2.perderVida(98);
        saintTest3.perderVida(97);   
        saintTest4.perderVida(10);
        saints.adicionar(saintTest);       
        saints.adicionar(saintTest2);
        saints.adicionar(saintTest3);
        saints.adicionar(saintTest4);        

        saints.ordenar(TipoOrdenacao.DESCENDENTE);

        assertEquals(saints.get(3), saints.getSaintMenorVida());
        assertEquals(saints.get(0), saints.getSaintMaiorVida());
    }

    @Test
    public void ordenarSaintsJaOrdenadosDescendentemente () throws Exception {
        ListaSaints saints = new ListaSaints();

        Saint saintTest = new BronzeSaint("Shyriu", "Áries");
        Saint saintTest2 = new BronzeSaint("Shalon", "Áries");
        Saint saintTest3 = new BronzeSaint("Shalon", "Áries");
        Saint saintTest4 = new BronzeSaint("Shalon", "Áries");
        saintTest.perderVida(40);
        saintTest2.perderVida(30);
        saintTest3.perderVida(20);   
        saintTest4.perderVida(10);
        saints.adicionar(saintTest);       
        saints.adicionar(saintTest2);
        saints.adicionar(saintTest3);
        saints.adicionar(saintTest4);        

        saints.ordenar(TipoOrdenacao.DESCENDENTE);

        assertEquals(saints.get(3), saints.getSaintMenorVida());
        assertEquals(saints.get(0), saints.getSaintMaiorVida());
    } 

    @Test public void unirListaSaints () throws Exception {
        ListaSaints ls1 = new ListaSaints();
        ListaSaints ls2 = new ListaSaints();

        Saint saintTest = new BronzeSaint("Shyriu", "Áries");
        Saint saintTest2 = new BronzeSaint("Shyriu", "Áries");
        ls1.adicionar(saintTest);
        ls1.adicionar(saintTest2);
        ls2.adicionar(saintTest);
        ls2.adicionar(saintTest2);
        ListaSaints ls3 = ls1.unir(ls2);

        assertEquals(4, ls3.todos().size());
    }

    @Test public void unirListaSaintComListaVazia () throws Exception {
        ListaSaints ls1 = new ListaSaints();
        ListaSaints ls2 = new ListaSaints();

        Saint saintTest = new BronzeSaint("Shyriu", "Áries");
        Saint saintTest2 = new BronzeSaint("Shyriu", "Áries");
        ls1.adicionar(saintTest);
        ls1.adicionar(saintTest2);        
        ListaSaints ls3 = ls1.unir(ls2);

        assertEquals(2, ls3.todos().size());
    }

    @Test public void unirDoisListaSaintVazio () {
        ListaSaints ls1 = new ListaSaints();
        ListaSaints ls2 = new ListaSaints();
        ListaSaints ls3 = ls1.unir(ls2);
        assertEquals(0, ls3.todos().size());
    }

    @Test public void diffListaSaints () throws Exception {
        ListaSaints ls1 = new ListaSaints();
        ListaSaints ls2 = new ListaSaints();

        Saint saintTest = new BronzeSaint("Xalão", "Áries");
        Saint saintTest2 = new BronzeSaint("Shyriu", "Áries");
        ls1.adicionar(saintTest);
        ls1.adicionar(saintTest2);
        ls2.adicionar(saintTest);        
        ListaSaints ls3 = ls1.diff(ls2);

        assertEquals(1, ls3.todos().size());
        assertEquals(saintTest2, ls3.get(0));
    }

    @Test public void diffListaSaintsComListaVazia () throws Exception {
        ListaSaints ls1 = new ListaSaints();
        ListaSaints ls2 = new ListaSaints();

        Saint saintTest = new BronzeSaint("Shyriu", "Áries");
        Saint saintTest2 = new BronzeSaint("Xarompe", "Áries");
        ls1.adicionar(saintTest);
        ls1.adicionar(saintTest2);        
        ListaSaints ls3 = ls1.diff(ls2);

        assertEquals(2, ls3.todos().size());
    }

    @Test public void diffDoisListaSaintVazio (){
        ListaSaints ls1 = new ListaSaints();
        ListaSaints ls2 = new ListaSaints();
        ListaSaints ls3 = ls1.unir(ls2);
        assertEquals(0, ls3.todos().size());
    }    

    @Test public void intersecListaSaint () throws Exception {
        ListaSaints ls1 = new ListaSaints();
        ListaSaints ls2 = new ListaSaints();

        Saint saintTest = new BronzeSaint("Shyriu", "Áries");
        Saint saintTest2 = new BronzeSaint("Xarompe", "Áries");

        ls1.adicionar(saintTest);
        ls1.adicionar(saintTest2);
        ls2.adicionar(saintTest2);
        ListaSaints ls3 = ls1.intersec(ls2);
        assertEquals(saintTest2, ls3.todos().get(0));
        assertEquals(1, ls3.todos().size());
    }

    @Test public void intersecListaSaintsComListaVazia () throws Exception {
        ListaSaints ls1 = new ListaSaints();
        ListaSaints ls2 = new ListaSaints();

        Saint saintTest = new BronzeSaint("Shyriu", "Áries");
        Saint saintTest2 = new BronzeSaint("Xarompe", "Áries");

        ls1.adicionar(saintTest);
        ls1.adicionar(saintTest2);

        ListaSaints ls3 = ls1.intersec(ls2);

        assertEquals(0, ls3.todos().size());
    }

    @Test public void intersecListasNaoTemNadaEmComum () throws Exception { 
        ListaSaints ls1 = new ListaSaints();
        ListaSaints ls2 = new ListaSaints();

        Saint saintTest = new BronzeSaint("Shyriu", "Áries");
        Saint saintTest2 = new BronzeSaint("Xarompe", "Áries");
        Saint saintTest3 = new BronzeSaint("A", "Áries");
        Saint saintTest4 = new BronzeSaint("B", "Áries");
        Saint saintTest5 = new BronzeSaint("C", "Áries");
        Saint saintTest6 = new BronzeSaint("D", "Áries");
        Saint saintTest7 = new BronzeSaint("E", "Áries");
        ls1.adicionar(saintTest);
        ls1.adicionar(saintTest2);
        ls1.adicionar(saintTest3);
        ls1.adicionar(saintTest4);
        ls2.adicionar(saintTest5);
        ls2.adicionar(saintTest6);
        ls2.adicionar(saintTest7);

        ListaSaints ls3 = ls1.intersec(ls2);

        assertEquals(0, ls3.todos().size());
    }       

    @Test public void intersecDoisListaSaintVazio () throws Exception {
        ListaSaints ls1 = new ListaSaints();
        ListaSaints ls2 = new ListaSaints();        
        ListaSaints ls3 = ls1.intersec(ls2);        
        assertEquals(0, ls3.todos().size());
    }

    @Test public void intersecDoisSaintsCategoriaDiferente () throws Exception {
        ListaSaints ls1 = new ListaSaints();
        ListaSaints ls2 = new ListaSaints();
        SilverSaint ssaint = new SilverSaint("Jon", "Áries");
        BronzeSaint bsaint = new BronzeSaint("Jon", "Áries");
        ls1.adicionar(ssaint);
        ls2.adicionar(bsaint);
        ListaSaints ls3 = ls1.intersec(ls2);
        assertEquals(0, ls3.todos().size());
    }

    @Test public void intersecDoisSaintsMesmaClasseCategoriaDiferente () throws Exception {
        ListaSaints ls1 = new ListaSaints();
        ListaSaints ls2 = new ListaSaints();
        Saint ssaint = new BronzeSaint("Jon", "Áries");
        Saint bsaint = new BronzeSaint("Jon", "Áries");
        ls1.adicionar(ssaint);
        ls2.adicionar(bsaint);
        ListaSaints ls3 = ls1.intersec(ls2);
        assertEquals(0, ls3.todos().size());
    }

    @Test public void getCSVSemSaints(){
        ListaSaints ls1 = new ListaSaints();
        ls1.getCSV();
        assertEquals("", ls1.getCSV());
    }

    @Test public void getCSVComSaints() throws Exception{
        ListaSaints lista = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        june.setGenero(Genero.FEMININO);
        june.perderVida(15.5);
        lista.adicionar(june);

        Saint dohko = new SilverSaint("Dohko", "");        
        dohko.perderVida(90);
        dohko.vestirArmadura();
        lista.adicionar(dohko);      
        String csv = lista.getCSV(); 
       
        
        String compare = "June,84.5,Camaleão,BRONZE,VIVO,FEMININO,false"+ "\n" +"Dohko,10.0,,PRATA,VIVO,NAO_INFORMADO,true";
        System.out.println(csv);
        System.out.println(compare);
        assertEquals(compare, csv);       
    }
}