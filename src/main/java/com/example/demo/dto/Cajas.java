package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cajas")
public class Cajas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numReferencia;
	@Column(name = "contenido")
	private String contenido;
	@Column(name = "valor")
	private int valor;
	
	@ManyToOne
    @JoinColumn(name="almacen")
    private Almacenes almacen;

	//Constructores
	
	public Cajas(int numReferencia, String contenido, int valor, Almacenes almacen) {
		super();
		this.numReferencia = numReferencia;
		this.contenido = contenido;
		this.valor = valor;
		this.almacen = almacen;
	}

	public Cajas() {
		
	}

	//Getters y Setters

	public int getNumReferencia() {
		return numReferencia;
	}

	public void setNumReferencia(int numReferencia) {
		this.numReferencia = numReferencia;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Almacenes getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Almacenes almacen) {
		this.almacen = almacen;
	}

	/**
	 * Metodo toString
	 */
	
	@Override
	public String toString() {
		return "Cajas [numReferencia=" + numReferencia + ", contenido=" + contenido + ", valor=" + valor + ", almacen="
				+ almacen + "]";
	}
	
}
