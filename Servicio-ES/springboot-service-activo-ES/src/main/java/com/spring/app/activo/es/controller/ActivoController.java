package com.spring.app.activo.es.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.app.activo.es.modelo.entidad.ActivoEntidad;
import com.spring.app.activo.es.modelo.service.ActivoService;
import com.spring.app.activo.es.modelo.service.CiudadService;
import com.spring.app.activo.es.modelo.service.EstadoService;
import com.spring.app.activo.es.modelo.service.TipoService;

@RestController
@RequestMapping("/activo")
public class ActivoController {

	@Autowired
	private ActivoService activoService;
	@Autowired
	private EstadoService estadoService;
	@Autowired
	private CiudadService ciudadService;
	@Autowired
	private TipoService tipoService;

	@GetMapping("/listar")
	public ResponseEntity<?> VerActivos(@RequestParam String filtro,@RequestParam String valor) {
		Map<String, Object> respuesta = new HashMap<>();
		List<ActivoEntidad> activos = null;
		try {
			if (filtro != null && valor != null) {
				if (filtro.equalsIgnoreCase("tipo")) {
					activos = activoService.buscarActivoPorTipo(valor);
				}else if (filtro.equalsIgnoreCase("fecha-compra")) {
					SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			        Date fechaDate = null;
			        fechaDate = formato.parse(valor);
					activos = activoService.buscarActivoPorFechacompra(fechaDate);
				}else if (filtro.equalsIgnoreCase("serial")) {
					activos = activoService.buscarActivoPorSerial(valor);
				}else {activos = activoService.verActivos();}
				
			}else {
				activos = activoService.verActivos();
			}
		} catch (DataAccessException e) {
			respuesta.put("error", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			respuesta.put("error", "Formato de fecha invalido: dd/MM/yyy");
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (activos.isEmpty()) {
			respuesta.put("mensaje", "No se encontraron registros");
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
		}
		respuesta.put("mensaje", "OK");
		respuesta.put("activos", activos);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarActivos(@PathVariable Long id) {
		Map<String, Object> respuesta = new HashMap<>();
		ActivoEntidad activo = null;
		try {
			activo = activoService.buscarActivo(id);
		} catch (DataAccessException e) {
			respuesta.put("error", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (activo == null) {
			respuesta.put("mensaje", "No se encontraro registro");
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
		}
		respuesta.put("mensaje", "No se encontraron registros");
		respuesta.put("activo", activo);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK);

	}

	@PostMapping("/crear")
	public ResponseEntity<?> crear(@RequestBody ActivoEntidad activo) {
		Map<String, Object> respuesta = new HashMap<>();

		ActivoEntidad activoBD = null;
		try {
			Map<String, Object> validacionActivo =ValidateActivo(activo, "crear");
			if (!(Boolean) validacionActivo.get("status")) {
				respuesta.put("error", validacionActivo.get("mensaje"));
				return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
			}
			activoBD = activoService.crearActivo(activo);
		} catch (DataAccessException e) {
			respuesta.put("error", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (activo == null) {
			respuesta.put("mensaje", "No se creo el registro");
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
		}
		respuesta.put("mensaje", "OK");
		respuesta.put("activo", activoBD);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<?> actualizar(@RequestBody ActivoEntidad activo, @PathVariable Long id) {
		Map<String, Object> respuesta = new HashMap<>();

		ActivoEntidad activoBD = null;
		try {
			Map<String, Object> validacionActivo =ValidateActivo(activoBD, "actualizar");
			if (!(Boolean) validacionActivo.get("status")) {
				respuesta.put("error", "mensaje");
				return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
			}
			activoBD = activoService.actualizarActivo(activo,id);
		} catch (DataAccessException e) {
			respuesta.put("error", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}catch (Exception e) {
			respuesta.put("error", "Error desconocido");
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (activo == null) {
			respuesta.put("mensaje", "No se creo el registro");
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
		}
		respuesta.put("mensaje", "OK");
		respuesta.put("activo", activoBD);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}

	private Map<String, Object> ValidateActivo(ActivoEntidad activo, String accion) {

		Map<String, Object> respuesta = new HashMap<String, Object>();
		if (accion.equalsIgnoreCase("actualizar")) {
			if (activo.getAlto() != null || activo.getAncho() != null || activo.getColor() != null
					|| activo.getDescripcion() != null || activo.getInventario() != null || activo.getLargo() != null
					|| activo.getNombre() != null || activo.getPeso() != null || activo.getSerial() != null
					|| activo.getValorCompra() != null) {
					respuesta.put("status", true);
					return respuesta;
			} else {
				if (activo.getEstado() == null && activo.getEstado().getId() == null
						) {
					if (estadoService.buscarEstadoPorId(activo.getEstado().getId()) == null) {
						respuesta.put("status", false);
						respuesta.put("mensaje", "Campo estado invalido");
						return respuesta;
					}
				}else {
					respuesta.put("status", false);
					respuesta.put("mensaje", "Campos invalido");
					return respuesta;
				}
			}
		}
		if (accion.equalsIgnoreCase("crear")) {
			if (activo.getAlto() != null && activo.getAncho() != null && activo.getColor() != null
					&& activo.getDescripcion() != null && activo.getInventario() != null && activo.getLargo() != null
					&& activo.getNombre() != null && activo.getPeso() != null && activo.getSerial() != null
					&& activo.getValorCompra() != null) {
				if (activo.getEstado() == null || activo.getEstado().getId() == null
						|| estadoService.buscarEstadoPorId(activo.getEstado().getId()) == null) {
					respuesta.put("status", false);
					respuesta.put("mensaje", "Campo estado invalido");
					return respuesta;
				}
			} else {
				respuesta.put("status", false);
				respuesta.put("mensaje", "Campos invalidos");
				return respuesta;
			}
			if (activo.getCiudad() == null || activo.getCiudad().getId() == null
					|| ciudadService.buscarCiudadPorId(activo.getCiudad().getId()) == null) {
				respuesta.put("status", false);
				respuesta.put("mensaje", "Campo ciudad invalido");
				return respuesta;
			}
			if (activo.getTipo() == null || activo.getTipo().getId() == null
					|| tipoService.buscarTipoPorId(activo.getTipo().getId()) == null) {
				respuesta.put("status", false);
				respuesta.put("mensaje", "Campo tipo invalido");
				return respuesta;
			}
		}
		respuesta.put("status", true);
		return respuesta;
	}
	
}
