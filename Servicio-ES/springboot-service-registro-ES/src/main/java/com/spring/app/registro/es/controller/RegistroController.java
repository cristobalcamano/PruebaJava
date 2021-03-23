package com.spring.app.registro.es.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.app.registro.es.modelo.entidad.AsignacionEntidad;
import com.spring.app.registro.es.service.RegistroService;

@RestController
@RequestMapping("/registro")
public class RegistroController {

	@Autowired
	private RegistroService registroService;

	@GetMapping("/listar")
	public ResponseEntity<?> listar() {
		Map<String, Object> respuesta = new HashMap<>();
		List<AsignacionEntidad> asignaciones = null;
		try {
			asignaciones = registroService.listarAsignacion();
			respuesta.put("mensaje", "OK");
			respuesta.put("activos", asignaciones);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK);
		} catch (DataAccessException e) {
			respuesta.put("error", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/crear")
	public ResponseEntity<?> crearAsignacion(AsignacionEntidad asignacionEntity) {
		Map<String, Object> respuesta = new HashMap<>();
		try {
			asignacionEntity = registroService.crearAsignacion(asignacionEntity);
			respuesta.put("mensaje", "OK");
			respuesta.put("activos", asignacionEntity);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK);
		} catch (DataAccessException e) {
			respuesta.put("error", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
