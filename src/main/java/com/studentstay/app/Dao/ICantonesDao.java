package com.studentstay.app.Dao;

import org.springframework.data.repository.CrudRepository;

import com.studentstay.app.Entity.Cantones;


public interface ICantonesDao extends CrudRepository<Cantones, String> {

}
