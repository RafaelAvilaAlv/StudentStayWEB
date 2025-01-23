package com.StudentStay.app.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.StudentStay.app.Dao.*;
import com.StudentStay.app.Entity.*;


@Service
public class EncabezadoFacturaServicelmpl implements IEncabezadoFacturaService {


	@Autowired
	private IEncabezadoFacturaDao encaDao;

	@Override
	@Transactional(readOnly = true)
	public List<EncabezadoFactura> findAll() {

		return (List<EncabezadoFactura>) encaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public EncabezadoFactura findById(Long id) {
		// TODO Auto-generated method stub
		return encaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public EncabezadoFactura save(EncabezadoFactura enca) {
		// TODO Auto-generated method stub
		return encaDao.save(enca);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		encaDao.deleteById(id);
	}
}
