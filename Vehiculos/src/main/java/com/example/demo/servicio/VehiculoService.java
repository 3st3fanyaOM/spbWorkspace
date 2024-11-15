package com.example.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Vehiculo;
import com.example.demo.repositorio.VehiculoRepositorio;

@Service
public class VehiculoService {
	
	@Autowired
	private VehiculoRepositorio repo;

	public List<Vehiculo> getVehiculos() {
		return repo.getVehiculos();
	}

	public void addVehiculo(Vehiculo v) {
		repo.addVehiculo(v);
		
	}

	public Vehiculo vehiculoPorId(int id) {
		Vehiculo v = repo.vehiculoPorId(id);
		return v;
	}

	public void actualizarVehiculo(Vehiculo v) {
		repo.actualizarVehiculo(v);

	}

}
