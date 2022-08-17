package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="almacenes")
public class Almacenes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private Long codigo;
	@Column(name = "lugar")//no hace falta si se llama igual
	private String lugar;
	@Column(name = "capacidad")//no hace falta si se llama igual
	private int capacidad;
	
    @OneToMany
    @JoinColumn(name="numReferencia")
    private List<Cajas> cajas;
    
    //Constructores
    
	public Almacenes(Long codigo, String lugar, int capacidad, List<Cajas> cajas) {
		super();
		this.codigo = codigo;
		this.lugar = lugar;
		this.capacidad = capacidad;
		this.cajas = cajas;
	}

	public Almacenes() {

	}

	//Getters y Setters
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cajas")
	public List<Cajas> getCajas() {
		return cajas;
	}

	public void setCajas(List<Cajas> cajas) {
		this.cajas = cajas;
	}

	/**
	 * Metodo toString
	 */
	
	@Override
	public String toString() {
		return "Almacenes [codigo=" + codigo + ", lugar=" + lugar + ", capacidad=" + capacidad + ", cajas=" + cajas
				+ "]";
	}
	
}
