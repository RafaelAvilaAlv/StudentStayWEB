package com.studentstay.app.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.studentstay.app.Dao.*;
import com.studentstay.app.Entity.*;

@Service
public class ReservasServicelmpl implements IReservasService {


	@Autowired
	private IReservasDao reserDao;

	@Override
	@Transactional(readOnly = true)
	public List<Reservas> findAll() {

		return (List<Reservas>) reserDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Reservas findById(Long id) {
		// TODO Auto-generated method stub
		return reserDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Reservas save(Reservas enca) {
		// TODO Auto-generated method stub
		return reserDao.save(enca);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		reserDao.deleteById(id);
	}
}
