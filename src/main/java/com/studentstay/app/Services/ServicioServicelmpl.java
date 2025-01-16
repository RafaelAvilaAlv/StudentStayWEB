package com.studentstay.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.studentstay.app.Dao.*;
import com.studentstay.app.Entity.*;


@Service
public class ServicioServicelmpl implements IServicioService {
	
	
	@Autowired
	private IServicioDao servicioDao;

	@Override
	@Transactional(readOnly = true)
	public List<Servicio> findAll() {
		// TODO Auto-generated method stub
		return (List<Servicio>) servicioDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Servicio findById(Long id) {
		// TODO Auto-generated method stub
		return servicioDao.findById(id).orElse(null);
	}


	@Override
	@Transactional
	public Servicio save(Servicio servicio) {
		// TODO Auto-generated method stub
		return servicioDao.save(servicio);
	}


	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		servicioDao.deleteById(id);
	}
	

}
