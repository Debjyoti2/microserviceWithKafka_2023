package com.orderservice.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.orderservice.model.Order;
import com.orderservice.model.OrderEvent;

@Service
public class OrderProducer {
	
	@Autowired
	private KafkaTemplate<String,OrderEvent> kafkaTemplate;
	
	@Value("${topicName1}")
	private String topicName1;
	
	
	public void sendOrder(Order order) {
		
		OrderEvent orderEvent = new OrderEvent();
		orderEvent.setMessage("Order conming from order-service");
		orderEvent.setStatus("PENDING");
		orderEvent.setOrder(order);
		
		Message<OrderEvent> message = MessageBuilder
				                       .withPayload(orderEvent)
				                       .setHeader(KafkaHeaders.TOPIC, topicName1)
				                       .build();
		
		kafkaTemplate.send(message);
		
		
	}

}
