
package br.com.crescer.aula2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;


/** 
 * @author leonardo.alves
 **/
public class MeuFileUtils implements FileUtils{
    
    private boolean ehArquivo (File file) throws IOException {
        return Files.probeContentType(file.toPath()) != null;
    }

    @Override
    public boolean mk(String string) {
        
        try  {
            File file = new File(string);            
            
            if(ehArquivo(file)) 
                return file.createNewFile(); 
            else 
                return file.mkdir();
            
        } catch (IOException e) {
            System.err.println(e.getStackTrace());  
        } 
        return false;
    }

    @Override
    public boolean rm(String string) {
        File file = new File(string);        
        
        try {
            
            if(ehArquivo(file)) 
                return file.delete();
            
        } catch (IOException e) {
            System.err.println(e.getStackTrace());
        }
      
        System.err.println("Arquivo inválido.");
        return false;                
    }

    @Override
    public String ls(String string) {
        File file = new File(string);
        
        try {
            if(ehArquivo(file))
                return file.getAbsolutePath();
            else
                return Arrays.toString(file.list());
        } catch (Exception e) {
            System.err.println(e.getStackTrace());
        }
        
        return null;
    }

    @Override
    public boolean mv(String in, String out) {   
       File file = new File(in);
        try {
            if(ehArquivo(file))       
                return file.renameTo(new File(out));
            else
                System.out.println("Arquivo inválido");
        } catch (IOException e) {
            System.err.println(e);
        }
        return false;
    }   
}


/* Apenas alguns testes
 try (
        Writer w = new FileWriter(out); 
        Reader r = new FileReader(in);

        BufferedWriter writer = new BufferedWriter(w);
        BufferedReader reader = new BufferedReader(r);
    ) {           

    File output = new File(out); 
    File input = new File(in);

    boolean outCriado = output.createNewFile();            

    if(ehArquivo(input) && outCriado){

        reader.lines()                              
            .map(s -> (CharSequence) s)
            .forEach(s -> {
            try {
                writer.append(s);
            } catch (IOException ex) {
                System.err.println(ex);
            }
        });                    
        writer.flush();

        input.delete();
        return true;
    }
    } catch (IOException e) {
        System.err.println(e);
    }
    return false;
*/