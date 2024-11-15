package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hotel")
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String nombre;

	@Column
	private String direccionString;

	@Column
	private int estrellas;

	@Column
	private String telefono;

	@Column
	private String pagina_web;

	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hotel(int id, String nombre, String direccionString, int estrellas, String telefono, String pagina_web) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccionString = direccionString;
		this.estrellas = estrellas;
		this.telefono = telefono;
		this.pagina_web = pagina_web;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccionString() {
		return direccionString;
	}

	public void setDireccionString(String direccionString) {
		this.direccionString = direccionString;
	}

	public int getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPagina_web() {
		return pagina_web;
	}

	public void setPagina_web(String pagina_web) {
		this.pagina_web = pagina_web;
	}

}
