package com.orderservice.repos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.orderservice.model.Order;

public interface OrderRepo extends PagingAndSortingRepository<Order,Integer>{

}
