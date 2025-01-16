package com.studentstay.app.Services;

import java.util.List;

import com.studentstay.app.Entity.Administrador;
import com.studentstay.app.Entity.Estudiante;

public interface IEstudianteService {
    
    // Busca estudiantes por usuario
    List<Estudiante> getBooksByTitle(String usuario);

    // Devuelve todos los estudiantes
    public List<Estudiante> findAll();

    // Guarda un estudiante
    public Estudiante save(Estudiante estudiante);

    // Busca un estudiante por su ID
    public Estudiante findById(Long idEstudiante);

    // Elimina un estudiante por su ID
    public void delete(Long idEstudiante);
      
    
}
