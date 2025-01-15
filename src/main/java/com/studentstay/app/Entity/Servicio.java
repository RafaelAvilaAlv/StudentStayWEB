package com.studentstay.app.Entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "servicio", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "idTipo_servicio", "idHabitaciones", "idServicio" }) })
public class Servicio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idServicio;
	private String descripcion;
	private Long idHabitaciones;
	private Long idTipo_servicio;
	private String estado;

	public Long getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(Long idServicio) {
		this.idServicio = idServicio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getIdHabitaciones() {
		return idHabitaciones;
	}

	public void setIdHabitaciones(Long idHabitaciones) {
		this.idHabitaciones = idHabitaciones;
	}

	public Long getIdTipo_servicio() {
		return idTipo_servicio;
	}

	public void setIdTipo_servicio(Long idTipo_servicio) {
		this.idTipo_servicio = idTipo_servicio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
