package com.studentstay.app.Services;

import java.util.List;

import com.studentstay.app.Entity.Habitaciones;



public interface IHabitacionesService {

	    // Devuelve todos los datos
	    public List<Habitaciones> findAll();

	    // Guarda 
	    public Habitaciones save(Habitaciones habitacion);

	    // Buscapor su ID
	    public Habitaciones findById(Long idhabitaciones);

	    // Elimina  por su ID
	    public void delete(Long idHabitaciones);
}
