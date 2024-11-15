package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")//si fueran iguales los nombres no hace falta poner el name
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//genera id automat
	@Column //coincide con la tabla, no hay que poner name
	private int id;
	@Column//(name = "nombre")si no coincidiese
	private String nombre;
	@Column
	private String apellidos;

	public Cliente() {
		super();
	}

	public Cliente(int id, String nombre, String apellidos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

}
