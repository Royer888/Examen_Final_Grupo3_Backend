package com.example.ExamenFinal_Grupo3.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "noticias")
public class Noticia {

	// Identificador único
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// Título de la noticia
	@Column(nullable = false, length = 150)
	private String titulo;

	// Descripción o contenido
	@Column(columnDefinition = "TEXT", nullable = false)
	private String descripcion;

	// Fecha de publicación
	private LocalDate fecha;

	// Imagen relacionada (URL o nombre de archivo)
	private String imagenUrl;

	// Categoría de la noticia
	private String categoria;

	// Constructor vacío (OBLIGATORIO en JPA)
	public Noticia() {
	}

	// Se ejecuta antes de guardar en BD
	@PrePersist
	public void prePersist() {
		if (this.fecha == null) {
			this.fecha = LocalDate.now();
		}

		if (this.categoria == null || this.categoria.isBlank()) {
			this.categoria = "Institucional";
		}
	}

	// GETTERS Y SETTERS

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getImagenUrl() {
		return imagenUrl;
	}

	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}