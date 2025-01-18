package com.studentstay.app.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.studentstay.app.Entity.Administrador;
import com.studentstay.app.Services.IAdministradorService;


@RequestMapping("/api")
public class administradorController {

	@Autowired
	private IAdministradorService AdministradorSevice;

	// LISTAR Administrador
	@GetMapping("/administrador")

	public List<Administrador> index() {
		return AdministradorSevice.findAll();
	}

	// BUSCAR Administrador
	@GetMapping("/administrador/{id}")
	public Administrador show(@PathVariable Long id) {
		return AdministradorSevice.findById(id);
	}

	// GUARDAR Administrador

	@PostMapping("/administrador")
	@ResponseStatus(HttpStatus.CREATED)
	public Administrador create(@RequestBody Administrador Administrador) {
		return AdministradorSevice.save(Administrador);
	}

	// EDITAR Administrador
	@PutMapping("/administrador/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Administrador update(@RequestBody Administrador Administrador, @PathVariable Long id) {
		Administrador AdministradorActual = AdministradorSevice.findById(id);
		AdministradorActual.setContrasena(Administrador.getContrasena());
		AdministradorActual.setUsuario(Administrador.getUsuario());

		return AdministradorSevice.save(AdministradorActual);
	}

	// ELIMINAR Administrador
	@DeleteMapping("/administrador/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		AdministradorSevice.delete(id);
	}

	@GetMapping("/administrador/usuario/{usuario}")
	public ResponseEntity<?> getAdmin(@PathVariable String usuario) {
		try {
			Long id = Long.parseLong(usuario);
			Administrador admin = AdministradorSevice.findById(id);

			if (admin != null) {
				return new ResponseEntity<>(admin, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Estudiante no encontrado", HttpStatus.NOT_FOUND);
			}
		} catch (NumberFormatException e) {
			List<Administrador> admins = AdministradorSevice.getBooksByTitle(usuario);

			if (!admins.isEmpty()) {
				return new ResponseEntity<>(admins, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Estudiantes no encontrados", HttpStatus.NOT_FOUND);
			}
		}
	}

}
