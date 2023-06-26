package edu.arelance.nube.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "restaurantes")

public class Restaurante {

	@Id //Indico a spring que este sera la clave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) //autoInc en MySQL
	private Long id;
	
	private String nombre;
	
	private String direccion;
	
	private String barrio;
	
	private String web;
	
	private String fichaGoogle;
	
	private Float latitud;
	
	private Float longitud;
	
	private Integer precioMedio;
	
	private String especialiadad1;
	
	private String especialiadad2;
	
	private String especialiadad3;
	
}
