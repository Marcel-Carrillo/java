package edu.arelance.nube.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.arelance.nube.repository.entity.Restaurante;


@Repository
public interface RestauranteRepository extends CrudRepository<Restaurante, Long>{
	
	//1 KEY WORDL QUERIES - CONSULTAS POR PALABRAS CLAVE
	//obtener restaurantes en un rango de precio
	
	Iterable<Restaurante> findByPrecioMedioBetween (int precioMin, int precioMax);
	
	//Iterable<Restaurante> findByNombreOrBarrioOrEspecialidad1OrEspecialidad2OrEspecialidad3IgnoreCase (String palabraBuscada);
	
	Iterable<Restaurante> findByNombreOrBarrioOrEspecialidad1IgnoreCase (String palabraBuscada1, String palabraBuscada2, String palabraBuscada3);
	
	
	//2 JPQL - HQL - Pseudo SQL pero de JAVA - "Agnostico"
	//3 NATIVAS -SQL
	
	@Query(value = "SELECT * FROM bdrestaurantes.restaurantes WHERE barrio LIKE %?1% OR nombre LIKE %?1% OR especialidad1 LIKE %?1% OR especialidad2 LIKE %?1% OR especialidad3 LIKE %?1%", nativeQuery = true)
	Iterable<Restaurante> buscarPorBarrioNombreOEspecialida (String clave);
	//4 STORED PROCEDURES - Procedimientos Almacenados
	//5 CRITERIA API - SQL pero con metodos de JAVA https://www.arquitecturajava.com/jpa-criteria-api-un-enfoque-diferente
}
