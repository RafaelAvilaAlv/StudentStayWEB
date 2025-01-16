package com.studentstay.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.studentstay.app.Dao.IEncabezadoFacturaDao;
import com.studentstay.app.Entity.EncabezadoFactura;

public class EncabezadoFacturaServicelmpl implements IEncabezadoFacturaService {

	@Autowired
	private IEncabezadoFacturaDao encabezadoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<EncabezadoFactura> findAll() {
		// TODO Auto-generated method stub
		return (List<EncabezadoFactura>) encabezadoDao.findAll();
	}

	@Override
	@Transactional
	public EncabezadoFactura save(EncabezadoFactura encabezadoFactu) {
		// TODO Auto-generated method stub
		return encabezadoDao.save(encabezadoFactu);
	}

	@Override
	@Transactional(readOnly = true)
	public EncabezadoFactura findById(Long idEncabezado) {
		// TODO Auto-generated method stub
		return encabezadoDao.findById(idEncabezado).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long idEncabezado) {
		// TODO Auto-generated method stub
		encabezadoDao.deleteById(idEncabezado);
	}

}
