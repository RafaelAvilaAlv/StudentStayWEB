package com.studentstay.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.studentstay.app.Dao.*;
import com.studentstay.app.Entity.*;


@Service
public class TipoServicioServicelmpl  implements ITipoServicioService{
	
	
	@Autowired
	private ITipoServicioDao tiposerviDao;

	@Override
	@Transactional(readOnly = true)
	public List<TipoServicio> findAll() {
		// TODO Auto-generated method stub
		return (List<TipoServicio>) tiposerviDao.findAll();
	}

	@Override
	@Transactional
	public TipoServicio save(TipoServicio tipoSer) {
		// TODO Auto-generated method stub
		return tiposerviDao.save(tipoSer);
	}

	@Override
	@Transactional(readOnly = true)
	public TipoServicio findById(Long id) {
		// TODO Auto-generated method stub
		return tiposerviDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		tiposerviDao.deleteById(id);
	}

}
