package com.studentstay.app.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.studentstay.app.Entity.Calificacion;
import com.studentstay.app.Services.ICalificacionService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

public class calificacionController {

	@Autowired
	private ICalificacionService CalificacionSevice;

	// LISTAR 
	@GetMapping("/calificaciones")
	public List<Calificacion> index() {
		return CalificacionSevice.findAll();
	}

	
	// BUSCAR
	@GetMapping("/calificacion/{id}")
	public Calificacion show(@PathVariable Long id) {
		return CalificacionSevice.findById(id);
	}

	// GUARDAR 

	@PostMapping("/calificacion")
	@ResponseStatus(HttpStatus.CREATED)
	public Calificacion create(@RequestBody Calificacion calificacion) {
		return CalificacionSevice.save(calificacion);
	}

	// EDITAR 
	@PutMapping("/calficacion/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Calificacion update(@RequestBody Calificacion calificacion, @PathVariable Long id) {
		Calificacion CalificacionActual = CalificacionSevice.findById(id);
		CalificacionActual.setPuntaje(calificacion.getPuntaje());
		CalificacionActual.setComentario(calificacion.getComentario());

		return CalificacionSevice.save(CalificacionActual);
	}

	// ELIMINAR 
	@DeleteMapping("/califiacion/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		CalificacionSevice.delete(id);
	}

	

}
