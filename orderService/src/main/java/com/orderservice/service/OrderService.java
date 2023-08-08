package com.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderservice.model.Order;
import com.orderservice.producers.OrderProducer;
import com.orderservice.repos.OrderRepo;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepo orderRepo;
	
	@Autowired
	private OrderProducer orderProducer;
	
	public Order saveOrder(Order order) {
		
		Order savedorder = orderRepo.save(order);
		
		orderProducer.sendOrder(savedorder);
		
		return savedorder;
	}

}
