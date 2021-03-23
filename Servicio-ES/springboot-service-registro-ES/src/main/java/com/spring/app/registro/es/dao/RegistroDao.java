package com.spring.app.registro.es.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.app.registro.es.modelo.entidad.AsignacionEntidad;

public interface RegistroDao extends CrudRepository<AsignacionEntidad, Long>{

}
