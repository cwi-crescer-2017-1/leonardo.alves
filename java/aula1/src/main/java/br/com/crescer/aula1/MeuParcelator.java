
package br.com.crescer.aula1;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/** 
 * @author leonardo.alves
 **/
public class MeuParcelator implements Parcelator {

    @Override
    public Map<String, BigDecimal> calcular(BigDecimal valorParcelar, 
                                            int numeroParcelas, 
                                            double taxaJuros, 
                                            Date dataPrimeiroVencimento) {
        
        Map<String, BigDecimal> parcelas = new HashMap<>();
        
        BigDecimal numParcelas = new BigDecimal(numeroParcelas);
        BigDecimal txJuros = new BigDecimal(taxaJuros);
        
        //(total + (total * juros)) / numeroParcelas
        BigDecimal valorMes = (valorParcelar.add(valorParcelar.multiply(txJuros))).divide(numParcelas);
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataPrimeiroVencimento);
        
        for(int i = 0; i < numeroParcelas; i++){            
            String mesAtual = formato.format(calendar.getTime());
            parcelas.put(mesAtual, valorMes);
            calendar.add(Calendar.MONTH, 1);
        }
        
        return parcelas;
    }

}
