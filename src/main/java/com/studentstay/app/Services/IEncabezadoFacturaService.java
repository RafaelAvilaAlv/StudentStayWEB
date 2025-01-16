package com.studentstay.app.Services;

import java.util.List;

import com.studentstay.app.Entity.EncabezadoFactura;

public interface IEncabezadoFacturaService {

	public List<EncabezadoFactura> findAll();
	
	public EncabezadoFactura save (EncabezadoFactura encabezadoFactu);
	
	public EncabezadoFactura findById(Long idEncabezado);
	
	public void delete (Long idEncabezado);
	
}
