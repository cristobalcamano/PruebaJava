package com.spring.app.usuarios;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import com.spring.app.usuarios.models.entity.Area;
import com.spring.app.usuarios.models.entity.Persona;
import com.spring.app.usuarios.models.entity.Rol;
import com.spring.app.usuarios.models.entity.Usuario;

@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer{

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Usuario.class,Rol.class,Persona.class,Area.class);
	}

	
	
}
