package com.orderservice.topics;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicsConfig {
	
	@Value("${topicName1}")
	private String topicName1;

	@Bean
	public NewTopic order_topic(){
		return TopicBuilder
				.name(topicName1)
				.partitions(3)
				.replicas(2)
				.build();
				
	}
	
	
}
