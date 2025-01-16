package com.studentstay.app.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.studentstay.app.Entity.Propietario;

public interface IPropietarioDao extends CrudRepository<Propietario, Long> {

	Propietario findByUsuario(String usuario);
	
	List<Propietario> findByUsuarioContainingIgnoreCase(String usuario);
	
	
}
