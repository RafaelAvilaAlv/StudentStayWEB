package com.StudentStay.app.Services;

import java.util.List;

import com.StudentStay.app.Entity.*;

public interface IPersonaService {
	
	public List<Persona> findAll();
	
	 public Persona save(Persona persona);
	 
	 public Persona findById(String cedulaPersona);
	 
	 public void delete(String cedulaPersona);
 

}
