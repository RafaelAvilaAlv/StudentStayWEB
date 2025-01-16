package com.studentstay.app.Services;

import java.util.List;
import com.studentstay.app.Entity.Calificacion;

public interface ICalificacionService {

    List<Calificacion> findAll();

    Calificacion save(Calificacion calificacion);

    Calificacion findById(Long idCalificacion);

    void delete(Long idCalificacion);
}
