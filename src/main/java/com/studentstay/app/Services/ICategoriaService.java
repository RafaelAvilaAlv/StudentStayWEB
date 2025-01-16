package com.studentstay.app.Services;

import java.util.List;

import com.studentstay.app.Entity.Categorias;

public interface ICategoriaService  {

	public List<Categorias> findAll();
	
	public Categorias save (Categorias categorias);
	
	public Categorias findById(Long idCategoria);
	
	public void delete (Long idCategoria);
	
}
