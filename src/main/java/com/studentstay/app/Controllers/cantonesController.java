package com.studentstay.app.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentstay.app.Entity.Cantones;
import com.studentstay.app.Services.ICantonesService;

@CrossOrigin(origins= {"http://localhost:4200","http://192.168.12.164:8081","http://192.168.0.119:8081","http://192.168.19.119:8081"})
@RestController
@RequestMapping("/api")
public class cantonesController {
	
	@Autowired
	private ICantonesService CantonSevice;
	//Listar Canton
	@GetMapping("/Cantones")

	public List<Cantones> index(){
		return CantonSevice.finAll();
	}
	
	//Buscar Canton
	@GetMapping("/Cantones/{id}")
	public Cantones show(@PathVariable String id) {
		return CantonSevice.findById(id);
	}
	
	
}
