package prueba;

import java.util.Scanner;

public class Practica2 {
	static String frase;
	public static void main(String[] args) {
		Scanner e=new Scanner(System.in);
		frase = "me cago en la constitucion";
        int contador = 0;
        System.out.println("Introduce las columnas");
        int columnas=e.nextInt();
        int longitud=frase.length();
        int claveporlongitud=columnas*columnas;
        
      
        char[][] matriz = new char[columnas][columnas];
	    for (int i = 0 ; i < columnas ; i++){
	        for (int j = 0 ; j < columnas; j++){
	        	try {
	        		matriz[i][j] = frase.charAt(contador);
		            contador++; 
				} catch (Exception e2) {
					// TODO: handle exception
					matriz[i][j] = 'x';
		            contador++; 
				}
	                          
	        }
	    }
        
        String textocifrado=cifradoTrans(matriz,columnas);
        System.out.print(textocifrado);
        String textoDescifrado=descifradoTrans(matriz,columnas);
        System.out.println(textoDescifrado);
	}
	
		private static String cifradoTrans(char[][] mytexto,int columnas) {
			String texto="";
			for (int i = 0; i < columnas; i++) {
			      for(int j = 0; j <columnas; j++) {
			    	  texto+=mytexto[j][i];
			      }
			      texto+= "\n";
			}
			return texto;
		}
	
		private static String descifradoTrans(char[][] mytexto,int filas) {
			String texto="";
			for (int i = 0 ; i < filas ; i++){
	            for (int j = 0 ; j < filas; j++){
	                texto+=mytexto[i][j];
	            }
	            
	        }
			return texto;
		}
}
