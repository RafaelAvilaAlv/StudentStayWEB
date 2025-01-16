package com.studentstay.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.studentstay.app.Dao.*;
import com.studentstay.app.Entity.Propietario;

@Service

public class PropietarioServiceImpl implements IPropietarioService {
	
	@Autowired
	private IPropietarioDao proDao;



	@Override
	@Transactional(readOnly = true)
	public List<Propietario> findAll() {
		
		return (List<Propietario>) proDao.findAll();
	}
	
	@Override
	public Propietario findById(Long id) {
		// TODO Auto-generated method stub
		return proDao .findById(id).orElse(null);
	}

	
	

	@Override
	@Transactional
	public Propietario save(Propietario propietario) {
		// TODO Auto-generated method stub
		return proDao.save(propietario);
	}



	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
		proDao.deleteById(id);
		
	}
	
	@Override
	
	public List<Propietario> getBooksByTitle(String usuario) {
		// TODO Auto-generated method stub
		return proDao.findByUsuarioContainingIgnoreCase(usuario);
	}

}
