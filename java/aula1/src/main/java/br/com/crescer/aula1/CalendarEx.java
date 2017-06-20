package br.com.crescer.aula1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.Scanner;
/**
 *
 * @author leonardo.alves
 */
public class CalendarEx {
    private static Calendar calendar = Calendar.getInstance();
    private static SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
    
    public static void main(String [] args) throws ParseException {        
        //exibirDataHoraAtual(); 
        somarDiasData();
    }
    
    private static void exibirDataHoraAtual () {     
        calendar.getInstance();
        SimpleDateFormat dataHora = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        
        System.out.println("DATA HORA ATUAL :" + dataHora.format(calendar.getTime()));
    }
    
    private static void diaSemanaNascimento () throws ParseException {        
        String data = "";
        
        try(final Scanner input = new Scanner(System.in)) {
            
            System.out.println("Informe a data de nascimento (DD/MM/YYYY): ");
            data = input.nextLine();
            
        } catch (Exception e) {
            System.err.println(e);
        }
        
        Date dataFormatada = formatoData.parse(data);        
        calendar.setTime(dataFormatada);        
        System.out.println(calendar.DAY_OF_WEEK);
    }
    
    private static void somarDiasData () throws ParseException {       
        String data = "";
        int dias = 0;
        
        try(final Scanner input = new Scanner(System.in)) {   
            
            System.out.println("Informe a data de nascimento (dd/MM/YYYY): ");
            data = input.nextLine();            
            
            System.out.println("Informe dias a somar: ");
            dias = input.nextInt();            
            
        } catch (Exception e) {
            System.err.println(e);
        }
        
        Date dataFormatada = formatoData.parse(data);
        calendar.setTime(dataFormatada);  
        calendar.add(Calendar.DATE, dias);
        
        System.out.println("DATA APOS SOMAR: " + formatoData.format(calendar.getTime()));
    }
}
