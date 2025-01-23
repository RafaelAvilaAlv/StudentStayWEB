package com.StudentStay.app.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.StudentStay.app.Dao.*;
import com.StudentStay.app.Entity.*;

@Service
public class DetalleFacturaServicelmpl implements IDetalleFacturaService {


	@Autowired
	private IDetalleFacturaDao detaDao;

	@Override
	@Transactional(readOnly = true)
	public List<detalleFactura> findAll() {

		return (List<detalleFactura>) detaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public detalleFactura findById(Long id) {
		// TODO Auto-generated method stub
		return detaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public detalleFactura save(detalleFactura detalle) {
		// TODO Auto-generated method stub
		return detaDao.save(detalle);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		detaDao.deleteById(id);
	}
}
