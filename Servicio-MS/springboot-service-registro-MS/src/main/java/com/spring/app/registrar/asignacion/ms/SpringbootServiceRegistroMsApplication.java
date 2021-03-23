package com.spring.app.registrar.asignacion.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringbootServiceRegistroMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiceRegistroMsApplication.class, args);
	}

}
