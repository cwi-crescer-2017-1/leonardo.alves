
package br.com.crescer.aula2;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/** 
 * @author leonardo.alves
 **/
public class MeuWriterUtils implements WriterUtils  {

    @Override
    public void write(String file, String conteudo) throws IOException {
        
        if(!file.contains(".txt")) throw new IOException("O arquivo precisa ser .txt");
        
        try(Writer w = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(w)){
            
            writer.append(conteudo);
            writer.flush();
        
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        } catch (IOException ex){
            System.err.println(ex);
        }
    }

}
