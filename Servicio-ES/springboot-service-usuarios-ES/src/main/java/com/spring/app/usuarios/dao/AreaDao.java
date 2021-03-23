package com.spring.app.usuarios.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.app.usuarios.models.entity.Area;

@RepositoryRestResource(path = "areas")
public interface AreaDao  extends PagingAndSortingRepository<Area, Long>{

}
