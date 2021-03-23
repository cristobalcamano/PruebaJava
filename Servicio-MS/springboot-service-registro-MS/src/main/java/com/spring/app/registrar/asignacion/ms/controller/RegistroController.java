package com.spring.app.registrar.asignacion.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.app.registrar.asignacion.ms.modelo.entidad.Asignacion;
import com.spring.app.registrar.asignacion.ms.modelo.service.RegistroService;

@RestController
public class RegistroController {

	@Autowired
	private RegistroService feingRegistroServiceFeing;
	
	@PostMapping("/crear")
	public Asignacion feingRegistroServiceFeing(@RequestBody Asignacion asignacion) {
		
		return feingRegistroServiceFeing.crearAsignacion(asignacion);
	}
	
	
}
