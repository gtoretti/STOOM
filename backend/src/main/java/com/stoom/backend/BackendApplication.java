package com.stoom.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.kafka.clients.admin.NewTopic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.context.annotation.Bean;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.SeekToCurrentErrorHandler;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;

import com.stoom.backend.service.AddressService;
import com.stoom.backend.entity.Address;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	private final Logger logger = LoggerFactory.getLogger(BackendApplication.class);
	
    @Autowired
    private AddressService addressService;
	
    ObjectMapper objectMapper = new ObjectMapper();
    
	@Bean
	public NewTopic createAdressTopic() {
		return new NewTopic("createAdress", 1, (short) 1);
	}
	
	@Bean
	public NewTopic updateAddressTopic() {
		return new NewTopic("updateAddress", 1, (short) 1);
	}
	
	@KafkaListener(id = "createUpdateAdress", topics = "createUpdateAdress")
	public void createListen(String json) throws Exception {
		Address address = objectMapper.readValue(json, Address.class);
		addressService.create(address);
		logger.info("Kafka Created Address: " + address);
    }

	@Bean
	public NewTopic deleteAddressTopic() {
		return new NewTopic("deleteAddress", 1, (short) 1);
	}

	@KafkaListener(id = "deleteAddress", topics = "deleteAddress")
	public void deleteListen(String id) throws Exception {
		addressService.delete(Integer.parseInt(id));
		logger.info("Kafka Deleted Address Id: " + id);		
    }	
}
