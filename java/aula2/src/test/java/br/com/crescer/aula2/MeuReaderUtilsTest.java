package br.com.crescer.aula2;

import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author leonardo.alves
 */
public class MeuReaderUtilsTest {
    
    public MeuReaderUtilsTest() {
    }

    @Test
    public void testRead() throws IOException {       
        MeuReaderUtils instance = new MeuReaderUtils();
        String string = "readerFile.txt";
        String expResult = "Hello World\n1\n2\n3\nBatata Frita\nArroz\nChuva de panelinha dourada";
        String result = instance.read(string);
        assertEquals(expResult, result);        
    }
    
}
