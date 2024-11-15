package com.example.demo.repository;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class productRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Product> getProducts() {
		Query<Product> query = (Query<Product>) entityManager.createQuery("select c form product c", Product.class);
		List<Product> lista = query.getResultList();
		return lista;
	}

	public Product addProduct(Product p) {
		entityManager.persist(p);
		return p;
	}

	public Product getProductById(int id) {
		Product p = entityManager.find(Product.class, id);
		return p;
	}

	public boolean deleteProduct(int id) {
		Product p = getProductById(id);
		if (p != null) {
			return true;
		}
		return false;
	}

	public Product updateProduct(Product p) {
		return entityManager.merge(p);
	}

	public List<Product> getproductByName(String name) {
		String jpql = "select c from Product c WHERE c.name LIKE :name";
		Query<Product> query = (Query<Product>) entityManager.createQuery(jpql, Product.class);
		query.setParameter("name", "%" + name + "%");
		return query.getResultList();
	}

	public List<Product> getProductsByPriceRange(float price1, float price2) {
		String jpql = "select c from Product c WHERE c.price between :price1 and :price2";
		Query<Product> query = (Query<Product>) entityManager.createQuery(jpql, Product.class)
				.setParameter("price1", price1).setParameter("price2", price2);
		List<Product> list = query.getResultList();
		return list;
	}

}
