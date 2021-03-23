package com.spring.app.activo.es.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.app.activo.es.modelo.entidad.EstadoEntidad;

public interface EstadoDao  extends CrudRepository<EstadoEntidad, Long>{

}
