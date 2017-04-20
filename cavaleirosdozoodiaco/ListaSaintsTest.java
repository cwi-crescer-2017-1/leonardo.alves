

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
public class ListaSaintsTest {
    @Test
    public void adicionarSaint () throws Exception{
        ListaSaints saints = new ListaSaints();
        Saint saintTest = new Saint("Shyriu", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
        
        saints.adicionar(saintTest);
        
        assertEquals(saintTest, saints.get(0));
    }
    
    @Test
    public void pegarTodosSaints () throws Exception {
        ListaSaints saints = new ListaSaints();
        ArrayList<Saint> arrayTest = new ArrayList<> ();
        Saint saintTest = new Saint("Shyriu", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
        Saint saintTest2 = new Saint("Shyriu", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
        Saint saintTest3 = new Saint("Shyriu", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
        
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
        Saint saintTest = new Saint("Shyriu", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
        Saint saintTest2 = new Saint("Shyriu", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
        saints.adicionar(saintTest);
        saints.adicionar(saintTest2);
        
        saints.remover(saintTest);
        
        assertEquals(saints.todos().size(), 1);
    }
    
    @Test
    public void buscarSaintPorNome () throws Exception {
        ListaSaints saints = new ListaSaints();
        Saint saintTest = new Saint("Shyriu", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
        Saint saintTest2 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
        saints.adicionar(saintTest);
        saints.adicionar(saintTest2);
        
        assertEquals(saints.buscarPorNome("Shyriu"), saints.get(0));
    }
    
     @Test
    public void buscarSaintComRepeticaoPorNome () throws Exception {
        ListaSaints saints = new ListaSaints();
        Saint saintTest = new Saint("Shyriu", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
        Saint saintTest2 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
        Saint saintTest3 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
        saints.adicionar(saintTest);
        saints.adicionar(saintTest2);
        saints.adicionar(saintTest3);
        
        assertEquals(saints.buscarPorNome("Shalon"), saints.get(1));
    }
    
    @Test
    public void buscarSaintInexistentePorNome () throws Exception {
        ListaSaints saints = new ListaSaints();
        Saint saintTest = new Saint("Shyriu", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
        Saint saintTest2 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
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
        Saint saintTest = new Saint("Shyriu", new Armadura(new Constelacao("Pégaso"), Categoria.OURO));
        Saint saintTest2 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
        Saint saintTest3 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.PRATA));
        Saint saintTest4 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
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
       
        Saint saintTest = new Saint("Shyriu", new Armadura(new Constelacao("Pégaso"), Categoria.OURO));
        Saint saintTest2 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.PRATA));
        Saint saintTest3 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.PRATA));
        Saint saintTest4 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.PRATA));
        saints.adicionar(saintTest);
        saints.adicionar(saintTest2);
        saints.adicionar(saintTest3);
        saints.adicionar(saintTest4);    
        ArrayList<Saint> arrayTest = saints.buscarPorCategoria(Categoria.BRONZE);
        assertEquals(0, arrayTest.size());
           
    }
    
      
    @Test
    public void buscarSaintsPorStatus () throws Exception {
        ListaSaints saints = new ListaSaints();
        ArrayList<Saint> arrayTest = new ArrayList<> ();
        Saint saintTest = new Saint("Shyriu", new Armadura(new Constelacao("Pégaso"), Categoria.OURO));
        Saint saintTest2 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
        Saint saintTest3 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.PRATA));
        Saint saintTest4 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
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
        
        Saint saintTest = new Saint("Shyriu", new Armadura(new Constelacao("Pégaso"), Categoria.OURO));
        Saint saintTest2 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
        Saint saintTest3 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.PRATA));
        Saint saintTest4 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
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
        
        Saint saintTest = new Saint("Shyriu", new Armadura(new Constelacao("Pégaso"), Categoria.OURO));
        Saint saintTest2 = new Saint("Xerere", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
        Saint saintTest3 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.PRATA));
        Saint saintTest4 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
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
        
        Saint saintTest = new Saint("Shyriu", new Armadura(new Constelacao("Pégaso"), Categoria.OURO));
        Saint saintTest2 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
        Saint saintTest3 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.PRATA));
        Saint saintTest4 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
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
        
        Saint saintTest = new Saint("Shyriu", new Armadura(new Constelacao("Pégaso"), Categoria.OURO));
        Saint saintTest2 = new Saint("Ximbas", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
        Saint saintTest3 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.PRATA));
        Saint saintTest4 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
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
        
        Saint saintTest = new Saint("Shyriu", new Armadura(new Constelacao("Pégaso"), Categoria.OURO));
        Saint saintTest2 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
        Saint saintTest3 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.PRATA));
        Saint saintTest4 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
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
        
        Saint saintTest = new Saint("Shyriu", new Armadura(new Constelacao("Pégaso"), Categoria.OURO));
        Saint saintTest2 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
        Saint saintTest3 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.PRATA));
        Saint saintTest4 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
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
        
        Saint saintTest = new Saint("Shyriu", new Armadura(new Constelacao("Pégaso"), Categoria.OURO));
        Saint saintTest2 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
        Saint saintTest3 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.PRATA));
        Saint saintTest4 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
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
        
        Saint saintTest = new Saint("Shyriu", new Armadura(new Constelacao("Pégaso"), Categoria.OURO));
        Saint saintTest2 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
        Saint saintTest3 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.PRATA));
        Saint saintTest4 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
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
        
        Saint saintTest = new Saint("Shyriu", new Armadura(new Constelacao("Pégaso"), Categoria.OURO));
        Saint saintTest2 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
        Saint saintTest3 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.PRATA));
        Saint saintTest4 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
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
        
        Saint saintTest = new Saint("Shyriu", new Armadura(new Constelacao("Pégaso"), Categoria.OURO));
        Saint saintTest2 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
        Saint saintTest3 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.PRATA));
        Saint saintTest4 = new Saint("Shalon", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
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
        
        Saint saintTest = new Saint("Shyriu", new Armadura(new Constelacao("Pégaso"), Categoria.OURO));
        Saint saintTest2 = new Saint("Shyriu", new Armadura(new Constelacao("Pégaso"), Categoria.OURO));
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
        
        Saint saintTest = new Saint("Shyriu", new Armadura(new Constelacao("Pégaso"), Categoria.OURO));
        Saint saintTest2 = new Saint("Shyriu", new Armadura(new Constelacao("Pégaso"), Categoria.OURO));
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
    
}