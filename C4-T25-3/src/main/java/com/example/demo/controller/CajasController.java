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

import com.example.demo.dto.Cajas;
import com.example.demo.service.CajasServiceImpl;

@RestController
@RequestMapping("/api")
public class CajasController {

	@Autowired
	CajasServiceImpl cajasServideImpl;
	
	@GetMapping("/cajas")
	public List<Cajas> listarCajas(){
		return cajasServideImpl.listarCajas();
	}
	
	@PostMapping("/cajas")
	public Cajas salvarCaja(@RequestBody Cajas cajas) {
		
		return cajasServideImpl.guardarCaja(cajas);
	}
	
	@GetMapping("/cajas/{codigo}")
	public Cajas cajasXID(@PathVariable(name="codigo") Long codigo) {
		
		Cajas cajas_xid= new Cajas();
		
		cajas_xid=cajasServideImpl.cajaXID(codigo);
		
		System.out.println("Empleado XID: "+cajas_xid);
		
		return cajas_xid;
	}
	
	@PutMapping("/cajas/{codigo}")
	public Cajas actualizarCaja(@PathVariable(name="codigo") Long codigo,@RequestBody Cajas cajas) {
		
		Cajas cajas_seleccionado;
		Cajas cajas_actualizado;
		
		cajas_seleccionado= cajasServideImpl.cajaXID(codigo);
		
		cajas_seleccionado.setContenido(cajas.getContenido());
		cajas_seleccionado.setValor(cajas.getValor());
		cajas_seleccionado.setAlmacen(cajas.getAlmacen());
		
		cajas_actualizado = cajasServideImpl.actualizarCaja(cajas_seleccionado);
		
		System.out.println("La caja actualizada es: "+ cajas_actualizado);
		
		return cajas_actualizado;
	}
	
	@DeleteMapping("/cajas/{codigo}")
	public void eleiminarArticulo(@PathVariable(name="codigo")Long codigo) {
		cajasServideImpl.eliminarCaja(codigo);
	}
}
