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

import com.studentstay.app.Entity.EncabezadoFactura;
import com.studentstay.app.Services.IEncabezadoFacturaService;

import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins= {"http://localhost:4200","http://192.168.12.164:8081","http://192.168.0.119:8081","http://192.168.19.119:8081"})
@RestController
@RequestMapping("/api")
public class encabezadofacturaController {
	
	@Autowired
	private IEncabezadoFacturaService EncabezadoFacturaSevice;
	
	//Lsitar
	@GetMapping("/encabezadofactura")
	
	public List<EncabezadoFactura> index(){
		return EncabezadoFacturaSevice.findAll();
	}

	//Buscar
	@GetMapping("/encabezadofactura/{id}")
	public EncabezadoFactura show(@PathVariable Long id) {
		return EncabezadoFacturaSevice.findById(id);
	}
	
	//Guardar
	@PostMapping("/encabezadofactura")
	@ResponseStatus(HttpStatus.CREATED)
	public EncabezadoFactura create(@RequestBody EncabezadoFactura EncabezadoFactura) {
		return EncabezadoFacturaSevice.save(EncabezadoFactura);
	}
	
	//Ediatr
	@PutMapping("/encabezadofactura/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public EncabezadoFactura update(@RequestBody EncabezadoFactura EncabezadoFactura, @PathVariable Long id) {
		EncabezadoFactura EncabezadoFacturaActual = EncabezadoFacturaSevice.findById(id);
		EncabezadoFacturaActual.setFechaFactura(EncabezadoFactura.getFechaFactura());
		EncabezadoFacturaActual.setTotal(EncabezadoFactura.getTotal());
		
		return EncabezadoFacturaSevice.save(EncabezadoFacturaActual);
	}
	
	//Elimnar
	@DeleteMapping("/encabezadofactura/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		EncabezadoFacturaSevice.delete(id);
	}
}
