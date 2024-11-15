package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Hotel;
import com.example.demo.servicio.HotelService;

@RestController
@RequestMapping("/hoteles")
public class HotelController {

	@Autowired
	private HotelService servicio;

	@GetMapping
	public ResponseEntity<List<Hotel>> listarHoteles() {
		List<Hotel> lista = servicio.listarHoteles();
		return ResponseEntity.ok(lista);
	}

	@PostMapping
	public ResponseEntity<Hotel> insertarHotel(@RequestBody Hotel h) {
		servicio.insertarHotel(h);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Hotel> listarPorId(@PathVariable int id) {
		Hotel hotel = servicio.listarPorId(id);
		if (hotel == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@DeleteMapping
	public ResponseEntity<Hotel> borrarHotel(@PathVariable int id) {
		if (servicio.borrarHotel(id)) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> actualizarHotel(@PathVariable int id, @RequestBody Hotel h) {
		h.setId(id);
		Hotel actualizadoHotel = servicio.actualizarHotel(h);
		if (actualizadoHotel == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok().build();
		}
	}

	@GetMapping("/estrellas{min}{max}")
	public ResponseEntity<List<Hotel>> hotelesRangoEstrellas1(@PathVariable int minEstrellas,
			@PathVariable int maxEstrellas) {
		List<Hotel> estrellasHotels = servicio.hotelesRangoEstrellas(minEstrellas, maxEstrellas);
		if (estrellasHotels.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@GetMapping("/telefono/{telefono}")
	public ResponseEntity<Hotel> hotelPorTelefono(@PathVariable String telefono){
		Hotel h = servicio.hotelPorTelefono(telefono);
		if (h == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@DeleteMapping("/nombre/{nombre}")
	public ResponseEntity<Hotel> borrarHotelNombre(@PathVariable String nombre) {
		if (servicio.borrarHotelNombre(nombre)) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/lista")
	public ResponseEntity<List<Hotel>> insertarListaHoteles(@PathVariable List<Hotel> hoteles){
		
	}

}
