package br.com.crescer.aula3.sql.utils;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author leonardo.alves
 */
public class SqlUtilsDAOTest {    
    
    @Ignore
    @Test
    public void testRunQuery() {
        System.out.println("runQuery");
        String query = "";
        SqlUtilsDAO instance = new SqlUtilsDAO();
        instance.runQuery(query);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testToCSV() {
        System.out.println("toCSV");
        String query = "SELECT * FROM PAIS WHERE Id = 1";
        SqlUtilsDAO instance = new SqlUtilsDAO();
        String expResult = "ID,NOME,SIGLA\n1,Brasil,BR";
        String result = instance.toCSV(query);
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSaveCSV() {
        System.out.println("saveCSV");
        String tabela = "PAIS";
        String[] colunas = {"ID", "NOME", "SIGLA"};
        String[] valores = {"2", "ARMENIA", "AR", "3", "Borussia", "BO"};
        SqlUtilsDAO instance = new SqlUtilsDAO();
        
        assertTrue(instance.saveCSV(tabela, colunas, valores));
    }
    
}
