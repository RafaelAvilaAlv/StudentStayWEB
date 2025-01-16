package com.studentstay.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.studentstay.app.Dao.IHabitacionesDao;
import com.studentstay.app.Entity.Habitaciones;

@Service
public class HabitacionesServiceImpl implements IHabitacionesService{
	
	 @Autowired
	    private IHabitacionesDao habitacionDao;

	    @Override
	    @Transactional(readOnly = true)
	    public List<Habitaciones> findAll() {
	        return (List<Habitaciones>) habitacionDao.findAll();
	    }

	    @Override
	    @Transactional
	    public Habitaciones save(Habitaciones habitaciones) {
	        return habitacionDao.save(habitaciones);
	    }

	    @Override
	    @Transactional(readOnly = true)
	    public Habitaciones findById(Long id) {
	        return habitacionDao.findById(id).orElse(null);
	    }

	    @Override
	    @Transactional
	    public void delete(Long idHabitaciones) {
	        habitacionDao.deleteById(idHabitaciones);
	    }

	  

}
