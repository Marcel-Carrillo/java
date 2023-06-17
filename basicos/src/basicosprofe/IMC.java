package basicosprofe;
import java.util.Scanner;


public class IMC {
	public static void main(String[] args) {
		
			peticion();
	}
	
	
	public static void peticion(){
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Ingesa la estatura en metros: ");
		float estatura = scanner.nextFloat();
		System.out.println("Ingesa el peso en kilos: ");
		float peso = scanner.nextFloat();
		
		float estaturaFinal = estatura * estatura;
	
		
		float imcFinal = peso / estaturaFinal;
		
		if(imcFinal < 16) {
			System.out.println("Eres Desnutrido");
		}else if(imcFinal >= 16 && imcFinal < 18) {
			System.out.println("Eres Delgado");
		}else if(imcFinal >= 18 && imcFinal < 25){
			System.out.println("Peso Ideal");
		}else if(imcFinal >= 25 && imcFinal <31) {
			System.out.println("Tienes Sobrepeso");
		}else if(imcFinal >= 31) {
			System.out.println("Obeso");
		}
		
		System.out.println("Este es tu indice de masa corporal "+imcFinal);
		scanner.close();
	}
	
	
}


/**
 * TODO
 * HACED UNA APLICACIÓN QUE PERMITA INTRODUCIR AL USUARIO
 * SU ESTATURA EN METROS Y SU PESO EN KG Y LE INFORME SU 
 * INFORME DE SU ÍNDICE DE MASA CORPORAL (IMC) SEGÚN LA SIGUIENTE FÓRMULA
 * 
 * LA FÓRMULA DEL IMC = PESO KG / ESTATURA AL CUADRADO METROS
 *  * SI IMC < 16 ->> su imc es DESNUTRIDO
 * SI IMC >= 16 Y < 18  ->> su imc es DELGADO
 * SI IMC >= 18 Y < 25  ->> su imc es IDEAL
 * SI IMC >= 25 Y < 31  ->> su imc es SOBREPESO
 * SI IMC >= 31 ->> su imc es OBESO
 ADEMÁS, DE DECIRLE SU IMC NUMÉRICO Y NOMINAL,
pista: PARA LEER DE TECLADO USAD LA CLASE SCANNER
  */