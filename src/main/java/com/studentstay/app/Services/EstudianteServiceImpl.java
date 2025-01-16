package com.studentstay.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.studentstay.app.Dao.IEstudianteDao;
import com.studentstay.app.Entity.Estudiante;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

    @Autowired
    private IEstudianteDao estudianteDao;

    // Devuelve todos los estudiantes
    @Override
    @Transactional(readOnly = true)
    public List<Estudiante> findAll() {
        return (List<Estudiante>) estudianteDao.findAll();
    }

    // Guarda un estudiante
    @Override
    @Transactional
    public Estudiante save(Estudiante estudiante) {
        return estudianteDao.save(estudiante);
    }

    // Busca un estudiante por ID
    @Override
    @Transactional(readOnly = true)
    public Estudiante findById(Long id) {
        return estudianteDao.findById(id).orElse(null);
    }

    // Elimina un estudiante por ID
    @Override
    @Transactional
    public void delete(Long idEstudiante) {
        estudianteDao.deleteById(idEstudiante);
    }

    // Busca estudiantes por nombre de usuario
    @Override
    @Transactional(readOnly = true)
    public List<Estudiante> getBooksByTitle(String usuario) {
        return estudianteDao.findByUsuarioContainingIgnoreCase(usuario);
    }
}

