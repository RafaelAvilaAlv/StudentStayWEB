package com.studentstay.app.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.studentstay.app.Entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long> {
	Cliente findByUsuario(String usuario);

	List<Cliente> findByUsuarioContainingIgnoreCase(String usuario);

}
