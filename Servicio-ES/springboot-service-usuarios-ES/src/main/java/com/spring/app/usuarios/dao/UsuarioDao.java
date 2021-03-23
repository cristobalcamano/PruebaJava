package com.spring.app.usuarios.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.spring.app.usuarios.models.entity.Usuario;

@RepositoryRestResource(path = "usuarios")
public interface UsuarioDao extends PagingAndSortingRepository<Usuario, Long>{

	@RestResource(path = "usuario")
	public Usuario findByUsuario(@Param("usuario") String usuario);
	
	
}
