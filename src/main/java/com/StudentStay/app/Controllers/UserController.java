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

import com.StudentStay.app.Entity.User;
import com.StudentStay.app.Services.IUserService;

@CrossOrigin(origins= {"http://localhost:4200", "http://192.168.12.164:8081", "http://192.168.0.119:8081", "http://192.168.19.119:8081"})
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/usuarios")
    public List<User> index() {
        return userService.findAll();
    }

    @GetMapping("/usuarios/{id}")
    public User show(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/usuarios")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user, @PathVariable Long id) {
        User userActual = userService.findById(id);
       // userActual.setCedulaPersona(user.get());
        userActual.setUsuario(user.getUsuario());
        userActual.setContrasena(user.getContrasena());
        userActual.setPersona(user.getPersona());
        userActual.setRol(user.getRol());
        return userService.save(userActual);
    }

    @DeleteMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
