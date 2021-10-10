package com.org.sportyshoes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.sportyshoes.entity.Product;
import com.org.sportyshoes.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public List<Product> displayAllProduct() {
		List<Product> products=new ArrayList<Product>();
		productRepository.findAll().forEach(product->products.add(product));
		return products;
	}
	
	public void addProduct(Product product) {
		productRepository.save(product);
	}
	
	public void delete(int id) {
		productRepository.deleteById(id);
	}
	
	public Product findProductById(int id) {
		return  productRepository.findById(id).get();
	}
	
	
	

}
