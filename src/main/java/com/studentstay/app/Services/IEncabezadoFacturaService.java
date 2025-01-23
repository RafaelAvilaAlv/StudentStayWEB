package com.StudentStay.app.Services;

import java.util.List;

import com.StudentStay.app.Entity.*;

public interface IEncabezadoFacturaService {
	
	 public List<EncabezadoFactura> findAll();
	 
	 public EncabezadoFactura save(EncabezadoFactura encabezadoFactura);
	 
	 public EncabezadoFactura findById(Long idEncabezado);
	 
	 public void delete(Long idEncabezado);

}
