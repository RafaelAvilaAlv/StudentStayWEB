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

import com.studentstay.app.Entity.Estudiante;
import com.studentstay.app.Services.IEstudianteService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin(origins = { "http://localhost:4200", "http://192.168.12.164:8081", "http://192.168.0.119:8081","http://192.168.19.119:8081" })
@RestController
@RequestMapping("/api")
public class estudianteController {


		@Autowired
		private IEstudianteService EstudianteSevice;

		// LISTAR Estudiante
		@GetMapping("/estudiantes")
		public List<Estudiante> index() {
			return EstudianteSevice.findAll();
		}

		
		// BUSCAR Estudiante
		@GetMapping("/estudiate/{id}")
		public Estudiante show(@PathVariable Long id) {
			return EstudianteSevice.findById(id);
		}

		// GUARDAR Estudiante

		@PostMapping("/estudiante")
		@ResponseStatus(HttpStatus.CREATED)
		public Estudiante create(@RequestBody Estudiante Estudiante) {
			return EstudianteSevice.save(Estudiante);
		}

		// EDITAR Estudiante
		@PutMapping("/estudiante/{id}")
		@ResponseStatus(HttpStatus.CREATED)
		public Estudiante update(@RequestBody Estudiante Estudiante, @PathVariable Long id) {
			Estudiante EstudianteActual = EstudianteSevice.findById(id);
			EstudianteActual.setContrasena(Estudiante.getContrasena());
			EstudianteActual.setUsuario(Estudiante.getUsuario());

			return EstudianteSevice.save(EstudianteActual);
		}

		// ELIMINAR Estudiante
		@DeleteMapping("/estudiante/{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void delete(@PathVariable Long id) {
			EstudianteSevice.delete(id);
		}

		@GetMapping("/estudiante/usuario/{usuario}")
		public ResponseEntity<?> getAdmin(@PathVariable String usuario) {
			try {
				Long id = Long.parseLong(usuario);
				Estudiante est = EstudianteSevice.findById(id);

				if (est != null) {
					return new ResponseEntity<>(est, HttpStatus.OK);
				} else {
					return new ResponseEntity<>("Estudiante no encontrado", HttpStatus.NOT_FOUND);
				}
			} catch (NumberFormatException e) {
				List<Estudiante> estud = EstudianteSevice.getBooksByTitle(usuario);

				if (!estud.isEmpty()) {
					return new ResponseEntity<>(estud, HttpStatus.OK);
				} else {
					return new ResponseEntity<>("Estudiantes no encontrados", HttpStatus.NOT_FOUND);
				}
			}
		

	}
	
	
	
}
