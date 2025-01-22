package com.studentstay.app.Services;

import java.util.List;

import com.studentstay.app.Entity.*;
public interface IRecepcionistaService {
	
	List<Recepcionista> getBooksByTitle(String usuario);
	
	public List<Recepcionista> findAll();
	
	public Recepcionista save(Recepcionista recepcionista);
	
	public Recepcionista findById(Long idRecepcionista);
	
	public void delete(Long idRecepcionista);

}
