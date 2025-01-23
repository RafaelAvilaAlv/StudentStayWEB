package com.StudentStay.app.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.StudentStay.app.Dao.*;
import com.StudentStay.app.Entity.*;

@Service
public class MetodoPagoServicelmpl implements IMetodoPagoService {


	@Autowired
	private IMetodoPagoDao pagoDao;

	@Override
	@Transactional(readOnly = true)
	public List<MetodoPago> findAll() {

		return (List<MetodoPago>) pagoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public MetodoPago findById(Long id) {
		// TODO Auto-generated method stub
		return pagoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public MetodoPago save(MetodoPago enca) {
		// TODO Auto-generated method stub
		return pagoDao.save(enca);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		pagoDao.deleteById(id);
	}
}
