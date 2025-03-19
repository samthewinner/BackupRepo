package com.example.Igniteclient;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.ClientConnectorConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.cache.Cache;

@SpringBootApplication
public class IgniteclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(IgniteclientApplication.class, args);
	}

	@Autowired
	private Ignite ignite;

	@Bean
	public ApplicationRunner applicationRunner (){
		return args -> {
			System.out.println("Hello");
			Cache cache = ignite.getOrCreateCache("c1");
			cache.put("Hi","Mom");
			System.out.println("From cache: "+cache.get("Hi"));
			System.out.println(ignite.);
		};
	}
}
