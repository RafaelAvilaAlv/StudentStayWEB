package com.studentstay.app.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.studentstay.app.Dao.ICalificacionDao;
import com.studentstay.app.Entity.Calificacion;

@Service
public class CalificacionServiceImpl implements ICalificacionService {

    @Autowired
    private ICalificacionDao calificacionDao;

    @Override
    @Transactional(readOnly = true)
    public List<Calificacion> findAll() {
        return (List<Calificacion>) calificacionDao.findAll();
    }

    @Override
    @Transactional
    public Calificacion save(Calificacion calificacion) {
        return calificacionDao.save(calificacion);
    }

    @Override
    @Transactional(readOnly = true)
    public Calificacion findById(Long idCalificacion) {
        return calificacionDao.findById(idCalificacion).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long idCalificacion) {
        calificacionDao.deleteById(idCalificacion);
    }
}
