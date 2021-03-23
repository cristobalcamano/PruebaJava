package com.spring.app.activo.es.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.app.activo.es.modelo.entidad.ActivoEntidad;

public interface ActivoDao extends JpaRepository<ActivoEntidad, Long>{

	@Query("select a from ActivoEntidad a where a.tipo.nombre = ?1")
	public List<ActivoEntidad>  buscarActivoPorTipo(String nombre); 

	@Query("select a from ActivoEntidad a where a.serial = ?1")
	public List<ActivoEntidad>  buscarActivoPorSerial(String tipo); 

	@Query("select a from ActivoEntidad a where a.fechaCompra = ?1")
	public List<ActivoEntidad>  buscarActivoPorFechacompra(Date date); 
	
}
