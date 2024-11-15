/*package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.modelo.Cliente;

@RestController
public class UserController {

	private List<Cliente> clientes = new ArrayList<>();

	public UserController() {
		Cliente c1 = new Cliente(01, "Pedro", "pedro01", "1234");
		Cliente c2 = new Cliente(02, "Carlos", "carlos01", "1244");
		Cliente c3 = new Cliente(03, "Maria", "maria01", "4455");

		clientes.add(c1);
		clientes.add(c2);
		clientes.add(c3);

	}

	@GetMapping("/users")
	public List<Cliente> obtenerClientes() {
		return clientes;

	}

	@GetMapping("/users/{username}")
	public Cliente obtenerDatosCliente(@PathVariable String username) {
		for (Cliente cliente : clientes) {
			if (cliente.getUsername().equalsIgnoreCase(username)) {
				return cliente;
			}
		}
		return null;

	}
	
	@PostMapping("/users")
	public String postCliente(@RequestBody Cliente cliente) {
		clientes.add(cliente);
		return cliente.getNombre() +" añadido.";
	}
	
	@PutMapping("/users")//hay que mandar TODOS los campos
	public String putCliente(@RequestBody Cliente modificado) {
		for (Cliente cliente : clientes) {
			if(cliente.getId()==modificado.getId()) {
				cliente.setNombre(modificado.getNombre());
				cliente.setPassword(modificado.getPassword());
				cliente.setUsername(modificado.getUsername());
			}
		}
		return "Cliente modificado";
	}

	@DeleteMapping("/users/{id}")
	public String deleteCliente(@PathVariable int id) {
		Iterator<Cliente> it=clientes.iterator();
		while(it.hasNext()) {
			Cliente cliente = it.next();
			if(cliente.getId()==id) {
				it.remove();
				return "Cliente borrado";
			}
			
		}
		return null;
	}
	
	@PatchMapping("/users")//solo modifica un campo, el que no está null
	public Cliente patchcliente(@RequestBody Cliente modif) {
		for (Cliente cliente : clientes) {
			if(cliente.getId()==modif.getId()) {
				if(modif.getNombre()!=null) {
					System.out.println("Nombre");
					cliente.setNombre(modif.getNombre());
				}
				if(modif.getPassword()!=null) {
					System.out.println("Password");
					cliente.setPassword(modif.getPassword());
				}
				if(modif.getUsername()!=null) {
					System.out.println("Username");
					cliente.setUsername(modif.getUsername());
				}
			}
		}
		return modif;
	}
}*/