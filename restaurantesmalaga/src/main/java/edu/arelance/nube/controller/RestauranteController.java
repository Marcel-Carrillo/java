package edu.arelance.nube.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.arelance.nube.repository.entity.Restaurante;
import edu.arelance.nube.service.RestauranteService;

/**
 * API WEB HTTP -> Deriva en la ejecucion de un método a traves de TOMCAT(recibe
 * la peticion y enruta) y SPRING()
 *
 * GET -----> (consulta) TODOS http://localhost:8081/restaurante GET ----->
 * (consulta) Uno (por id) http://localhost:8081/restaurante/id POST ---->
 * (inserta) Un restaurante nuevo http://localhost:8081/restaurante (body
 * restaurante) PUT -----> (modifica) Un restaurante que ya existe
 * http://localhost:8081/restaurante/id (body restaurante) DELETE --> (elimina)
 * Un restaurante por (ID) http://localhost:8081/restaurante/id (consulta) por
 * barrio, por especialidad, por nombre, etc... anotacion @transactional para
 * controlar que los procesos de un metodo que interactuan BD se efectuen
 * completamente, si se hacen bien commit y se insertan los datos si no rollback
 * y no se hace nada.
 */

//@Controller //devuelve una vista (html/jsp)
@RestController // devuelve un JSON (permite un uso mas dinamico de los datos de respuesta para
//despues representarlos o no, en definitiva es mas dinamico  http://localhost:8081/restaurante
@RequestMapping("/restaurante")
public class RestauranteController {

	@Autowired
	RestauranteService restauranteService;

	@GetMapping("/test") // GET http://localhost:8081/restaurante/test
	public Restaurante obtenerRestauranteTest() {
		Restaurante restaurante = null;

		System.out.println("llamando a obtenerRestauranteTest");
		restaurante = new Restaurante(1l, "Martinete", "Carlos Haya 33", "Carranque", "www.martinete.org",
				"http://google.xe", 33.65f, -2.3f, 10, "gazpachuelo", "paella", "sopa de marisco", LocalDateTime.now());

		return restaurante;
	}

	// Consultar todos. Metodo GET a http://localhost:8081/restaurante/
	@GetMapping
	public ResponseEntity<?> obtenerListadoRestaurantes() {

		ResponseEntity<?> responseEntity = null;

		Iterable<Restaurante> lista_restaurantes = null;

		lista_restaurantes = this.restauranteService.consultarTodos();

		responseEntity = ResponseEntity.ok(lista_restaurantes);

		return responseEntity;
	}

	// Consultar 1 restaurante
	@GetMapping("/{id}")
	public ResponseEntity<?> listarPorId(@PathVariable Long id) {
		ResponseEntity<?> responseEntity = null;
		Optional<Restaurante> or = null;
		
		or = this.restauranteService.consultarRestaurante(id);
		if(or.isPresent()) {
			//la consulta a recuperado un registro
			Restaurante restauranteLeido = or.get();
			responseEntity = ResponseEntity.ok(restauranteLeido);
		}else {
			//la consulta no ha recuperado un registro
			responseEntity = ResponseEntity.noContent().build();
		}

		return responseEntity;
	}

	// Delete restaurante
	@DeleteMapping("/{id}")
	public ResponseEntity<?> borrarPorId(@PathVariable Long id) {
		ResponseEntity<?> responseEntity = null;
		this.restauranteService.borrarRestaurante(id);
		responseEntity = ResponseEntity.ok().build();
		
		return responseEntity;
	}

	// Post insertar en la base de datos 1 rest
	@PostMapping
	public ResponseEntity<?> insertarRestaurante(@RequestBody Restaurante restaurante) {
		ResponseEntity<?> responseEntity = null;
		Restaurante restauranteNuevo = null;
		
		restauranteNuevo = this.restauranteService.altaRestaurante(restaurante);
		responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(restauranteNuevo);
		
		return responseEntity;
	}

	// Put modifica en la base de datos 1 rest
	@PutMapping("/{id}")
	public ResponseEntity<?> modificarRestaurante(@RequestBody Restaurante restaurante, @PathVariable Long id) {
		ResponseEntity<?> responseEntity = null;
		return responseEntity;
	}

}
