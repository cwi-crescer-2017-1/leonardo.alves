
package br.com.crescer.aula1;

import java.util.Calendar;
import java.util.Date;

/** 
 * @author leonardo.alves
 **/
public class MeuCalendarUtils implements CalendarUtils {
   
    private boolean ehBissexto (int ano) {        
        if(ano % 4 == 0){
            if(ano % 100 == 0){
                if(ano % 400 != 0){
                    return false;
                }
            } 
            return true;
        }
        return false;
    }
    
    @Override
    public DiaSemana diaSemana(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dia = calendar.get(Calendar.DAY_OF_WEEK);
        return  DiaSemana.values()[dia - 1];
    }

    @Override
    public String tempoDecorrido(Date date) {
        Calendar cData = Calendar.getInstance();
        cData.setTime(date);      
        int anoData = cData.get(Calendar.YEAR);
        
        Calendar cAtual = Calendar.getInstance();
        cAtual.setTime(new Date());        
        
        int anos = 0;
        int meses = 0;
        int dias = 0;
        
        long atualMillis = cAtual.getTimeInMillis();
        long dataMillis = cData.getTimeInMillis();        
        long millisRestantes = atualMillis - dataMillis;
        
       //31536000000 1 ano em ms
       //2592000000 1 mes em ms
       //86400000 1 dia em ms
        while (millisRestantes > 31536000000L){
            anos++;
            millisRestantes -= 31536000000L;
        }
         
        while (millisRestantes > 2592000000L) {
            meses++;
            millisRestantes -= 2592000000L;
        }
        
        while (millisRestantes > 86400000) {
            dias++;
            millisRestantes -= 86400000;
        }     
        
        if(ehBissexto(anoData)) dias++;       
        
        return anos + " ano(s), " + meses + " mes(es) e " + dias + " dia(s)";   
    }

}
