package com.studentstay.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.studentstay.app.Dao.IPersonaDao;
import com.studentstay.app.Entity.Persona;



@Service
public class PersonaServiceImpl implements IPersonaService{
	@Autowired
	private IPersonaDao persoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Persona> findAll() {

		return (List<Persona>) persoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Persona findById(String id) {
		// TODO Auto-generated method stub
		return persoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Persona save(Persona persona) {
		// TODO Auto-generated method stub
		return persoDao.save(persona);
	}

	@Override
	@Transactional
	public void delete(String id) {
		// TODO Auto-generated method stub
		persoDao.deleteById(id);
	}
	

}
