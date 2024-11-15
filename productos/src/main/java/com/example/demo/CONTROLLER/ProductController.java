package com.example.demo.CONTROLLER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> lista = service.getProducts();
		return ResponseEntity.ok(lista);
	}

	@PostMapping
	public ResponseEntity<Product> addProduct(@RequestBody Product p) {
		service.addProduct(p);
		return ResponseEntity.ok(p);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id) {
		Product p = service.getProductById(id);
		if (p == null) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
		if (service.deleteProduct(id)) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProductComplete(@PathVariable int id, @RequestBody Product p) {
		p.setId(id);
		Product pActualizado = service.updateProductComplete(p);
		if (pActualizado == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(pActualizado);
		}
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Product> updateProductPartial(@PathVariable int id, @RequestBody Product p) {
		Product pExistent = service.getProductById(id);
		if (pExistent == null) {
			return ResponseEntity.notFound().build();
		}
		if (p.getName() == null) {
			pExistent.setName(p.getName());
		}
		if (p.getPrice() == 0.0) {
			pExistent.setPrice(p.getPrice());
		}

		Product pActualizProduct = service.updateProductPartial(pExistent);
		return ResponseEntity.ok(pActualizProduct);
	}

	@GetMapping("/productByName/{nombre}")
	public ResponseEntity<List<Product>> getproductByName(@PathVariable String name) {

		List<Product> list = service.getproductByName(name);
		if (list.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(list);
	}

	@GetMapping("/priceRange/{prices}")
	public ResponseEntity<List<Product>> getProductsByPriceRange(@PathVariable float price1,
			@PathVariable float price2) {

		List<Product> list = service.getProductsByPriceRange(price1, price2);
		if (list.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(list);
	}

	@PostMapping("/{lista}")
	public ResponseEntity<Void> addListProduct(@RequestBody List<Product> products) {
		Product pExists = new Product();
		for (Product p : products) {
			if (p.getId() == pExists.getId()) {
				service.updateProductComplete(p);
				return ResponseEntity.noContent().build();
			} else {
				service.addProduct(p);
				return ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.notFound().build();

	}
}
