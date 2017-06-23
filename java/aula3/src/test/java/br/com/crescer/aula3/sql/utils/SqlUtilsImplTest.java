
package br.com.crescer.aula3.sql.utils;

import java.io.File;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author leonardo.alves
 */
public class SqlUtilsImplTest {
    
    public SqlUtilsImplTest() {
    }
    @Ignore
    @Test
    public void testRunFile() {
        System.out.println("runFile");
        String filename = "";
        SqlUtilsImpl instance = new SqlUtilsImpl();
        instance.runFile(filename);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    @Ignore
    @Test
    public void testExecuteQuery() {
        System.out.println("executeQuery");
        String query = "";
        SqlUtilsImpl instance = new SqlUtilsImpl();
        String expResult = "";
        String result = instance.executeQuery(query);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    @Test
    public void testImportCSV_File() {
        System.out.println("importCSV");
        File file = new File("pais.csv");
        SqlUtilsImpl instance = new SqlUtilsImpl();
        instance.importCSV(file);
        assertTrue(true);
    }
    
    @Test
    public void testImportCSV_String() {
        System.out.println("importCSV");
        String query = "SELECT * FROM PAIS";
        SqlUtilsImpl instance = new SqlUtilsImpl();
        
        File result = instance.importCSV(query);
        File expResult = new File(result.getName());
        assertEquals(expResult, result);
        
    }
    
}
