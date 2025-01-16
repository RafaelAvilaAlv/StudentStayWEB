package com.studentstay.app.Dao;

import org.springframework.data.repository.CrudRepository;

import com.studentstay.app.Entity.Persona;

public interface IPersonaDao extends CrudRepository<Persona, String> {

}
