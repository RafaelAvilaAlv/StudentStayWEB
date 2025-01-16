package com.studentstay.app.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.studentstay.app.Entity.Estudiante;

public interface IEstudianteDao extends CrudRepository<Estudiante, Long> {

	Estudiante findByUsuario (String usuario);
	
	List<Estudiante> findByUsuarioContainingIgnoreCase(String usuario);
	
}
