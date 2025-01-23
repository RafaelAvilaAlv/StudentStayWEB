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

import com.StudentStay.app.Entity.TipoServicio;
import com.StudentStay.app.Services.ITipoServicioService;

@CrossOrigin(origins= {"http://localhost:4200","http://192.168.12.164:8081","http://192.168.0.119:8081","http://192.168.19.119:8081"})
//@CrossOrigin(origins = {"http://192.168.40.228:8081"})
@RestController
@RequestMapping("/api")
public class TipoServicioController {
	@Autowired
	private ITipoServicioService tipoServicioService;

	@GetMapping("/tiposervicio")
	public List<TipoServicio> index() {
		return tipoServicioService.findAll();
	}

	@GetMapping("/tiposervicio/{id}")
	public TipoServicio show(@PathVariable Long id) {
		return tipoServicioService.findById(id);
	}

	@PostMapping("/tiposervicio")
	@ResponseStatus(HttpStatus.CREATED)
	public TipoServicio create(@RequestBody TipoServicio tipoServicio) {
		return tipoServicioService.save(tipoServicio);
	}

	@PutMapping("/tiposervicio/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public TipoServicio update(@RequestBody TipoServicio tipoServicio, @PathVariable Long id) {
		TipoServicio tipoServicioActual = tipoServicioService.findById(id);
		tipoServicioActual.setTitulo(tipoServicio.getTitulo());
		tipoServicioActual.setDescripciontipo(tipoServicio.getDescripciontipo());
		tipoServicioActual.setFoto(tipoServicio.getFoto());
		return tipoServicioService.save(tipoServicioActual);
	}

	@DeleteMapping("/tiposervicio/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		tipoServicioService.delete(id);
	}
}
