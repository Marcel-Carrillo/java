package restaurantesmalaga;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import proyecto.model.Restaurante;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class MainRestaurante {

	private static final String RUTA_FICHERO = "Restaurantes.txt";

	public static List<Restaurante> cargarRestaurantes(List<String> lineas) {

		List<Restaurante> lRestaurantes = null;
		int numlinea = 0;
		Restaurante restauranteAux = null; // El restaurante en curso
		restauranteAux = new Restaurante(); // Creo el restaurante vacio
		lRestaurantes = new ArrayList<>(); // lista de restaurantes

		for (String linea : lineas) {
			numlinea = numlinea + 1;
			switch (numlinea) {
			case 1:
				restauranteAux.setNombre(linea);
				break;
			case 2:
				restauranteAux.setDireccion(linea);
				break;
			case 3:
				restauranteAux.setWeb(linea);
				break;
			case 4:
				restauranteAux.setFichaGoogle(linea);
				break;
			case 5:
				restauranteAux.setLatitud(Float.parseFloat(linea));
				break;
			case 6:
				restauranteAux.setLongitud(Float.parseFloat(linea));
				break;
			case 7:
				restauranteAux.setBarrio(linea);
				break;
			case 8:
				String[] especialidades = linea.split(","); // troceo esp1 esp2 esp3
				// paso de array a lista
				List<String> lespecialidades = Arrays.asList(especialidades);
				restauranteAux.setEspecialidades(lespecialidades);
				lRestaurantes.add(restauranteAux);
				numlinea = 0;
				restauranteAux = new Restaurante();
				break;
			}
		}

		return lRestaurantes;
	}

	public static void main(String[] args) throws IOException {
		// TODO Cargar la lista de restaurantes del fichero

		File file = new File(RUTA_FICHERO);
		if (file.exists()) {
			System.out.println("Fichero existe, a parsearlo");
			Path path = file.toPath(); // convierto a path para usar el nuevo api
			List<String> lineas = Files.readAllLines(path); // leo todo el fichero en una linea
			List<Restaurante> ListRest = cargarRestaurantes(lineas);
			System.out.println("La lista tiene " + ListRest.size());
			mostrarRestaurantes(ListRest);
			Restaurante r5 = ListRest.get(4);
			boolean esta = buscarRestaurante(ListRest, r5);
			System.out.println("R5 esta en la lista " + esta);
			
		} else {
			System.out.println("No existe el fichero en esa ruta: (");
		}

	}

	public static void mostrarRestaurantes(List<Restaurante> ListRest) {
		// muestra nombre canonigo seguida de una ruta interna de la memoria
		System.out.println("Mostrando restaurantes...");
		for (Restaurante r : ListRest) {
			System.out.println(r.toString());
		}
	}
	
	public static boolean buscarRestaurante (List<Restaurante> ListRest, Restaurante restauranteBuscado) {
		boolean estaRestaurante = false;
		int pos_actual = 0;
		int longitud = ListRest.size();
		Restaurante restauranteAux = null;
		
		while (pos_actual < longitud && !estaRestaurante ) {
			restauranteAux = ListRest.get(pos_actual);
			estaRestaurante = restauranteAux.equals(restauranteBuscado);
			pos_actual += 1;
		}
		
		return estaRestaurante;
	}
}
