package com.spring.app.activo.es.modelo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.app.activo.es.dao.TipoDao;
import com.spring.app.activo.es.modelo.entidad.TipoEntidad;
import com.spring.app.activo.es.modelo.service.facade.TipoFacade;

@Service
public class TipoService implements TipoFacade{

	@Autowired
	private TipoDao tipoDao;

	@Override
	public TipoEntidad buscarTipoPorId(Long id) {
		return tipoDao.findById(id).orElse(null);
	}
	
}
