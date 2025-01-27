package com.StudentStay.app.Services;

import java.util.List;

import com.StudentStay.app.Entity.*;

public interface IUserService {
    
    public List<User> findAll();
    
    public User save(User user);
    
    public User findById(Long id);
    
    public void delete(Long id);
}
