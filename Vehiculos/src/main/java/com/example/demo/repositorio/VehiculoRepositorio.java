package com.example.demo.repositorio;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;


import com.example.demo.model.Vehiculo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class VehiculoRepositorio {

	@PersistenceContext
	private EntityManager entityManager;

	public void addVehiculo(Vehiculo v) {
		entityManager.persist(v);
	}

	public List<Vehiculo> getVehiculos() {
		Query<Vehiculo> query = (Query<Vehiculo>) entityManager.createQuery("select c from Vehiculo c", Vehiculo.class);
		List<Vehiculo> vehiculos = query.getResultList();
		return vehiculos;
	}

	public Vehiculo vehiculoPorId(int id) {
		Vehiculo v = entityManager.find(Vehiculo.class, id);
		return v;
	}

	public void actualizarVehiculo(Vehiculo v) {
		entityManager.merge(v);
		
	}

}
