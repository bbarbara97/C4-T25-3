package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Almacenes;

public interface IAlmacenesService {

	public List<Almacenes> listarAlmacenes(); //Listar All 
	
	public Almacenes guardarAlmacen(Almacenes almacen);	//Guarda un video CREATE
	
	public Almacenes almacenXID(Long id); //Leer datos de un video READ
	
	public Almacenes actualizarAlmacen(Almacenes almacen); //Actualiza datos del video UPDATE
	
	public void eliminarAlmacen(Long id);// Elimina el video DELETE
}
