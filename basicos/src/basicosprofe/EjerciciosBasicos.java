package basicosprofe;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * LISTA DE EJERCICIOS DE REPASO A LA PARTE DE INICIACIÓN EN JAVA:
 * 
 * 1) HACER UN MÉTODO QUE RECIBA UNA CADENA Y UN CARACTER Y DIGA SI ESE CARACTER
 * PERTENECE A LA CADENA O NO perteneceACadena 2) HACER UN MÉTODO QUE RECIBA UNA
 * CADENA Y UN CARACTER Y DIGA CÚANTAS VECES APARECE ESE CARACTER EN LA CADENA
 * 2.1) HACER UN MÉTODO QUE RECIBA UNA CADENA Y UN CARACTER Y DIGA la última
 * posición donde aparece ese caracter en esa cadena. Si no está, devuelve -1
 * 
 * "hola" a --> 3 "maja" a --> 3 "conejo" i --> -1
 * 
 * 
 * 3) HACER UN MÉTODO QUE DADO UN NÚMERO, DIGA SI ES PAR O NO esPar 4) HACER UN
 * MÉTODO QUE LE PIDA AL USUARIO SU EDAD Y LE DIGA SI ES MAYOR DE EDAD O NO
 * mayorDeEdad 5) HACER UN MÉTODO QUE RECIBA UNA NOTA DE 0 A 10 Y DIGA SI
 * EQUIVALE A UN APROBADO, BIEN, NOTABLE, O SOBRESALIENTE clasificarNota - 6)
 * HACER UN MÉTODO QUE RECIBA UNA CADENA Y LA DEVUELVA ALREVÉS invertirCadena 7)
 * HACER UN PROGRAMA QUE MUESTRE LA SECUENCIA 3, 6, 9, 12, 15 ...99 deTresEnTres
 *
 *
 * // DEFINO UN MÉTODO // DARLE UN NOMBRE - camelCase // ID la entrada - // ID
 * la salida -
 *
 * //pensar el los pasos en esapñol en psuedocódigo
 */

//1
public class EjerciciosBasicos {

//	private static boolean perteneceElCaracter(String cadena, char car) {
//		boolean bl = false;
//
//		if (cadena.contains(car + "")) {
//			bl = true;
//		}
//
//		return bl;
//	}
//
//	public static void main(String[] args) {
//		if (perteneceElCaracter("torremolinos", 'f')) {
//
//			System.out.println("La palabra contiene el caracter");
//		} else {
//			System.out.println("La palabra no contiene el caracter");
//		}
//	}

	// 2
//	private static int cuantasVecesApareceElCaracter(String cadena, char car) {
//		
//		int cont = 0;
//		int longitud = cadena.length()
//		
//		
//		for(int i = 0; i < longitud; i++) {
//		if(cadena.charAt(i) == car){
//			cont++;
//		}
//		
//	}
//		return cont;
//	}
//	
//	public static void main(String[] args) {
//		
//		int resultado = cuantasVecesApareceElCaracter("torremolinos", 'o');
//		
//		if(resultado > 0) {
//			
//			System.out.println("La letra aparece "+resultado+" veces");
//		}else {
//			System.out.println("La letra no aparece");
//		}
//	}
	// 2.1
//	private static int ultimaPosicionDelCaracter(String cadena, char car) {
//		
//		int resultado = -1;
//		
//		for(int i = 0; i < cadena.length(); i++) {
//			
//		if(cadena.charAt(i) == car){
//			resultado = i;
//		}
//		
//	}
//		return resultado;
//	}
//	
//	
//	public static void main(String[] args) {
//		
//		int result = ultimaPosicionDelCaracter("torremolinos", 's');
//		
//		System.out.println("La ultima posicion es "+result);
//	}
	// 3
//	private static void esPar(int num){
//		
//				
//		if(num%2 == 0) {
//			System.out.println("Es par");
//		}else {
//			System.out.println("Es impar");
//		}
//		
//	
//	}
//	
//	public static void main(String[] args) {
//		
//		esPar(12);
//}

	// 4

//	private static void esMayorDeEdad() {
//
//	Scanner scanner = new Scanner(System.in);
//	
//	System.out.println("Ingesa la edad: ");
//	int edad = scanner.nextInt();
//		
//		if(edad >= 18) {
//			System.out.println("Es mayor de edad");
//		}else {
//			System.out.println("Es menor de edad");
//		}
//		scanner.close();
//	}
//	
//	
//	public static void main(String[] args) {
//		
//		esMayorDeEdad();
//	}

	// 5

//	private static void recibeNota() {
//		Scanner scanner = new Scanner(System.in);
//		
//		System.out.println("Ingresa la nota: ");
//		int nota = scanner.nextInt();
//		
//		if(nota < 5) {
//			System.out.println("Suspenso");
//		}else if(nota >=5 && nota <=6) {
//			System.out.println("Bien");
//		}else if(nota >6 && nota <=8) {
//			System.out.println("Notable");
//		}else if(nota >8 && nota <10) {
//			System.out.println("Sobresaliente");
//		}
//		
//	}
//	
//	public static void main(String[] args) {
//		recibeNota();
//	}

	// 6

//	private static String devolverAlReves(String palabra) {
//		
//		StringBuilder palabraInversa = new StringBuilder(palabra).reverse();		
//		
//		return palabraInversa.toString();
//	}
//	
//	
//	public static void main(String[] args) {
//		String palabraReves = devolverAlReves("prueba");
//		System.out.println(palabraReves);
//	}

	// 7

//	private static ArrayList<Integer> secuencia(){
//		ArrayList<Integer> resultado = new ArrayList<>();
//		
//		for(int i = 1; i < 100; i++) {
//			if(i%3==0) {
//			resultado.add(i);
//			}
//		}
//		
//		return resultado;
//	}
//	
//	
//	public static void main(String[] args) {
//		
//		ArrayList<Integer> numeros = secuencia();
//		
//		System.out.println(numeros);
//	}

}
