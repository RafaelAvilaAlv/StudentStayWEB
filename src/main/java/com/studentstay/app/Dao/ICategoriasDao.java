package com.studentstay.app.Dao;

import org.springframework.data.repository.CrudRepository;

import com.studentstay.app.Entity.Categorias;

public interface ICategoriasDao extends CrudRepository<Categorias, Long> {

}
