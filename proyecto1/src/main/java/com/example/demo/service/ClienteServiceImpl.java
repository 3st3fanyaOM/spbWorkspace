package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteServiceImpl {

	@Autowired
	private ClienteRepository repo;
	
	//@Transactional
	public List<Cliente> getClientes(){
		return repo.getClientes();
	}
	
	@Transactional
	public void addCliente(Cliente cliente) {
		 repo.addCliente(cliente);
	}
	
	//@Transactional
	public Cliente clienteId(int id) {
		return repo.clienteId(id);
	}
}
