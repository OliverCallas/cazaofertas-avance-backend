package com.idat.cazaofertas.app.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "publicaciones")
public class Publicacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "categoria")
	private String categoria;

	@Column(name = "imagen")
	private String imagen;
	
	@Column(name = "ubicacion")
	private String ubicacion;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "fecha")
	@Temporal(TemporalType.TIMESTAMP) // Indica que se almacenará la fecha y hora completa
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // Patrón de formato para mostrar en las vistas
	private Date fecha;
	
	@Column(name = "estado")
	private String estado;
	
	@PrePersist //agregar fecha automaticamente del sistema
		public void prePersist() {
			fecha = new Date();
		}

	public Publicacion() {
	}

	public Publicacion(Long id) {
		this.id = id;
	}

	public Publicacion(String titulo, String categoria, String imagen, String ubicacion, String descripcion, Date fecha,
			String estado) {
		this.titulo = titulo;
		this.categoria = categoria;
		this.imagen = imagen;
		this.ubicacion = ubicacion;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.estado = estado;
	}



	public Publicacion(Long id, String titulo, String categoria, String imagen, String ubicacion, String descripcion,
			Date fecha, String estado) {
		this.id = id;
		this.titulo = titulo;
		this.categoria = categoria;
		this.imagen = imagen;
		this.ubicacion = ubicacion;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.estado = estado;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

}
