package com.stockservice.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.stockservice.model.Stock;

public interface StockRepo extends PagingAndSortingRepository<Stock,String>{

}
