package com.spring.app.activo.es.modelo.service.facade;

import java.util.Date;
import java.util.List;

import com.spring.app.activo.es.modelo.entidad.ActivoEntidad;

public interface ActivoFacade {

	public List<ActivoEntidad> verActivos();

	public ActivoEntidad buscarActivo(Long id);
	
	public ActivoEntidad crearActivo(ActivoEntidad activoE);
	
	public ActivoEntidad actualizarActivo(ActivoEntidad activoE,Long id);
	
	public List<ActivoEntidad> buscarActivoPorTipo(String id);

	public List<ActivoEntidad>  buscarActivoPorSerial(String tipo); 

	public List<ActivoEntidad>  buscarActivoPorFechacompra(Date date); 
	
}
