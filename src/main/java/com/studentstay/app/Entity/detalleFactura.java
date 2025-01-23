package com.StudentStay.app.Entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "detallefactura", uniqueConstraints = {@UniqueConstraint(columnNames= {"idEncabezado", "idDetalleFac"})})
public class detalleFactura implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDetalleFac;
	private Double subTotal;
	private Long idEncabezado;
	public Long getIdDetalleFac() {
		return idDetalleFac;
	}
	public void setIdDetalleFac(Long idDetalleFac) {
		this.idDetalleFac = idDetalleFac;
	}
	
	public Double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}
	public Long getIdEncabezado() {
		return idEncabezado;
	}
	public void setIdEncabezado(Long idEncabezado) {
		this.idEncabezado = idEncabezado;
	}
	
	
	

}
