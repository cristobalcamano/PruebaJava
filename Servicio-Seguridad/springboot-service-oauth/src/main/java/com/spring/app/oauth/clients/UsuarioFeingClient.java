package com.spring.app.oauth.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.app.oauth.models.dto.Usuario;

@FeignClient(name = "servicio-usuarios", url = "localhost:9001/")
public interface UsuarioFeingClient {

	@GetMapping("/usuarios/search/usuario")
	public Usuario consultarUsuarioPorNombre(@RequestParam String usuario);
	
}
