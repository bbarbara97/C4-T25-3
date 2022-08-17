package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IAlmacenesDAO;
import com.example.demo.dto.Almacenes;

@Service
public class AlmacenesServiceImpl implements IAlmacenesService{

	@Autowired
	IAlmacenesDAO iAlmacenDAO;
	
	@Override
	public List<Almacenes> listarAlmacenes() {
		
		return iAlmacenDAO.findAll();
	}

	@Override
	public Almacenes guardarAlmacen(Almacenes almacen) {
		
		return iAlmacenDAO.save(almacen);
	}

	@Override
	public Almacenes almacenXID(Long codigo) {
		
		return iAlmacenDAO.findById(codigo).get();
	}

	@Override
	public Almacenes actualizarAlmacen(Almacenes almacen) {
		
		return iAlmacenDAO.save(almacen);
	}

	@Override
	public void eliminarAlmacen(Long codigo) {
		
		iAlmacenDAO.deleteById(codigo);
		
	}
	
}
