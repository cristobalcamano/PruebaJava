package com.spring.app.activo.es.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.app.activo.es.modelo.entidad.TipoEntidad;

public interface TipoDao extends CrudRepository<TipoEntidad, Long>{

}
