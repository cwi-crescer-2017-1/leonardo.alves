package br.com.crescer.aula2;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author leonardo.alves
 */
public class MeuFileUtilsTest {
    
    public MeuFileUtilsTest() {
    }

    @Test
    public void testMk() {
        System.out.println("mk");
        String string = "file.txt";
        MeuFileUtils instance = new MeuFileUtils();
        boolean expResult = true;
        boolean result = instance.mk(string);
        instance.rm(string);
        assertEquals(expResult, result);        
    }

    @Test
    public void testRm() {
        System.out.println("rm");
        String string = "file.txt";
        
        MeuFileUtils instance = new MeuFileUtils();
        instance.mk(string);
        boolean expResult = true;
        boolean result = instance.rm(string);
        assertEquals(expResult, result);
       
    }

    @Test
    public void testLs() {
        MeuFileUtils instance = new MeuFileUtils();
        String string = "file.txt";        
        instance.mk(string);
        
        String expResult = "C:\\Users\\leonardo.alves\\Documents\\crescer\\leonardo.alves\\java\\aula2\\file.txt";
        String result = instance.ls(string);
        
        assertEquals(expResult, result);
        
        instance.rm(string);
    }

    @Test
    public void testMv() {
        MeuFileUtils instance = new MeuFileUtils();
        
        String in = "file.txt";
        String out = "src/test/java/br/com/crescer/aula2/files/file.txt";
        
        instance.mk(in);  
        
        boolean expResult = true;
        boolean result = instance.mv(in, out);
        assertEquals(expResult, result);
      
        instance.rm(out);
        
    }
    
}
