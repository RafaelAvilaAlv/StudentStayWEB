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
@Table(name = "encabezadofactura", uniqueConstraints = {@UniqueConstraint(columnNames= {"idEncabezado","idArriendo"})})
public class EncabezadoFactura implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEncabezado;
	private Long idEstudiante;
	private Long idArriendo;
	@Temporal(TemporalType.DATE)
	private Date fechaFactura;
	private Double total;
	 
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="idEncabezado")
	private List<detalleFactura> detalleFac;
	
	public Long getIdEncabezado() {
		return idEncabezado;
	}
	public void setIdEncabezado(Long idEncabezado) {
		this.idEncabezado = idEncabezado;
	}
	
	public Long getIdEstudiante() {
		return idEstudiante;
	}
	public void setIdEstudiante(Long idEstudiante) {
		this.idEstudiante = idEstudiante;
	}
	public Date getFechaFactura() {
		return fechaFactura;
	}
	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public List<detalleFactura> getDetalleFac() {
		return detalleFac;
	}
	public void setDetalleFac(List<detalleFactura> detalleFac) {
		this.detalleFac = detalleFac;
	}
	public Long getIdArriendo() {
		return idArriendo;
	}
	public void setIdArriendo(Long idArriendo) {
		this.idArriendo = idArriendo;
	}
	
	
	

}
