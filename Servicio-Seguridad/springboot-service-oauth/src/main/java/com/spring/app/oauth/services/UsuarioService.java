package com.spring.app.oauth.services;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.app.oauth.clients.UsuarioFeingClient;
import com.spring.app.oauth.models.dto.Usuario;

@Service
public class UsuarioService implements UserDetailsService{

	@Autowired
	private UsuarioFeingClient uClient;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = uClient.consultarUsuarioPorNombre(username);
		if (usuario == null) {
			throw new UsernameNotFoundException("No se encontro el usuario");
		}
		List<GrantedAuthority> autorizacion = usuario.getListRol().stream()
				.map(role -> new SimpleGrantedAuthority(role.getNombre()))
				.collect(Collectors.toList());
		return new User(username,usuario.getContraseña(),true,true,true,true,autorizacion);
	}

}
