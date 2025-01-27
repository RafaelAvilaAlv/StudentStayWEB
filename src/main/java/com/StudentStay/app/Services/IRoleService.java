package com.StudentStay.app.Services;

import java.util.List;

import com.StudentStay.app.Entity.*;

public interface IRoleService {
    
    public List<Role> findAll();
    
    public Role save(Role role);
    
    public Role findById(Long id);
    
    public void delete(Long id);
}
