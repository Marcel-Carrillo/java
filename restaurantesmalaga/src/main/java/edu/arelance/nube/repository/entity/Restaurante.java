package edu.arelance.nube.repository.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "restaurantes")

public class Restaurante {

	@Id // Indico a spring que este sera la clave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) // autoInc en MySQL
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

	@Column(name = "creado_en")
	private LocalDateTime creadoEn;

	@PrePersist // Este metodo esta marcado con anotacion se ejecuta antes
	// de insertar el restaurante
	private void generarFechaDeCreacion() {
		this.creadoEn = LocalDateTime.now(); // Obtengo la fecha actual
	}

	@Override
	public String toString() {
		return "Restaurante [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", barrio=" + barrio
				+ ", web=" + web + ", fichaGoogle=" + fichaGoogle + ", latitud=" + latitud + ", longitud=" + longitud
				+ ", precioMedio=" + precioMedio + ", especialiadad1=" + especialiadad1 + ", especialiadad2="
				+ especialiadad2 + ", especialiadad3=" + especialiadad3 + ", creadoEn=" + creadoEn + "]";
	}

	public Restaurante(Long id, String nombre, String direccion, String barrio, String web, String fichaGoogle,
			Float latitud, Float longitud, Integer precioMedio, String especialiadad1, String especialiadad2,
			String especialiadad3, LocalDateTime creadoEn) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.barrio = barrio;
		this.web = web;
		this.fichaGoogle = fichaGoogle;
		this.latitud = latitud;
		this.longitud = longitud;
		this.precioMedio = precioMedio;
		this.especialiadad1 = especialiadad1;
		this.especialiadad2 = especialiadad2;
		this.especialiadad3 = especialiadad3;
		this.creadoEn = creadoEn;
	}

	public Restaurante() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getFichaGoogle() {
		return fichaGoogle;
	}

	public void setFichaGoogle(String fichaGoogle) {
		this.fichaGoogle = fichaGoogle;
	}

	public Float getLatitud() {
		return latitud;
	}

	public void setLatitud(Float latitud) {
		this.latitud = latitud;
	}

	public Float getLongitud() {
		return longitud;
	}

	public void setLongitud(Float longitud) {
		this.longitud = longitud;
	}

	public Integer getPrecioMedio() {
		return precioMedio;
	}

	public void setPrecioMedio(Integer precioMedio) {
		this.precioMedio = precioMedio;
	}

	public String getEspecialiadad1() {
		return especialiadad1;
	}

	public void setEspecialiadad1(String especialiadad1) {
		this.especialiadad1 = especialiadad1;
	}

	public String getEspecialiadad2() {
		return especialiadad2;
	}

	public void setEspecialiadad2(String especialiadad2) {
		this.especialiadad2 = especialiadad2;
	}

	public String getEspecialiadad3() {
		return especialiadad3;
	}

	public void setEspecialiadad3(String especialiadad3) {
		this.especialiadad3 = especialiadad3;
	}

	public LocalDateTime getCreadoEn() {
		return creadoEn;
	}

	public void setCreadoEn(LocalDateTime creadoEn) {
		this.creadoEn = creadoEn;
	}

}