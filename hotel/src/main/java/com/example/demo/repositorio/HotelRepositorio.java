package com.example.demo.repositorio;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.query.UnknownNamedQueryException;
import org.springframework.data.mapping.context.PersistentEntities;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class HotelRepositorio {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Hotel> listarHoteles() {
		Query<Hotel> query = (Query<Hotel>) entityManager.createQuery("select h from Hotel h", Hotel.class);
		List<Hotel> lista = query.getResultList();
		return lista;
	}

	public Hotel insertarHotel(Hotel h) {
		entityManager.persist(h);
		return h;
	}

	public Hotel listarPorId(int id) {
		Hotel hotel = entityManager.find(Hotel.class, id);
		return hotel;
	}

	public boolean borrarHotel(int id) {
		Hotel hotel = listarPorId(id);
		if (hotel != null) {
			entityManager.remove(hotel);
			return true;
		}
		return false;
	}

	public Hotel actualizarHotel(Hotel h) {
		return entityManager.merge(h);
	}

	public List<Hotel> hotelesRangoEstrellas(int minEstrellas, int maxEstrellas) {
		String jpql="select h from hotel h where h.estrellas between :minEstrellas and :maxEstrellas";
		Query<Hotel> query = (Query<Hotel>) entityManager.createQuery(jpql,Hotel.class);
		query.setParameterList("estrellas", minEstrellas,maxEstrellas);
	}

	public Hotel hotelPorTelefono(String telefono) {
		Hotel hotel = entityManager.find(Hotel.class, telefono);
		return hotel;
	}

	public boolean borrarHotelNombre(String nombre) {
		String sqld="select h form hotel h where h.nombre LIKE :nombre";
		Query<Hotel> query = (Query<Hotel>) entityManager.createQuery(sqld,Hotel.class);
		query.setParameter("nombre", "%"+nombre+"%");
		return query.getResultStream();
		
	}
	


}
