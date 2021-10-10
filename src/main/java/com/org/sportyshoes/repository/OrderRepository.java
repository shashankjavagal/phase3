package com.org.sportyshoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.org.sportyshoes.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{
	@Query("SELECT o FROM orderdetails o where o.product.category=?1")
	public List<Order> filterOrderByCategory(String category);
	
	@Query("SELECT o FROM orderdetails o where o.date=?1")
	public List<Order> filterOrderByDate(String date);
	
	@Query("SELECT o FROM orderdetails o where o.product.category=?1 and o.date=?2")
	public List<Order> filterOrderByCategoryAndDate(String category,String date);
	
	

}
