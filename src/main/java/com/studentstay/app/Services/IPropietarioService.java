package com.studentstay.app.Services;

import java.util.List;

import com.studentstay.app.Entity.*;

public interface IPropietarioService {
	
List<Propietario> getBooksByTitle(String usuario);
	
	public List<Propietario> findAll();
	
	public Propietario save(Propietario propietario);
	
	public Propietario findById(Long idPropietario);
	
	public void delete(Long idPropietario);


}
