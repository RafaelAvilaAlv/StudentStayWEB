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
import com.studentstay.app.Entity.Recepcionista;
import com.studentstay.app.Services.IRecepcionistaService;



@CrossOrigin(origins= {"http://localhost:4200","http://192.168.40.228:8081","http://192.168.0.119:8081","http://192.168.19.119:8081"})
@RestController
@RequestMapping("/api")
public class RecepcionistaController {
	@Autowired
	private IRecepcionistaService recepcionistaService;

	@GetMapping("/recepcionistas")
	public List<Recepcionista> index() {
		return recepcionistaService.findAll();
	}

	@GetMapping("/recepcionistas/{id}")
	public Recepcionista show(@PathVariable Long id) {
		return recepcionistaService.findById(id);
	}

	@PostMapping("/recepcionistas")
	@ResponseStatus(HttpStatus.CREATED)
	public Recepcionista create(@RequestBody Recepcionista recepcionista) {
		return recepcionistaService.save(recepcionista);
	}

	@PutMapping("/recepcionistas/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Recepcionista update(@RequestBody Recepcionista recepcionista, @PathVariable Long id) {
		Recepcionista recepcionistaActual = recepcionistaService.findById(id);
		recepcionistaActual.setUsuario(recepcionista.getUsuario());
		recepcionistaActual.setContrasena(recepcionista.getContrasena());
		return recepcionistaService.save(recepcionistaActual);
	}

	@DeleteMapping("/recepcionistas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		recepcionistaService.delete(id);
	}
	
	@GetMapping("/recepcionistas/usuario/{usuario}")
	public ResponseEntity<?> getClientes(@PathVariable String usuario) {
	 try {
	        Long id = Long.parseLong(usuario);
	        Recepcionista recep = recepcionistaService.findById(id);
	        
	        if (recep != null) {
	            return new ResponseEntity<>(recep, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("Cliente no encontrado", HttpStatus.NOT_FOUND);
	        }
	    } catch (NumberFormatException e) {
	        List<Recepcionista> receps = recepcionistaService.getBooksByTitle(usuario);
	        
	        if (!receps.isEmpty()) {
	            return new ResponseEntity<>(receps, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("Clientes no encontrados", HttpStatus.NOT_FOUND);
	        }
	    }
	}
}
