package com.studentstay.app.Dao;

import org.springframework.data.repository.CrudRepository;
import com.studentstay.app.Entity.Calificacion;

public interface ICalificacionDao extends CrudRepository<Calificacion, Long> {
  
}
