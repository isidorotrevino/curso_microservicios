package com.ies.curso.dia4.front.dto;

import java.util.Objects;

public class Producto {
	private String sku;
	private String nombre;
	private String marca;
	private Boolean descontinuado;

	public Producto() {
	}

	public Producto(String sku, String nombre, String marca, Boolean descontinuado){
		this.sku=sku;
		this.nombre=nombre;
		this.marca=marca;
		this.descontinuado=descontinuado;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Boolean getDescontinuado() {
		return descontinuado;
	}

	public void setDescontinuado(Boolean descontinuado) {
		this.descontinuado = descontinuado;
	}
}
