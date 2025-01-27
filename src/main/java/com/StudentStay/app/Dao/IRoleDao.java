package com.StudentStay.app.Dao;

import org.springframework.data.repository.CrudRepository;

import com.StudentStay.app.Entity.Role;

public interface IRoleDao extends CrudRepository<Role, Long> {

}
