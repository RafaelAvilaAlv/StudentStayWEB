package com.studentstay.app.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.studentstay.app.Dao.*;
import com.studentstay.app.Entity.*;


@Service
public class CantonesServicelmpl implements ICantonesService {



	@Autowired
	private ICantonesDao cantonDao;

	@Override
	@Transactional(readOnly = true)
	public List<Cantones> findAll() {

		return (List<Cantones>) cantonDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Cantones findById(String id) {
		// TODO Auto-generated method stub
		return cantonDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cantones save(Cantones admin) {
		// TODO Auto-generated method stub
		return cantonDao.save(admin);
	}

	@Override
	@Transactional
	public void delete(String id) {
		// TODO Auto-generated method stub
		cantonDao.deleteById(id);
	}
}