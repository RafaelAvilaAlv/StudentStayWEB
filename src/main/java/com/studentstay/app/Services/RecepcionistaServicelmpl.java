package com.StudentStay.app.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.StudentStay.app.Dao.*;
import com.StudentStay.app.Entity.*;


@Service
public class RecepcionistaServicelmpl implements IRecepcionistaService {


	@Autowired
	private IRecepcionistaDao recepDao;

	@Override
	@Transactional(readOnly = true)
	public List<Recepcionista> findAll() {

		return (List<Recepcionista>) recepDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Recepcionista findById(Long id) {
		// TODO Auto-generated method stub
		return recepDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Recepcionista save(Recepcionista enca) {
		// TODO Auto-generated method stub
		return recepDao.save(enca);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		recepDao.deleteById(id);
	}

	@Override
	public List<Recepcionista> getBooksByTitle(String usuario) {
		return recepDao.findByUsuarioContainingIgnoreCase(usuario);
	}


}
