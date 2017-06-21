/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author leonardo.alves
 */
public class MeuStringUtilsTest {
    
    public MeuStringUtilsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isEmpty method, of class MeuStringUtils.
     */
    @org.junit.Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        String string = "";
        MeuStringUtils instance = new MeuStringUtils();
        boolean expResult = true;
        boolean result = instance.isEmpty(string);
        assertEquals(expResult, result);
    }

    /**
     * Test of inverter method, of class MeuStringUtils.
     */
    @org.junit.Test
    public void testInverter() {
        System.out.println("inverter");
        String string = "batata";
        MeuStringUtils instance = new MeuStringUtils();
        String expResult = "atatab";
        String result = instance.inverter(string);
        assertEquals(expResult, result);
    }

    /**
     * Test of contaVogais method, of class MeuStringUtils.
     */
    @org.junit.Test
    public void testContaVogais() {
        System.out.println("contaVogais");
        String string = "Incrivel poder das vogais";
        MeuStringUtils instance = new MeuStringUtils();
        int expResult = 9;
        int result = instance.contaVogais(string);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of isPalindromo method, of class MeuStringUtils.
     */
    @org.junit.Test
    public void testIsPalindromo() {
        System.out.println("isPalindromo");
        String string = "ovo";
        MeuStringUtils instance = new MeuStringUtils();
        boolean expResult = true;
        boolean result = instance.isPalindromo(string);
        assertEquals(expResult, result);        
    }
    
        @Test
    public void testIsEmptys() {
        MeuStringUtils stringUtils = new MeuStringUtils();
        assertTrue(stringUtils.isEmpty(null));
        assertTrue(stringUtils.isEmpty(""));
        assertTrue(stringUtils.isEmpty(" "));
        assertFalse(stringUtils.isEmpty("a"));
        assertFalse(stringUtils.isEmpty(" a "));
    }

    /**
     * Test of inverter method, of class StringUtils.
     */
    @Test
    public void testInverters() {
                MeuStringUtils stringUtils = new MeuStringUtils();

        assertEquals("solrac", stringUtils.inverter("carlos"));
    }

    /**
     * Test of contaVogais method, of class StringUtils.
     */
    @Test
    public void testContaVogaiss() {
                MeuStringUtils stringUtils = new MeuStringUtils();

        assertEquals(2, stringUtils.contaVogais("carlos"));
    }

    /**
     * Test of isPalindromo method, of class StringUtils.
     */
    @Test
    public void testIsPalindromos() {
                MeuStringUtils stringUtils = new MeuStringUtils();

        assertTrue(stringUtils.isPalindromo("ovo"));
        assertTrue(stringUtils.isPalindromo("Ame a Ema"));
        assertTrue(stringUtils.isPalindromo("A sogra má e amargosa"));
        assertFalse(stringUtils.isPalindromo("uva"));
        assertFalse(stringUtils.isPalindromo("Ame a Emo"));
    }
    
}
