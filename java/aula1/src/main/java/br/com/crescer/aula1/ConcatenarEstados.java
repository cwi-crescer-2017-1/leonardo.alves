package br.com.crescer.aula1;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author leonardo.alves
 */
public class ConcatenarEstados {
    public static void main(String [] args) {
        StringBuffer sb = new StringBuffer();
       
        ArrayList <String> nomeEstado = new ArrayList<>();
        
        
        
        for(Estados estado : Estados.values())            
            nomeEstado.add(Normalizer.normalize(estado.getNome(), Normalizer.Form.NFD)
                                    .replaceAll("[^\\p{ASCII}]", ""));
                
        Collections.sort(nomeEstado);
        
        nomeEstado
            .forEach((estado) -> {
                sb.append(estado)
                  .append(",");
                }
            );
        
        sb.deleteCharAt(sb.length() - 1);
        
        System.out.println(sb.toString());
    }
}
