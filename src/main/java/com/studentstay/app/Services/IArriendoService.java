package com.studentstay.app.Services;

import java.util.List;

import com.studentstay.app.Entity.Arriendo;

public interface IArriendoService {

	public List<Arriendo> findAll();
	
	public Arriendo save (Arriendo arriendo);
	
	public Arriendo findById(Long idArriendo);
	
	public void delete(Long idArriendo);

}

