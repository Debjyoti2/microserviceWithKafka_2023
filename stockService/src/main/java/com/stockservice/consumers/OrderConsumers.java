package com.stockservice.consumers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.orderservice.model.Order;
import com.orderservice.model.OrderEvent;
import com.stockservice.model.Stock;
import com.stockservice.service.StockService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderConsumers {
	
	@Autowired
	private StockService stockService;
	
	@KafkaListener(topics="order-topic", groupId = "order-consumer-group" )
	public void consumerOrder(OrderEvent orderEvent) {
		
		Order order = orderEvent.getOrder();
		
		Stock stock = stockService.updateStock(order.getName(),order.getQuantity());
		
		log.info("Current stock for item :: " + stock.getItemname() + "  and current stock  :: " + stock.getStock());
		
	}

}
