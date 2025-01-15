package com.studentstay.app.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="arriendos", uniqueConstraints = {@UniqueConstraint(columnNames= {"idPropietario","idHabitaciones","idEstudiante","idPago","idArriendo"})})
public class Arriendo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idArriendo;
	private Long idPago;
	@Temporal(TemporalType.DATE)
	private Date fechaSalida;
	@Temporal(TemporalType.DATE)
	private Date fechaEntrada;
	private Double total;
	private Long idHabitaciones;
	private Long idPropietario;
	private Long idEstudiante;
	private Integer dias;
	private Integer nPersona;
	private String estado;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="idArriendo")
	private List<EncabezadoFactura> encabezado;
	
	public Long getIdArriendo() {
		return idArriendo;
	}
	public void setIdArriendo(Long IdArriendo) {
		this.idArriendo = IdArriendo;
	}
	public Long getIdPago() {
		return idPago;
	}
	public void setIdPago(Long idPago) {
		this.idPago = idPago;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public Date getFechaEntrada() {
		return fechaEntrada;
	}
	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Long getIdHabitaciones() {
		return idHabitaciones;
	}
	public void setIdHabitaciones(Long idHabitaciones) {
		this.idHabitaciones = idHabitaciones;
	}
	public Long getIdPropietario() {
		return idPropietario;
	}
	public void setIdPropietario(Long idPropietario) {
		this.idPropietario = idPropietario;
	}


	public Long getIdEstudiante() {
		return idEstudiante;
	}
	public void setIdestudiante(Long idEstudiante) {
		this.idEstudiante = idEstudiante;
	}
	public Integer getDias() {
		return dias;
	}
	public void setDias(Integer dias) {
		this.dias = dias;
	}
	public Integer getnPersona() {
		return nPersona;
	}
	public void setnPersona(Integer nPersona) {
		this.nPersona = nPersona;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public List<EncabezadoFactura> getEncabezado() {
		return encabezado;
	}
	public void setEncabezado(List<EncabezadoFactura> encabezado) {
		this.encabezado = encabezado;
	}

}

