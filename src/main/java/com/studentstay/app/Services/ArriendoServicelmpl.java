package com.studentstay.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentstay.app.Dao.IArriendoDao;
import com.studentstay.app.Entity.Arriendo;

import org.springframework.transaction.annotation.Transactional;

@Service
public class ArriendoServicelmpl implements IArriendoService {
	
	@Autowired
	private IArriendoDao arriendoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Arriendo> findAll() {
		// TODO Auto-generated method stub
		return (List<Arriendo>) arriendoDao.findAll();
	}

	@Override
	@Transactional
	public Arriendo save(Arriendo arriendo) {
		// TODO Auto-generated method stub
		return arriendoDao.save(arriendo);
	}

	@Override
	@Transactional(readOnly = true)
	public Arriendo findById(Long idArriendo) {
		// TODO Auto-generated method stub
		return arriendoDao.findById(idArriendo).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long idArriendo) {
		// TODO Auto-generated method stub
		arriendoDao.deleteById(idArriendo);
	}

	
}
