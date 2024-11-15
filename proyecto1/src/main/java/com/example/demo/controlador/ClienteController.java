package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteServiceImpl;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteServiceImpl servicio;

	@GetMapping
	public ResponseEntity<List<Cliente>> getClientes() {
		List<Cliente> clientes = servicio.getClientes();
		return ResponseEntity.ok(clientes);

	}
	
	@PostMapping
	public ResponseEntity<Void> addCliente(@RequestBody Cliente cliente){
		servicio.addCliente(cliente);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Cliente> clienteId(@PathVariable int id){
		Cliente c =servicio.clienteId(id);
		return ResponseEntity.ok(c);
	}
}
