package com.studentstay.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.studentstay.app.Dao.IDetalleFacturaDao;
import com.studentstay.app.Entity.detalleFactura;

@Service
public class DetalleFacturaServicelmpl implements IDetalleFacturaService {

	@Autowired
	private IDetalleFacturaDao detalleDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<detalleFactura> findAll() {
		// TODO Auto-generated method stub
		return (List<detalleFactura>) detalleDao.findAll();
	}

	@Override
	@Transactional
	public detalleFactura save(detalleFactura detallefactura) {
		// TODO Auto-generated method stub
		return detalleDao.save(detallefactura);
	}

	@Override
	@Transactional(readOnly = true)
	public detalleFactura finById(Long idDetalleF) {
		// TODO Auto-generated method stub
		return detalleDao.findById(idDetalleF).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long idDetalleF) {
		// TODO Auto-generated method stub
		detalleDao.deleteById(idDetalleF);
	}

}
