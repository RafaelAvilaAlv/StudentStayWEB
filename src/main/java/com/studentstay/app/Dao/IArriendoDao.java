package com.studentstay.app.Dao;

import org.springframework.data.repository.CrudRepository;

import com.studentstay.app.Entity.Arriendo;

public interface IArriendoDao extends CrudRepository<Arriendo, Long> {

}
