package com.org.sportyshoes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.sportyshoes.entity.Order;
import com.org.sportyshoes.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	public void orderProduct(Order order) {
	 orderRepository.save(order);
	}
	
	public List<Order> purchaseHistory(){
		List<Order> orders=new ArrayList<Order>();
		orderRepository.findAll().forEach(order->orders.add(order));;
		return orders;
	}
	
	public List<Order> filterOrderHistoryByCategory(String category){
		List<Order> orders=new ArrayList<Order>();
		orderRepository.filterOrderByCategory(category).forEach(order->orders.add(order));;
		return orders;
	}
	
	public List<Order> filterOrderHistoryByDate(String date){
		List<Order> orders=new ArrayList<Order>();
		orderRepository.filterOrderByDate(date).forEach(order->orders.add(order));;
		return orders;
	}
	
	public List<Order> filterOrderHistoryByCategoryAndDate(String category,String date ){
		List<Order> orders=new ArrayList<Order>();
		orderRepository.filterOrderByCategoryAndDate(category, date).forEach(order->orders.add(order));;
		return orders;
	}
	
	

}
