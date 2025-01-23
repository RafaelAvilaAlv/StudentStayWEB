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

import com.StudentStay.app.Entity.MetodoPago;
import com.StudentStay.app.Services.IMetodoPagoService;



@CrossOrigin(origins= {"http://localhost:4200","http://192.168.12.164:8081","http://192.168.0.119:8081","http://192.168.19.119:8081"})
@RestController
@RequestMapping("/api")
public class MetodoPagoController {
	@Autowired
	private IMetodoPagoService MetodoPagoService;

	@GetMapping("/metodopago")
	public List<MetodoPago> index() {
		return MetodoPagoService.findAll();
	}

	@GetMapping("/metodopago/{id}")
	public MetodoPago show(@PathVariable Long id) {
		return MetodoPagoService.findById(id);
	}

	@PostMapping("/metodopago")
	@ResponseStatus(HttpStatus.CREATED)
	public MetodoPago create(@RequestBody MetodoPago metodopago) {
		return MetodoPagoService.save(metodopago);
	}

	@PutMapping("/metodopago/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public MetodoPago update(@RequestBody MetodoPago metodopago, @PathVariable Long id) {
		MetodoPago metodoPagoActual = MetodoPagoService.findById(id);
		metodoPagoActual.setNombre(metodopago.getNombre());
		return MetodoPagoService.save(metodoPagoActual);
	}

	@DeleteMapping("/metodopago/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		MetodoPagoService.delete(id);
	}
}
