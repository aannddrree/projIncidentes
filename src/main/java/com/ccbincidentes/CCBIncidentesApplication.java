package com.ccbincidentes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CCBIncidentesApplication {

	//Inicializa a aplicação
	public static void main(String[] args) {
		SpringApplication.run(CCBIncidentesApplication.class, args);
	}
}
