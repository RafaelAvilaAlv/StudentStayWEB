package com.studentstay.app.Services;

import java.util.List;

import com.studentstay.app.Entity.*;



public interface IServicioService {
	
	
public List<Servicio> findAll();
	
	public Servicio save(Servicio servicio);
	
	public Servicio findById(Long idServicio);
	
	public void delete(Long idServicio);

}
