package com.StudentStay.app.Dao;

import org.springframework.data.repository.CrudRepository;

import com.StudentStay.app.Entity.User;

public interface IUserDao extends CrudRepository<User, Long> {

}
