package com.studentstay.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.studentstay.app.Dao.ICantonesDao;
import com.studentstay.app.Entity.Cantones;

@Service
public class CantonesServicelmpl implements ICantonesService {
	
	@Autowired
	private ICantonesDao cantonDao;
	

	@Override
	@Transactional(readOnly = true)
	public List<Cantones> finAll() {
		// TODO Auto-generated method stub
		return (List<Cantones>) cantonDao.findAll();
	}

	@Override
	@Transactional
	public Cantones save(Cantones cantones) {
		// TODO Auto-generated method stub
		return cantonDao.save(cantones);
	}

	@Override
	@Transactional(readOnly = true)
	public Cantones findById(String id_canton) {
		// TODO Auto-generated method stub
		return cantonDao.findById(id_canton).orElse(null);
	}

	@Override
	@Transactional
	public void delete(String id_canton) {
		// TODO Auto-generated method stub
		cantonDao.deleteById(id_canton);
	}

}
