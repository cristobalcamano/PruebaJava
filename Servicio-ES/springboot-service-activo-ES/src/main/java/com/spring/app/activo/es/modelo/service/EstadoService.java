package com.spring.app.activo.es.modelo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.app.activo.es.dao.EstadoDao;
import com.spring.app.activo.es.modelo.entidad.EstadoEntidad;
import com.spring.app.activo.es.modelo.service.facade.EstadoFacade;

@Service
public class EstadoService implements EstadoFacade{

	@Autowired
	private EstadoDao estadoDao;
	
	@Override
	public EstadoEntidad buscarEstadoPorId(Long id) {
		return estadoDao.findById(id).orElse(null);
	}

}
