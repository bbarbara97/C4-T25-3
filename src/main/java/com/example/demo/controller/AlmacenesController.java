package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Almacenes;
import com.example.demo.service.AlmacenesServiceImpl;


@RestController
@RequestMapping("/api")
public class AlmacenesController {

	@Autowired
	AlmacenesServiceImpl almacenesServideImpl;

	@GetMapping("/almacenes")
	public List<Almacenes> listarAlmacenes(){
		return almacenesServideImpl.listarAlmacenes();
	}

	@PostMapping("/almacenes")
	public Almacenes salvarAlmacenes(@RequestBody Almacenes almacenes) {

		return almacenesServideImpl.guardarAlmacen(almacenes);
	}

	@GetMapping("/almacenes/{codigo}")
	public Almacenes almacenesXID(@PathVariable(name="codigo") Long codigo) {

		Almacenes almacenes_xid= new Almacenes();

		almacenes_xid=almacenesServideImpl.almacenXID(codigo);

		System.out.println("almacenes XID: "+almacenes_xid);

		return almacenes_xid;
	}

	@PutMapping("/almacenes/{codigo}")
	public Almacenes actualizarAlmacen(@PathVariable(name="codigo")Long codigo,@RequestBody Almacenes almacenes) {

		Almacenes almacenes_seleccionado;
		Almacenes almacenes_actualizado;

		almacenes_seleccionado= almacenesServideImpl.almacenXID(codigo);

		almacenes_seleccionado.setLugar(almacenes.getLugar());
		almacenes_seleccionado.setCapacidad(almacenes.getCapacidad());
		almacenes_seleccionado.setCajas(almacenes.getCajas());

		almacenes_actualizado = almacenesServideImpl.actualizarAlmacen(almacenes_seleccionado);

		System.out.println("El almacenes actualizado es: "+ almacenes_actualizado);

		return almacenes_actualizado;
	}

	@DeleteMapping("/almacenes/{codigo}")
	public void eliminarAlmacen(@PathVariable(name="codigo")Long codigo) {
		almacenesServideImpl.eliminarAlmacen(codigo);
	}
}
