package com.spring.app.usuarios.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.app.usuarios.models.entity.Persona;

@RepositoryRestResource(path = "personas")
public interface PersonaDao  extends PagingAndSortingRepository<Persona, Long>{

}
