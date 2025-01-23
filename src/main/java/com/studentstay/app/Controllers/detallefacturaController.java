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

import com.StudentStay.app.Entity.*;
import com.StudentStay.app.Services.*;


@CrossOrigin(origins= {"http://localhost:4200","http://192.168.12.164:8081","http://192.168.0.119:8081","http://192.168.19.119:8081"})
@RestController
@RequestMapping("/api")
public class detallefacturaController {
	@Autowired
	private IDetalleFacturaService detalleFacturaSevice;
	//LISTAR detalleFactura
	@GetMapping("/detallefactura")

		public List<detalleFactura> index(){
		return detalleFacturaSevice.findAll();
		
	}
		//BUSCAR detalleFactura
	@GetMapping("/detallefactura/{id}")
	public detalleFactura show(@PathVariable Long id) {
		return detalleFacturaSevice.findById(id);
	}
	//GUARDAR detalleFactura

	@PostMapping("/detallefactura")
	@ResponseStatus(HttpStatus.CREATED)
	public detalleFactura create(@RequestBody detalleFactura detalleFactura) {
		return detalleFacturaSevice.save(detalleFactura);
	}
	//EDITAR detalleFactura
	@PutMapping("/detallefactura/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public detalleFactura update(@RequestBody detalleFactura detalleFactura, @PathVariable Long id) {
		detalleFactura detalleFacturaActual = detalleFacturaSevice.findById(id);
		detalleFacturaActual.setSubTotal(detalleFactura.getSubTotal());
		
		return detalleFacturaSevice.save(detalleFacturaActual);
	}
	//ELIMINAR detalleFactura
	@DeleteMapping("/detallefactura/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		detalleFacturaSevice.delete(id);
	}
}
