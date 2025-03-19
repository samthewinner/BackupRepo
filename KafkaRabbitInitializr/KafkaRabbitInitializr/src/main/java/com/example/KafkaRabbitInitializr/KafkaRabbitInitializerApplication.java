package com.example.KafkaRabbitInitializr;

import com.example.KafkaRabbitInitializr.tut2.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KafkaRabbitInitializerApplication {
	@Autowired
	private RabbitMQProducer rabbitMQProducer;

// Sending a message


	public static void main(String[] args) {
		SpringApplication.run(KafkaRabbitInitializerApplication.class, args);
	}

	@Bean
	public ApplicationRunner applicationRunner(){
		return args -> {

			rabbitMQProducer.sendMessage("connected to RabbitMQ!");


		};
	}

}
