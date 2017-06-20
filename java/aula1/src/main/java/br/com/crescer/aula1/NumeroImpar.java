package br.com.crescer.aula1;

import java.util.Scanner;

/**
 *
 * @author leonardo.alves
 */
class NumeroImpar{
  public static void main(String[] args) {
	
     System.out.print("Informe um número de telefone: "); 
     int x = 0;

     try(final Scanner input = new Scanner(System.in)) {

        x = input.nextInt();	

        if(x % 2 == 0) 
           System.out.println("O número é par");	
	else
	   System.out.println("O número é ímpar");

     } catch( Exception e ) {
        System.err.println(e.getMessage());         
     }
  }
}