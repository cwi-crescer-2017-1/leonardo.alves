
package br.com.crescer.aula2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/** 
 * @author leonardo.alves
 **/
public class MeuReaderUtils implements ReaderUtils {

    @Override
    public String read(String string) throws IOException {        
        StringBuilder sb = new StringBuilder();  
        
        if(!string.endsWith(".txt")) throw new IOException("Só é permitido arquivos .txt");
        
        try(Reader r = new FileReader(string);
            BufferedReader reader = new BufferedReader(r)) {
            
            reader.lines()
                 .forEach(line -> sb.append(line).append("\n"));  
            
            sb.deleteCharAt(sb.length()-1);
           
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
           System.err.println(ex);
        }
       return sb.toString();
    }
}
