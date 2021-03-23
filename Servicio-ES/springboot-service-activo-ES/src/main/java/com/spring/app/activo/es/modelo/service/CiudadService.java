package com.spring.app.activo.es.modelo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.app.activo.es.dao.CiudadDao;
import com.spring.app.activo.es.modelo.entidad.CiudadEntidad;
import com.spring.app.activo.es.modelo.service.facade.CiudadFacade;

@Service
public class CiudadService implements CiudadFacade{

	@Autowired
	private CiudadDao  ciudadDao;

	@Override
	public CiudadEntidad buscarCiudadPorId(Long id) {
		return ciudadDao.findById(id).orElse(null);
	}
	
	
	
}
