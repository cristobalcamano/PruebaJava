package com.spring.app.registro.es.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.app.registro.es.dao.RegistroDao;
import com.spring.app.registro.es.modelo.entidad.AsignacionEntidad;

@Service
public class RegistroService {

	@Autowired
	private RegistroDao registroDao;

	public AsignacionEntidad crearAsignacion(AsignacionEntidad asignacionEntity) {
		asignacionEntity.setFecha(new Date());
		return registroDao.save(asignacionEntity);
	}

	public AsignacionEntidad verAsignacion(Long id) {
		return (AsignacionEntidad) registroDao.findById(id).orElse(null);
	}

	public List<AsignacionEntidad> listarAsignacion() {
		return (List<AsignacionEntidad>) registroDao.findAll();
	}
	
}
