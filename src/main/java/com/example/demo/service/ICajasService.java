package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Cajas;

public interface ICajasService {

public List<Cajas> listarCajas(); //Listar All 
	
	public Cajas guardarCaja(Cajas caja);	//Guarda un video CREATE
	
	public Cajas cajaXID(Long codigo); //Leer datos de un video READ
	
	public Cajas actualizarCaja(Cajas caja); //Actualiza datos del video UPDATE
	
	public void eliminarCaja(Long codigo);// Elimina el video DELETE
}
