package com.studentstay.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.studentstay.app.Dao.IMetodoPagoDao;
import com.studentstay.app.Entity.MetodoPago;


@Service
public class MetodoPagoServiceImpl implements IMetodoPagoService {
	
	@Autowired
    private IMetodoPagoDao pagoDao;

    @Override
    @Transactional(readOnly = true)
    public List<MetodoPago> findAll() {
        return (List<MetodoPago>) pagoDao.findAll();
    }

    @Override
    @Transactional
    public MetodoPago save(MetodoPago metodopago) {
        return pagoDao.save(metodopago);
    }

    @Override
    @Transactional(readOnly = true)
    public MetodoPago findById(Long id) {
        return pagoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long idPago) {
        pagoDao.deleteById(idPago);
    }


}
