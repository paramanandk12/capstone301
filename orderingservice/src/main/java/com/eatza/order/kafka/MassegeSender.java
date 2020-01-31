package com.eatza.order.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@EnableBinding(Source.class)
public class MassegeSender {
	
			
			@Autowired
			MessageChannel output;
			/*@Autowired
			private KafkaTemplate<String, SenderData> kafkaTemplate;*/
			private static final Logger LOG = LoggerFactory.getLogger(MassegeSender.class);
			
			/*@Value(value = "${kafka-topic}") 
			private String topic;*/
			
			public SenderData sendMessage(@RequestBody SenderData data){
				output.send(MessageBuilder.withPayload(data).build());
				LOG.info("sending data='{}' to topic='{}'", data);
				return data;
				
			}


	/*public void sendMessage(SenderData data) {
		LOG.info("sending data='{}' to topic='{}'", data, topic);

		Message<SenderData> message = MessageBuilder.withPayload(data)
				.setHeader(KafkaHeaders.TOPIC, topic).build();
		
		kafkaTemplate.send(message);
	}*/

}
