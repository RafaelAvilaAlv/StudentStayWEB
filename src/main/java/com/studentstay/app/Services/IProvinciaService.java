package com.studentstay.app.Services;

import java.util.List;

import com.studentstay.app.Entity.*;


public interface IProvinciaService {
	
	
 public List<Provincia> findAll();
	 
	 public Provincia save(Provincia provincia);
	 
	 public Provincia findById(String idProvincia);
	 
	 public void delete(String idProvincia);

}
