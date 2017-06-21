
package br.com.crescer.aula1;

import java.text.Normalizer;

/** 
 * @author leonardo.alves
 **/
public class MeuStringUtils implements StringUtils {
    
    private String normalizar (String string) {
        return Normalizer
                .normalize(string, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "")
                .toLowerCase();
    }
    
    private String trim (String string) {
        return string.replaceAll("\\s+","");
    }

    @Override
    public boolean isEmpty(String string) {
        return string == null || string.length() == 0;
    }

    @Override
    public String inverter(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    @Override
    public int contaVogais(String string) {
        return  (int) normalizar(string)
                    .chars()
                    .mapToObj(c -> (char) c)
                    .filter(s -> 
                             s == 'a' || 
                             s == 'e' ||
                             s == 'i' ||
                             s == 'o' ||
                             s == 'u'   )
                    .count();
    }

    @Override
    public boolean isPalindromo(String string) {
        String stringNormalizada = trim(normalizar(string));
        return stringNormalizada.equals(inverter(stringNormalizada));
    }

}
