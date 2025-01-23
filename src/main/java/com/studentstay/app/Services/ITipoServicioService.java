package com.StudentStay.app.Services;

import java.util.List;

import com.StudentStay.app.Entity.*;

public interface ITipoServicioService {
	
	public List<TipoServicio> findAll();
	
	public TipoServicio save(TipoServicio tipoServicio);
	
	public TipoServicio findById(Long idTipoServicio);
	
	public void delete(Long idTipoServicio);

}
