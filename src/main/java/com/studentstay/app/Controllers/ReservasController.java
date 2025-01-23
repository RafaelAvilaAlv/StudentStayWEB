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

import com.StudentStay.app.Entity.Reservas;
import com.StudentStay.app.Services.IReservasService;


@CrossOrigin(origins= {"http://localhost:4200","http://192.168.12.164:8081","http://192.168.0.119:8081","http://192.168.19.119:8081"})
@RestController
@RequestMapping("/api")
public class ReservasController {
	@Autowired
	private IReservasService reservaService;

	@GetMapping("/reservas")
	public List<Reservas> index() {
		return reservaService.findAll();
	}

	@GetMapping("/reservas/{id}")
	public Reservas show(@PathVariable Long id) {
		return reservaService.findById(id);
	}

	@PostMapping("/reservas")
	@ResponseStatus(HttpStatus.CREATED)
	public Reservas create(@RequestBody Reservas reservas) {
		return reservaService.save(reservas);
	}

	@PutMapping("/reservas/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Reservas update(@RequestBody Reservas reservas, @PathVariable Long id) {
		Reservas reservaActual = reservaService.findById(id);
		reservaActual.setEstado(reservas.getEstado());
		return reservaService.save(reservaActual);
	}

	@DeleteMapping("/reservas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		reservaService.delete(id);
	}
}
