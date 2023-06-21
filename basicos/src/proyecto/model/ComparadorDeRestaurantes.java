package proyecto.model;

import java.util.Comparator;

public class ComparadorDeRestaurantes implements Comparator<Restaurante> {

	@Override
	public int compare(Restaurante o1, Restaurante o2) {

		return o1.getNombre().compareTo(o2.getNombre());
	}

}
