package com.StudentStay.app.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.StudentStay.app.Dao.*;
import com.StudentStay.app.Entity.*;

@Service
public class CategoriasServicelmpl implements ICategoriasService {



	@Autowired
	private ICategoriasDao canteDao;

	@Override
	@Transactional(readOnly = true)
	public List<Categorias> findAll() {

		return (List<Categorias>) canteDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Categorias findById(Long id) {
		// TODO Auto-generated method stub
		return canteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Categorias save(Categorias cate) {
		// TODO Auto-generated method stub
		return canteDao.save(cate);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		canteDao.deleteById(id);
	}
}
