package com.spring.app.activo.es.modelo.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "activo")
public class ActivoEntidad implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String descripcion;
	private String serial;
	private String inventario;
	private Double peso;
	private Double alto;
	private Double ancho;
	private Double largo;
	@Column(name ="valor_compra")
	private Double valorCompra;
	@Column(name ="fecha_compra")
	@Temporal(TemporalType.DATE)
	private Date fechaCompra;
	@Column(name ="fecha_de_baja")
	@Temporal(TemporalType.DATE)
	private Date fechaDeBaja;
	private String color;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado_id" , referencedColumnName = "id")
    private EstadoEntidad estado;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ciudad_id" , referencedColumnName = "id")
    private CiudadEntidad ciudad;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_id"  , referencedColumnName = "id")
    private TipoEntidad tipo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getInventario() {
		return inventario;
	}
	public void setInventario(String inventario) {
		this.inventario = inventario;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public Double getAlto() {
		return alto;
	}
	public void setAlto(Double alto) {
		this.alto = alto;
	}
	public Double getAncho() {
		return ancho;
	}
	public void setAncho(Double ancho) {
		this.ancho = ancho;
	}
	public Double getLargo() {
		return largo;
	}
	public void setLargo(Double largo) {
		this.largo = largo;
	}
	public Double getValorCompra() {
		return valorCompra;
	}
	public void setValorCompra(Double valorCompra) {
		this.valorCompra = valorCompra;
	}
	public Date getFechaCompra() {
		return fechaCompra;
	}
	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	public Date getFechaDeBaja() {
		return fechaDeBaja;
	}
	public void setFechaDeBaja(Date fechaDeBaja) {
		this.fechaDeBaja = fechaDeBaja;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public EstadoEntidad getEstado() {
		return estado;
	}
	public void setEstado(EstadoEntidad estado) {
		this.estado = estado;
	}
	public CiudadEntidad getCiudad() {
		return ciudad;
	}
	public void setCiudad(CiudadEntidad ciudad) {
		this.ciudad = ciudad;
	}
	public TipoEntidad getTipo() {
		return tipo;
	}
	public void setTipo(TipoEntidad tipo) {
		this.tipo = tipo;
	}

}
