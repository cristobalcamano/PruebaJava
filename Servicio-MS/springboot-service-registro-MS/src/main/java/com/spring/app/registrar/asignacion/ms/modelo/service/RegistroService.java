package com.spring.app.registrar.asignacion.ms.modelo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring.app.registrar.asignacion.ms.clientes.AsignacionClienteRest;
import com.spring.app.registrar.asignacion.ms.facade.RegistroFacade;
import com.spring.app.registrar.asignacion.ms.modelo.entidad.Asignacion;

@Service
public class RegistroService implements RegistroFacade{

	@Autowired
	private RestTemplate clienteRest;
	
	@Override
	public Asignacion crearAsignacion(Asignacion asignacion) {
		try {
			Asignacion respuesta = clienteRest.postForObject(null, asignacion, Asignacion.class );
			
			return respuesta;
		} catch (Exception e) {
			return null;
		}
		
	}

}
