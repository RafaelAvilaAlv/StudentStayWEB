package com.studentstay.app.Services;

import java.util.List;

import com.studentstay.app.Entity.Persona;



public interface IPersonaService {
	public List<Persona> findAll();
	
	 public Persona save(Persona persona);
	 
	 public Persona findById(String cedulaPersona);
	 
	 public void delete(String cedulaPersona);
}
