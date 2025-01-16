package com.studentstay.app.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.studentstay.app.Entity.*;

public interface IAdministradorDao extends CrudRepository<Administrador, Long> {
	Administrador findByUsuario(String usuario);
	
	List<Administrador> findByUsuarioContainingIgnoreCase(String usuario);
}
