package com.studentstay.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.studentstay.app.Dao.ICategoriasDao;
import com.studentstay.app.Entity.Categorias;

@Service
public class CategoriasServicelmpl implements ICategoriaService{

	@Autowired
	private ICategoriasDao categoriaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Categorias> findAll() {
		// TODO Auto-generated method stub
		return (List<Categorias>) categoriaDao.findAll();
	}

	@Override
	@Transactional
	public Categorias save(Categorias categorias) {
		// TODO Auto-generated method stub
		return categoriaDao.save(categorias);
	}

	@Override
	@Transactional
	public Categorias findById(Long idCategoria) {
		// TODO Auto-generated method stub
		return categoriaDao.findById(idCategoria).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long idCategoria) {
		// TODO Auto-generated method stub
		categoriaDao.deleteById(idCategoria);
	}

}
