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

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	private final Logger logger = LoggerFactory.getLogger(BackendApplication.class);
	
	//kafta consuming: only logging as example
	private final TaskExecutor exec = new SimpleAsyncTaskExecutor();
	
	@Bean
	public NewTopic addressTopicCreate() {
		return new NewTopic("address-topic-create", 1, (short) 1);
	}
	
	@KafkaListener(id = "create-group", topics = "address-topic-create")
	public void createListen(String in) {
		logger.info("Kafka received Created Address: " + in);
    }

	@Bean
	public NewTopic addressTopicUpdate() {
		return new NewTopic("address-topic-update", 1, (short) 1);
	}

	@KafkaListener(id = "update-group", topics = "address-topic-update")
	public void updateListen(String in) {
		logger.info("Kafka received Updated Address: " + in);
    }	

	@Bean
	public NewTopic addressTopicDelete() {
		return new NewTopic("address-topic-delete", 1, (short) 1);
	}

	@KafkaListener(id = "delete-group", topics = "address-topic-delete")
	public void deleteListen(String in) {
		logger.info("Kafka received Deleted Address: " + in);
    }	
}
