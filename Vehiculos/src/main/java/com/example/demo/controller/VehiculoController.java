package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Vehiculo;
import com.example.demo.servicio.VehiculoService;

@RestController
@RequestMapping("/coches")
public class VehiculoController {
	
	@Autowired
	private VehiculoService servicio;
	
	@PostMapping
	public ResponseEntity<Void> addVehiculo(@RequestBody Vehiculo v){
		servicio.addVehiculo(v);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Vehiculo> vehiculoPorId(@PathVariable int id){
		Vehiculo v = servicio.vehiculoPorId(id);
		if(v ==null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(v);
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Vehiculo>> getVehiculos(){
		List<Vehiculo> vehiculos = servicio.getVehiculos();
		return ResponseEntity.ok(vehiculos);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> actualizarVehiculo(@PathVariable int id, @RequestBody Vehiculo v){
		v.setId(id);
		Vehiculo vehiculoExistente = servicio.actualizarVehiculo(v);
		if(vehiculoExistente == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok().build();
		}
	}

}
