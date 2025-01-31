package com.StudentStay.app.Entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tiposervicio")
public class TipoServicio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTipo_servicio;
	private String titulo;
	private String descripciontipo;
	@Column(name = "foto", columnDefinition = "TEXT")
	private String foto;
	
	private Integer nmHabitacion;
	
	

	public Integer getNmHabitacion() {
		return nmHabitacion;
	}

	public void setNmHabitacion(Integer nmHabitacion) {
		this.nmHabitacion = nmHabitacion;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idTipo_servicio")
	private List<Servicio> servicio;

	public Long getIdTipo_servicio() {
		return idTipo_servicio;
	}

	public void setIdTipo_servicio(Long idTipo_servicio) {
		this.idTipo_servicio = idTipo_servicio;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripciontipo() {
		return descripciontipo;
	}

	public void setDescripciontipo(String descripciontipo) {
		this.descripciontipo = descripciontipo;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public List<Servicio> getServicio() {
		return servicio;
	}

	public void setServicio(List<Servicio> servicio) {
		this.servicio = servicio;
	}

}
