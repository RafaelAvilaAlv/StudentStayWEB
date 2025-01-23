package com.StudentStay.app.Services;

import java.util.List;

import com.StudentStay.app.Entity.*;

public interface ICategoriasService {
	
	public List<Categorias> findAll();
	
	public Categorias save(Categorias categorias);
	
	 public Categorias findById(Long idCategoria);
	 
	 public void delete(Long idCategoria); 


}
