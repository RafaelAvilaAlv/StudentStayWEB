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

import com.studentstay.app.Entity.Habitaciones;
import com.studentstay.app.Services.IHabitacionesService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin(origins = { "http://localhost:4200", "http://192.168.12.164:8081", "http://192.168.0.119:8081","http://192.168.19.119:8081", "http://192.168.18.156:8081" })
@RestController
@RequestMapping("/api")
public class habitacionesController {

	@Autowired
	private IHabitacionesService HabitacionesSevice;

	// Listar
	@GetMapping("/habitaciones")
	public List<Habitaciones> index() {
		return HabitacionesSevice.findAll();
	}

	// Buscar
	@GetMapping("/habitaciones/{id}")
	public Habitaciones show(@PathVariable Long id) {
		return HabitacionesSevice.findById(id);
	}

	// Guardar
	@PostMapping("/habitaciones/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Habitaciones create(@RequestBody Habitaciones Habitaciones) {
		return HabitacionesSevice.save(Habitaciones);
	}

	// Editar
	@PutMapping("/habitaciones/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Habitaciones update(@RequestBody Habitaciones Habitaciones, @PathVariable Long id) {
		Habitaciones HabitacionesActual = HabitacionesSevice.findById(id);
		HabitacionesActual.setnHabitacion(Habitaciones.getnHabitacion());
		HabitacionesActual.setnPiso(Habitaciones.getnPiso());
		HabitacionesActual.setPrecio(Habitaciones.getPrecio());
		HabitacionesActual.setDescriphabi(Habitaciones.getDescriphabi());
		HabitacionesActual.setEstado(Habitaciones.getEstado());
		return HabitacionesSevice.save(HabitacionesActual);
	}

	// Eliminar
	@DeleteMapping("/habitaciones/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		HabitacionesSevice.delete(id);
	}
}
