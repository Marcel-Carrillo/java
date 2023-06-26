package edu.arelance.nube.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.arelance.nube.repository.entity.Restaurante;

/**
 * API WEB 
 * HTTP -> Deriva en la ejecucion de un método a traves de TOMCAT(recibe la peticion y enruta)
 *  y SPRING() 
 *
 *GET -----> (consulta) TODOS
 *GET -----> (consulta) Uno (por id)
 *POST ----> (inserta) Un restaurante nuevo
 *PUT -----> (modifica) Un restaurante que ya existe
 *DELETE --> (elimina) Un restaurante por (ID)
 *GET -----> (consulta) por barrio, por especialidad, por nombre, etc...
 */

//@Controller //devuelve una vista (html/jsp)
@RestController //devuelve un JSON (permite un uso mas dinamico de los datos de respuesta para
//despues representarlos o no, en definitiva es mas dinamico  http://localhost:8081/restaurante
@RequestMapping("/restaurante")
public class RestauranteController {
	
	@GetMapping("/test") // GET http://localhost:8081/restaurante/test
	public Restaurante obtenerRestauranteTest () {
		Restaurante restaurante = null;
		
		System.out.println("llamando a obtenerRestauranteTest");
		
		return restaurante;
	}
	
}
