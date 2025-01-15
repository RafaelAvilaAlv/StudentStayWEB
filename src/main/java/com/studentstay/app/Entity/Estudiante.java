

package com.studentstay.app.Entity;

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
import jakarta.persistence.UniqueConstraint;
@Entity
@Table(name="estudiantes", uniqueConstraints = {@UniqueConstraint(columnNames= {"cedula_persona","idEstudiante"})})
public class Estudiante implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEstudiante;
	private String usuario;
	private String contrasena;
	private String cedula_persona;
	@Column(name = "foto", columnDefinition = "TEXT")
	private String foto;
	private static final long serialVersionUID = 1L;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="idEstudiante")
	private List<Arriendo>arriendos;
	
	public Long getIdEstudiante() {
		return idEstudiante;
	}
	public void setIdEstudiante(Long idEstudiante) {
		this.idEstudiante = idEstudiante;
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
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	

}
