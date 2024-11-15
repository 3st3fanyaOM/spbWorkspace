package com.example.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Hotel;
import com.example.demo.repositorio.HotelRepositorio;

@Service
public class HotelService {

	@Autowired
	private HotelRepositorio repo;

	public List<Hotel> listarHoteles() {
		return repo.listarHoteles();
	}

	public Hotel insertarHotel(Hotel h) {
		return repo.insertarHotel(h);
	}

	public Hotel listarPorId(int id) {
		return repo.listarPorId(id);
	}

	public boolean borrarHotel(int id) {
		return repo.borrarHotel(id);
	}

	public Hotel actualizarHotel(Hotel h) {
		return repo.actualizarHotel(h);
	}

	public List<Hotel> hotelesRangoEstrellas(int minEstrellas, int maxEstrellas) 
		return repo.hotelesRangoEstrellas(minEstrellas,maxEstrellas);
	}

	public Hotel hotelPorTelefono(String telefono) {
		// TODO Auto-generated method stub
		return repo.hotelPorTelefono(telefono);
	}

	public boolean borrarHotelNombre(String nombre) {
		// TODO Auto-generated method stub
		return repo.borrarHotelNombre(nombre);
	}
}
