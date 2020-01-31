package com.eatza.restaurantsearch.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Sink.class)
public class MassegeReceiver {
	
	private static final Logger logger = LoggerFactory.getLogger(MassegeReceiver.class);
	
	@StreamListener("input")
	public void receiveMessage(SenderData data) {
		logger.info("Received message is : " + data);
	}
	
	
	
	
	/*@KafkaListener(topics = "${kafka-topic}", groupId="group_id", containerFactory="jsonkafkaListenerContainerFactory")
	public void receiveMessage(SenderData data) {

		System.out.println("received data='{}'"+ data);
		logger.info("received data='{}'", data);

	}*/

}
