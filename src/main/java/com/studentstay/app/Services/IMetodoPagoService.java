package com.StudentStay.app.Services;

import java.util.List;

import com.StudentStay.app.Entity.*;

public interface IMetodoPagoService {
	
	public List<MetodoPago> findAll();
	
	public MetodoPago save(MetodoPago metodoPago);
	
	 public MetodoPago findById(Long idPago);
	 
	 public void delete(Long idPago);
 
}
