package com.studentstay.app.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentstay.app.Entity.Provincia;
import com.studentstay.app.Services.IProvinciaService;


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

	@GetMapping("/testProvincias")
	public ResponseEntity<?> testProvincias() {
	    try {
	        List<Provincia> provincias = provinciaService.findAll();
	        return ResponseEntity.ok(provincias);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                             .body("Error al obtener provincias: " + e.getMessage());
	    }
	}

}
