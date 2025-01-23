package com.StudentStay.app.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StudentStay.app.Entity.Provincia;
import com.StudentStay.app.Services.IProvinciaService;


@CrossOrigin(origins= {"http://localhost:4200","http://192.168.12.164:8081","http://192.168.0.119:8081","http://192.168.19.119:8081"})
@RestController
@RequestMapping("/api")
public class ProvinciaController {
	@Autowired
	private IProvinciaService provinciaService;

	@GetMapping("/provincias")
	public List<Provincia> index() {
		return provinciaService.findAll();
	}

	@GetMapping("/provincias/{id}")
	public Provincia show(@PathVariable String id) {
		return provinciaService.findById(id);
	}

	
}
