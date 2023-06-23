package restaurantesmalaga;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;

import proyecto.model.ComparadorDeRestaurantes;
import proyecto.model.Restaurante;

public class MainMapas {

	private static final String RUTA_FICHERO = "restaurantes.txt";

	public static void main(String[] args) throws IOException {

		// TODO Cargar la lista de restaurantes del fichero
		File file = new File(RUTA_FICHERO);
		if (file.exists()) {
			System.out.println("FICHERO EXISTE!, a parsearlo :)");
			Path path = file.toPath();// convierto a PATH para usar el nuevo API y así ir más rápido
			List<String> lineas = Files.readAllLines(path);// leo todo el fichero en una línea
			List<Restaurante> listRest = MainRestaurante.cargarRestaurantes(lineas);

			Map<String, Restaurante> mapaRestaurantes = new HashMap<>();
			for (Restaurante r : listRest) {
				mapaRestaurantes.put(r.getNombre(), r);
			}

			Restaurante rp = mapaRestaurantes.get("La Parrilla");
			System.out.println(rp.toString());

			// Partiendo de la lista de restaurantes haced un mapa,
			// donde la clave sea el barrio y el valor la lista de restaurantes de ese
			// barrio

			Map<String, List<Restaurante>> mapaRestaurantesPorBarrios = null;
			mapaRestaurantesPorBarrios = crearMapBarrios(listRest);
			mostrarMapa(mapaRestaurantesPorBarrios);
			List<Restaurante> lr = getRestMasCaros(mapaRestaurantesPorBarrios);
			System.out.println("Mostrando los mas caros");
			for (Restaurante r : lr) {
				System.out.println(r.toString());
			}

		} else {
			System.out.println("FICHERO NO EXISTE!");
		}
	}

	private static void mostrarMapa(Map<String, List<Restaurante>> mapa) {

		Set<String> clavesMapa = mapa.keySet();
		for (String barrio : clavesMapa) {
			List<Restaurante> lrb = mapa.get(barrio);
			System.out.println("Barrio = " + barrio);
			for (Restaurante rb : lrb) {
				System.out.println(rb.toString());
			}
		}
	}

	public static Map<String, List<Restaurante>> crearMapBarrios(List<Restaurante> lr) {
		Map<String, List<Restaurante>> mapa = new HashMap<>();

		// recorro la lista
		// si el barrio ya esta en el mapa añado restaurante a esa lista
		// si no creo lista nueva y añado ese restaurante

		for (Restaurante r : lr) {
			List<Restaurante> lrb = mapa.get(r.getBarrio());
			if (lrb != null) {
				System.out.println("Ya existen restaurantes con ese barrio");
				lrb.add(r);
			} else {
				List<Restaurante> lnueva = new ArrayList<>();
				lnueva.add(r);
				mapa.put(r.getBarrio(), lnueva);
			}
		}
		return mapa;
	}

	// partiendo del mapa de restaurantes por barrio,
	// hacer un metodo que me devuelva los restaurantes mas caros de cada barrio.

	public static List<Restaurante> getRestMasCaros(Map<String, List<Restaurante>> mapaRestMasCaros) {
		List<Restaurante> listaCaros = new ArrayList<>();

		// TODO recorrer el mapa por barrios y quedarme con el mas caro de cada barrio.

		Set<String> barrios = mapaRestMasCaros.keySet();
		for (String barrio : barrios) {
			List<Restaurante> lrb = mapaRestMasCaros.get(barrio);
			Restaurante rmascaro = obtenerMasCaro(lrb);
			listaCaros.add(rmascaro);
		}

		return listaCaros;
	}

	private static Restaurante obtenerMasCaro(List<Restaurante> lrb) {
		Restaurante restMasCaro = null;
		float precioMayor = 0;

		for (Restaurante r : lrb) {
			if (r.getPrecioMedio() > precioMayor) {
				restMasCaro = r;
				precioMayor = r.getPrecioMedio();
			}
		}

		return restMasCaro;
	}

	private static Restaurante obtenerMasCaro2(List<Restaurante> lrb) {
		Restaurante restMasCaro = null;

		Collections.sort(lrb);
		restMasCaro = lrb.get(lrb.size() - 1);

		return restMasCaro;
	}

}