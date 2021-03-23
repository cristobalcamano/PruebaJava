package com.spring.app.activo.es.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.app.activo.es.modelo.entidad.CiudadEntidad;

public interface CiudadDao  extends CrudRepository<CiudadEntidad, Long>{

}
