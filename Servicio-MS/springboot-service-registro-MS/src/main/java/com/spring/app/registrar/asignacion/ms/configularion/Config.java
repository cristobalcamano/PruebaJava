package com.spring.app.registrar.asignacion.ms.configularion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

	@Bean("clienteRest")
	public RestTemplate registarAsignacion() {
		return new RestTemplate();
	}
	
}
