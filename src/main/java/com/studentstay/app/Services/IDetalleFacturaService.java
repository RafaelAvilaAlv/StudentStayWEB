package com.StudentStay.app.Services;

import java.util.List;

import com.StudentStay.app.Entity.*;
public interface IDetalleFacturaService {
	
	public List<detalleFactura> findAll();
	
	public detalleFactura save(detalleFactura detalleFactura);
	
	public detalleFactura findById(Long idDetalleFac);
	
	public void delete(Long idDetalleFac);

}
