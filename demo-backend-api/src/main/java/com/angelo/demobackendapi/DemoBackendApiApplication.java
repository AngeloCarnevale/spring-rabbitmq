package com.angelo.demobackendapi;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class DemoBackendApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoBackendApiApplication.class, args);
	}

}
