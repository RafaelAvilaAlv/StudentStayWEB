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
@Table(name="propietarios", uniqueConstraints = {@UniqueConstraint(columnNames= {"cedula_persona","idPropietario"})})
public class Propietario  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPropietario;
	private String usuario;
	private String contrasena;
	private String cedula_persona;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="idPropietarios")
	private List<Arriendo>arriendos;
	
	public Long getidPropietarios() {
		return idPropietario;
	}
	public void setidPropietarios(Long idPropietarios) {
		this.idPropietario = idPropietarios;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getCedula_persona() {
		return cedula_persona;
	}
	public void setCedula_persona(String cedula_persona) {
		this.cedula_persona = cedula_persona;
	}

}

