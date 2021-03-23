package com.spring.app.activo.es.modelo.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.app.activo.es.dao.ActivoDao;
import com.spring.app.activo.es.modelo.entidad.ActivoEntidad;
import com.spring.app.activo.es.modelo.entidad.EstadoEntidad;
import com.spring.app.activo.es.modelo.service.facade.ActivoFacade;

@Service
public class ActivoService implements ActivoFacade {

	@Autowired
	private ActivoDao activoDao;
	
	@Override
	@Transactional
	public List<ActivoEntidad> verActivos() {
		return (List<ActivoEntidad>) activoDao.findAll();
	}

	@Override
	public ActivoEntidad buscarActivo(Long id) {
		return (ActivoEntidad) activoDao.findById(id).orElse(null);
	}

	@Override
	public ActivoEntidad crearActivo(ActivoEntidad activoE) {
		activoE.setFechaCompra(new Date());
		return activoDao.save(activoE);
	}

	@Override
	public ActivoEntidad actualizarActivo(ActivoEntidad activoE, Long id) {
		ActivoEntidad activo = (ActivoEntidad) activoDao.findById(id).orElse(null);
		activo = validarActivo(activo, activoE);
		return activoDao.save(activoE);
	}

	private ActivoEntidad validarActivo(ActivoEntidad activoBD, ActivoEntidad activoPeticion) {
		
		if (activoPeticion.getAlto() != null) {
			activoBD.setAlto(activoPeticion.getAlto());
		}
		if (activoPeticion.getAncho() != null) {
			activoBD.setAncho(activoPeticion.getAncho());
		}
		if (activoPeticion.getColor() != null) {
			activoBD.setColor(activoPeticion.getColor());
		}
		if (activoPeticion.getDescripcion() != null) {
			activoBD.setDescripcion(activoPeticion.getDescripcion());
		}
		if (activoPeticion.getFechaDeBaja() != null) {
			activoBD.setFechaDeBaja(activoPeticion.getFechaDeBaja());
		}
		if (activoPeticion.getLargo() != null) {
			activoBD.setLargo(activoPeticion.getLargo());
		}
		if (activoPeticion.getNombre() != null) {
			activoBD.setNombre(activoPeticion.getNombre());
		}
		if (activoPeticion.getPeso() != null) {
			activoBD.setPeso(activoPeticion.getPeso());
		}
		if (activoPeticion.getSerial() != null) {
			activoBD.setSerial(activoPeticion.getSerial());
		}
		if (activoPeticion.getEstado() != null &&
				activoPeticion.getEstado().getId() != null) {
			activoBD.setEstado(new EstadoEntidad(activoPeticion.getEstado().getId()));
			/*Estados
			 *  1 = activo - 2 = dado de baja - 3 = en reparación - 4 = disponible - 5 = asignado */
			if (activoPeticion.getEstado().getId() == 2) {
				activoBD.setFechaDeBaja(new Date());
			}
		}
		
		return activoBD;
	}

	@Override
	public List<ActivoEntidad> buscarActivoPorTipo(String nombre) {
		// TODO Auto-generated method stub
		return activoDao.buscarActivoPorTipo(nombre);
	}

	@Override
	public List<ActivoEntidad> buscarActivoPorSerial(String tipo) {
		// TODO Auto-generated method stub
		return activoDao.buscarActivoPorSerial(tipo);
	}

	@Override
	public List<ActivoEntidad> buscarActivoPorFechacompra(Date date) {
		// TODO Auto-generated method stub
		return activoDao.buscarActivoPorFechacompra(date);
	}
	
}
