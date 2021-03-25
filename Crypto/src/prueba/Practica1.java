package prueba;

import java.util.Scanner;

public class Practica1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner e =new Scanner(System.in);
		System.out.println("Introduce un texto: ");
		String texto=e.nextLine();
		System.out.println("Introduce numero: ");
		int N=e.nextInt();
		String cifrado=cifradoCesar(texto,N);
		System.out.println("Cifrado "+cifrado);
		String descifrado=descifrado(cifrado,N);
		System.out.println("Descifrado "+descifrado);
		
		/*
		65    A
		66    B
		67    C
		68    D
		69    E
		70    F
		71    G
		72    H
		73    I
		74    J
		75    K
		76    L
		77    M
		78    N
		79    O
		80    P
		81    Q
		82    R
		83    S
		84    T
		85    U
		86    V
		87    W
		88    X
		89    Y
		90    Z
		91    [
		92    \
		93    ] 
		94    ^
		95    _
		96    `
		97    a
		98    b
		99    c
		100   d 
		101   e
		102   f
		103   g
		104   h
		105   i
		106   j
		107   k
		108   l
		109   m
		110   n
		111   o
		112   p
		113   q
		114   r
		115   s
		116   t
		117   u
		118   v
		119   w
		120   x
		121   y
		122   z
		*/
		
	}

	public static String cifradoCesar(String texto, int codigo) {
		String salida="";
		for (int i = 0; i < texto.length(); i++) {
			if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                if ((texto.charAt(i) + codigo) > 'z') {
                	//z=122 en ASCII + codigo=3 resultado 125 equivale a } en ASCII
                    salida+=((char) (texto.charAt(i) + codigo-26));
                    /*
c                    solucion de la linea 32: si a 125 le quitamos 26 cuanto es el resultado? 99 ese es el valor 'c'
                    		ya que al caer en z queremos 3 posiciones adelnate osea el valor 'c'.
                    */
                } else {
                	salida+=((char) (texto.charAt(i) + codigo));
                	//el valor de 'a' en ASCII es 97 + 3 que es el valor ingresado por teclado que es 3
                }
            } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                if ((texto.charAt(i) + codigo) > 'Z') {
                	salida+=((char) (texto.charAt(i) + codigo - 26));
                } else {
                	salida+=((char) (texto.charAt(i) + codigo));
                }
            }
		}
		return salida;
	}

	public static String descifrado(String texto, int codigo) {
		String salida="";
		for (int j = 0; j < texto.length(); j++) {
			if (texto.charAt(j) >= 'a' && texto.charAt(j) <= 'z') {
	            if ((texto.charAt(j) - codigo) < 'a') {
	                salida+=((char) (texto.charAt(j) - codigo + 26));
	            } else {
	            	salida+=((char) (texto.charAt(j) - codigo));
	            }
	        } else if (texto.charAt(j) >= 'A' && texto.charAt(j) <= 'Z') {
	            if ((texto.charAt(j) - codigo) < 'A') {
	            	salida+=((char) (texto.charAt(j) - codigo + 26));
	            } else {
	            	salida+=((char) (texto.charAt(j) - codigo));
	            }
	        }
		}
		return salida;
	}
	
}
