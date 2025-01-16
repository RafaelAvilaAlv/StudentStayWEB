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

import com.studentstay.app.Entity.Categorias;
import com.studentstay.app.Services.ICategoriaService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin(origins= {"http://localhost:4200","http://192.168.12.164:8081","http://192.168.0.119:8081","http://192.168.19.119:8081"})
@RestController
@RequestMapping("/api")
public class categoriasController {
	
	@Autowired
	private ICategoriaService CategoriasSevice;
	
	//Listar Categorias
	@GetMapping("/categorias")
	
	public List<Categorias> index(){
		return CategoriasSevice.findAll();
	}

	//Busdcar
	@GetMapping("/categorias/{id}")
	public Categorias show(@PathVariable Long id) {
		return CategoriasSevice.findById(id);
	}
	
	//Guardar
	@PostMapping("/categorias")
	@ResponseStatus(HttpStatus.CREATED)
	public Categorias show(@RequestBody Categorias categorias) {
		return CategoriasSevice.save(categorias);
	}
	
	//Editar
	@PutMapping("/categorias/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Categorias update(@RequestBody Categorias categorias, @PathVariable Long id) {
		Categorias categoriasActual = CategoriasSevice.findById(id);
		categoriasActual.setNombre(categorias.getNombre());
		return CategoriasSevice.save(categoriasActual);
	}
	
	//Eliminar
	@DeleteMapping("/cateogiras/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		CategoriasSevice.delete(id);
	}

}
