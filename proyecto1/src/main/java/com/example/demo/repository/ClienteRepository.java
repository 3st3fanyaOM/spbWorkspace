package com.example.demo.repository;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ClienteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Cliente> getClientes(){
		Query<Cliente> query = (Query<Cliente>) entityManager.createQuery("select c from Cliente c", Cliente.class);
		List<Cliente> lista = query.getResultList();
		return lista;
	}
	
	//@Override
	public void addCliente(Cliente cliente) {
		entityManager.persist(cliente);
	}
	
	public Cliente clienteId(int id) {
		Cliente c = entityManager.find(Cliente.class, id);
		return c;
	}
	
}