package com.studentstay.app.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.studentstay.app.Entity.Arriendo;
import com.studentstay.app.Services.IArriendoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin(origins= {"http://localhost:4200","http://192.168.12.164:8081","http://192.168.0.119:8081","http://192.168.19.119:8081"})
@RestController
@RequestMapping("/api")
public class arriendoController {
	
	@Autowired
	private IArriendoService arriendoSevice;
	
	@GetMapping("/arriendo")
	public List<Arriendo> index(){
		return arriendoSevice.findAll();
	}

	@GetMapping("/arriendo/{id}")
	public Arriendo show(@PathVariable Long id) {
		return arriendoSevice.findById(id);
	}
	
	@PostMapping("/arriendo")
	@ResponseStatus(HttpStatus.CREATED)
	public Arriendo create(@RequestBody Arriendo arriendo) {
		return arriendoSevice.save(arriendo);
	}
	
	@PutMapping("/arriendo/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Arriendo update(@RequestBody Arriendo arriendo, @PathVariable Long id) {
		Arriendo arriendoActual = arriendoSevice.findById(id);
		arriendoActual.setEstado(arriendo.getEstado());
		return arriendoSevice.save(arriendoActual);
	}
	
	@DeleteMapping("/arriendo/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		arriendoSevice.delete(id);
	}
}
