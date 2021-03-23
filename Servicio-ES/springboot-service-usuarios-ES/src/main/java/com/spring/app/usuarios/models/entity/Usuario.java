package com.spring.app.usuarios.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String usuario;
	private String contraseña;
	private String telefono;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuarios_rol", joinColumns = @JoinColumn(name = "usuario_id"),
	inverseJoinColumns = @JoinColumn(name = "rol_id"), 
	uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario_id", "rol_id"})})
	private List<Rol> listRol;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Rol> getListRol() {
		return listRol;
	}

	public void setListRol(List<Rol> listRol) {
		this.listRol = listRol;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	private static final long serialVersionUID = 9040898382870544770L;
}
