package com.studentstay.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentstay.app.Dao.IAdministradorDao;
import com.studentstay.app.Entity.Administrador;

import org.springframework.transaction.annotation.Transactional;

@Service
public class AdministradorServicelmpl implements IAdministradorService {

	@Autowired
	private IAdministradorDao adminDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Administrador> findAll(){
		
		return (List<Administrador>) adminDao.findAll();
		
	}
	
	@Override
	@Transactional
	public Administrador save(Administrador administrador) {
		// TODO Auto-generated method stub
		return adminDao.save(administrador);
	}

	@Override
	@Transactional(readOnly = true)
	public Administrador findById(Long id) {
		// TODO Auto-generated method stub
		return adminDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long idAdmin) {
		// TODO Auto-generated method stub
		adminDao.deleteById(idAdmin);
	}
	
	@Override
	public List<Administrador> getBooksByTitle(String usuario){
		return adminDao.findByUsuarioContainingIgnoreCase(usuario);
	}
	
}
