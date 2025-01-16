package com.studentstay.app.Services;

import java.util.List;

import com.studentstay.app.Entity.detalleFactura;

public interface IDetalleFacturaService {

	public List<detalleFactura> findAll();

	public detalleFactura save (detalleFactura detallefactura);
	
	public detalleFactura finById(Long idDetalleF);
	
	public void delete (Long idDetalleF);
	
}
