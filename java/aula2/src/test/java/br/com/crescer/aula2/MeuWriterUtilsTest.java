/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula2;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author leonardo.alves
 */
public class MeuWriterUtilsTest {
    
    public MeuWriterUtilsTest() {
    }

    @Test
    public void testWrite() throws Exception {    
        MeuWriterUtils instance = new MeuWriterUtils();
        MeuFileUtils fileUtils = new MeuFileUtils();

        String file = "writeTest.txt";
        String conteudo = "Banana incandescente sobre o poder do Deus descontrolado.\nCabum";

        fileUtils.mk(file);
        
        instance.write(file, conteudo);
        assertEquals(conteudo, new MeuReaderUtils().read(file));
        
        fileUtils.rm(file);
    }
    
}
