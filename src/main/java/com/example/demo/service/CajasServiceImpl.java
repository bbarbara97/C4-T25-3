package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICajasDAO;
import com.example.demo.dto.Cajas;


@Service
public class CajasServiceImpl implements ICajasService{

	
	@Autowired
	ICajasDAO iCajasDAO;
	
	@Override
	public List<Cajas> listarCajas() {
		
		return iCajasDAO.findAll();
	}

	@Override
	public Cajas guardarCaja(Cajas caja) {
		
		return iCajasDAO.save(caja);
	}

	@Override
	public Cajas cajaXID(Long codigo) {
		return iCajasDAO.findById(codigo).get();

	}

	@Override
	public Cajas actualizarCaja(Cajas caja) {
		
		return iCajasDAO.save(caja);
	}

	@Override
	public void eliminarCaja(Long codigo) {
		
		iCajasDAO.deleteById(codigo);
		
	}
}
