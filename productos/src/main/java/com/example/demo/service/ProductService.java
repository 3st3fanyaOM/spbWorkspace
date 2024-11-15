package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.productRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductService {

	@Autowired
	private productRepository repo;

	public List<Product> getProducts() {
		return repo.getProducts();
	}

	@Transactional
	public Product addProduct(Product p) {
		return repo.addProduct(p);

	}

	public Product getProductById(int id) {
		return repo.getProductById(id);
	}

	@Transactional
	public boolean deleteProduct(int id) {
		return repo.deleteProduct(id);
	}

	@Transactional
	public Product updateProductComplete(Product p) {
		return repo.updateProduct(p);
	}

	@Transactional
	public Product updateProductPartial(Product p) {
		return repo.updateProduct(p);
	}

	public List<Product> getproductByName(String name) {
		return repo.getproductByName(name);
	}

	public List<Product> getProductsByPriceRange(float price1, float price2) {
		return repo.getProductsByPriceRange(price1,price2);
	}

}
