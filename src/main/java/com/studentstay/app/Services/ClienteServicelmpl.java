package com.studentstay.app.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.studentstay.app.Dao.*;
import com.studentstay.app.Entity.*;

@Service
public class ClienteServicelmpl implements IClienteService {


	@Autowired
	private IClienteDao cliDao;

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {

		return (List<Cliente>) cliDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		// TODO Auto-generated method stub
		return cliDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cli) {
		// TODO Auto-generated method stub
		return cliDao.save(cli);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		cliDao.deleteById(id);
	}


	@Override
	public List<Cliente> getBooksByTitle(String usuario) {
		// TODO Auto-generated method stub
		return cliDao.findByUsuarioContainingIgnoreCase(usuario);
	}
}
