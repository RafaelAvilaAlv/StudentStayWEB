package com.studentstay.app.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.studentstay.app.Entity.Propietario;
import com.studentstay.app.Services.IPropietarioService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin(origins = { "http://localhost:4200", "http://192.168.12.164:8081", "http://192.168.0.119:8081","http://192.168.19.119:8081" })
@RestController
@RequestMapping("/api")
public class propietarioController {


		@Autowired
		private IPropietarioService PropietarioSevice;

		// LISTAR 
		@GetMapping("/propietarios")
		public List<Propietario> index() {
			return PropietarioSevice.findAll();
		}

		
		// BUSCAR
		@GetMapping("/propietario/{id}")
		public Propietario show(@PathVariable Long id) {
			return PropietarioSevice.findById(id);
		}

		// GUARDAR 

		@PostMapping("/propietario")
		@ResponseStatus(HttpStatus.CREATED)
		public Propietario create(@RequestBody Propietario Propietario) {
			return PropietarioSevice.save(Propietario);
		}

		// EDITAR 
		@PutMapping("/propietario/{id}")
		@ResponseStatus(HttpStatus.CREATED)
		public Propietario update(@RequestBody Propietario Propietario, @PathVariable Long id) {
			Propietario PropietarioActual = PropietarioSevice.findById(id);
			PropietarioActual.setContrasena(Propietario.getContrasena());
			PropietarioActual.setUsuario(Propietario.getUsuario());

			return PropietarioSevice.save(PropietarioActual);
		}

		// ELIMINAR 
		@DeleteMapping("/propietario/{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void delete(@PathVariable Long id) {
			PropietarioSevice.delete(id);
		}

		@GetMapping("/propietario/usuario/{usuario}")
		public ResponseEntity<?> getAdmin(@PathVariable String usuario) {
			try {
				Long id = Long.parseLong(usuario);
				Propietario propie = PropietarioSevice.findById(id);

				if (propie != null) {
					return new ResponseEntity<>(propie, HttpStatus.OK);
				} else {
					return new ResponseEntity<>("Propietario no encontrado", HttpStatus.NOT_FOUND);
				}
			} catch (NumberFormatException e) {
				List<Propietario> propiet = PropietarioSevice.getBooksByTitle(usuario);

				if (!propiet.isEmpty()) {
					return new ResponseEntity<>(propiet, HttpStatus.OK);
				} else {
					return new ResponseEntity<>("Propietarios no encontrados", HttpStatus.NOT_FOUND);
				}
			}
		

	}
	
	
}
