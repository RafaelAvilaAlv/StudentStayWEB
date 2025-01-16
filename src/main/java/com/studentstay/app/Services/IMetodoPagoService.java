package com.studentstay.app.Services;

import java.util.List;

import com.studentstay.app.Entity.MetodoPago;


public interface IMetodoPagoService {
	  // Devuelve todos los datos
    public List<MetodoPago> findAll();

    // Guarda 
    public MetodoPago save(MetodoPago metodopago);

    // Buscapor su ID
    public MetodoPago findById(Long idPago);

    // Elimina  por su ID
    public void delete(Long idPago);
}
