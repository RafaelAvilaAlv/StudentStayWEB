package com.studentstay.app.Dao;

import org.springframework.data.repository.CrudRepository;

import com.studentstay.app.Entity.detalleFactura;

public interface IDetalleFacturaDao extends CrudRepository<detalleFactura, Long> {

}
