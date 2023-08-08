package com.stockservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockservice.model.Stock;
import com.stockservice.repo.StockRepo;

@Service
public class StockService {
	
	@Autowired
	private StockRepo stockRepo;
	
	public Stock updateStock(String itemName,Integer qty) {
		
		Stock currentstock = stockRepo.findById(itemName).orElse(new Stock());
		currentstock.setStock(currentstock.getStock()-qty);
		stockRepo.save(currentstock);
		
		return currentstock;
		
	}
	

}
