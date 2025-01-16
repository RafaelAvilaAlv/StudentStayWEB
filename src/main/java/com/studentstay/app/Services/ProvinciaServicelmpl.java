package com.studentstay.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.studentstay.app.Dao.*;
import com.studentstay.app.Entity.*;


@Service
public class ProvinciaServicelmpl implements IProvinciaService {
	
	
	@Autowired
	private IProvinciaDao habiDao;

	@Override
	@Transactional(readOnly = true)
	public List<Provincia> findAll() {
		// TODO Auto-generated method stub
		return (List<Provincia>) habiDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	
	public Provincia findById(String id) {
		// TODO Auto-generated method stub
		return habiDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Provincia save(Provincia provi) {
		// TODO Auto-generated method stub
		return habiDao.save(provi);
	}



	@Override
	@Transactional
	public void delete(String id) {
		// TODO Auto-generated method stub
		habiDao.deleteById(id);
	}
	
	

	
	


}
