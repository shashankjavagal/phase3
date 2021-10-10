package com.org.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.sportyshoes.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
}
