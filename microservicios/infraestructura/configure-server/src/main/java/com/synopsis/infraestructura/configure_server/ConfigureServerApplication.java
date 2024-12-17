package com.synopsis.infraestructura.configure_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigureServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigureServerApplication.class, args);
	}

}
