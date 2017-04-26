

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
public class DadoD6Test {
    @Test
    public void verificarSeApenasNumerosDe1Ao6SaoSorteados () {
        Sorteador dado = new DadoD6();
        ArrayList<Integer> numeros = new ArrayList <> ();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);
        numeros.add(6);
        for(int i = 0; i < 30; i++){
            int resultado = dado.sortear();
            assertTrue(numeros.contains(resultado));
        }        
    }   
    
    @Test
    public void verificarSeNumerosDiferentesDe1a6SaoSelecionados () {
        Sorteador dado = new DadoD6();
        ArrayList<Integer> numeros = new ArrayList <> ();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);
        numeros.add(6);
        for(int i = 0; i < 30; i++){
            int resultado = dado.sortear();
            assertFalse(!numeros.contains(resultado));
        }        
    }   
}