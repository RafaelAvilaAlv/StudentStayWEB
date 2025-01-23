package com.StudentStay.app.Controllers;

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

import com.StudentStay.app.Entity.*;
import com.StudentStay.app.Services.*;


@CrossOrigin(origins= {"http://localhost:4200","http://192.168.12.164:8081","http://192.168.0.119:8081","http://192.168.19.119:8081"})
@RestController
@RequestMapping("/api")
public class clientesController {
	@Autowired
	private IClienteService ClienteSevice;


	//LISTAR_Cliente
	@GetMapping("/clientes")

		public List<Cliente> index(){
		return ClienteSevice.findAll();
		
	}
		//BUSCAR_Cliente
	@GetMapping("/clientes/{id}")
	public Cliente show(@PathVariable Long id) {
	return ClienteSevice.findById(id);
	}
	
	//GUARDAR_Cliente
	@PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create(@RequestBody Cliente cliente) {
        return ClienteSevice.save(cliente);
    }

	
	
	//EDITAR_Cliente
	@PutMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente update(@RequestBody Cliente Cliente, @PathVariable Long id) {
		Cliente ClienteActual = ClienteSevice.findById(id);
		ClienteActual.setContrasena(Cliente.getContrasena());
		ClienteActual.setFoto(Cliente.getFoto());
		ClienteActual.setUsuario(Cliente.getUsuario());	
		return ClienteSevice.save(ClienteActual);
	}
	//ELIMINAR_Cliente
	@DeleteMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		ClienteSevice.delete(id);
	}
	
	@GetMapping("/clientes/usuario/{usuario}")
	public ResponseEntity<?> getClientes(@PathVariable String usuario) {
	 try {
	        Long id = Long.parseLong(usuario);
	        Cliente cliente = ClienteSevice.findById(id);
	        
	        if (cliente != null) {
	            return new ResponseEntity<>(cliente, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("Cliente no encontrado", HttpStatus.NOT_FOUND);
	        }
	    } catch (NumberFormatException e) {
	        List<Cliente> clientes = ClienteSevice.getBooksByTitle(usuario);
	        
	        if (!clientes.isEmpty()) {
	            return new ResponseEntity<>(clientes, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("Clientes no encontrados", HttpStatus.NOT_FOUND);
	        }
	    }
	}
	
}
