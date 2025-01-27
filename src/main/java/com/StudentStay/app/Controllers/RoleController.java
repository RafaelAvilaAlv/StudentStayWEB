package com.StudentStay.app.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.StudentStay.app.Entity.Role;
import com.StudentStay.app.Services.IRoleService;

@CrossOrigin(origins= {"http://localhost:4200", "http://192.168.12.164:8081", "http://192.168.0.119:8081", "http://192.168.19.119:8081"})
@RestController
@RequestMapping("/api")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @GetMapping("/roles")
    public List<Role> index() {
        return roleService.findAll();
    }

    @GetMapping("/roles/{id}")
    public Role show(@PathVariable Long id) {
        return roleService.findById(id);
    }

    @PostMapping("/roles")
    @ResponseStatus(HttpStatus.CREATED)
    public Role create(@RequestBody Role role) {
        return roleService.save(role);
    }

    @PutMapping("/roles/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Role update(@RequestBody Role role, @PathVariable Long id) {
        Role roleActual = roleService.findById(id);
        roleActual.setNombre(role.getNombre());
        roleActual.setDescripcion(role.getDescripcion());
        return roleService.save(roleActual);
    }

    @DeleteMapping("/roles/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        roleService.delete(id);
    }
}
