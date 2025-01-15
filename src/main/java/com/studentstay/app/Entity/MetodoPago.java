package com.studentstay.app.Entity;

import java.io.Serializable;
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
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "metodopago", uniqueConstraints = {@UniqueConstraint(columnNames= {"idPago"})})
public class MetodoPago implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPago;
	
	private String nombre;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="idPago")
	private List<Arriendo> arriendo;
	
	public Long getIdPago() {
		return idPago;
	}
	public void setIdPago(Long idPago) {
		this.idPago = idPago;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Arriendo> getIdArriendo() {
		return arriendo;
	}
	public void setIdArriendo(List<Arriendo> arriendo) {
		this.arriendo = arriendo;
	}
	
}
