package com.ies.curso.dia4.producto.dto;

import java.util.Objects;

public class Producto {

	private String nombre;
	private String marca;
	private String sku;
	private Boolean descontinuado;

	public Producto(){

	}

	public Producto(String nombre, String marca, String sku, Boolean descontinuado) {
		this.nombre = nombre;
		this.marca = marca;
		this.sku = sku;
		this.descontinuado = descontinuado;
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

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public Boolean getDescontinuado() {
		return descontinuado;
	}

	public void setDescontinuado(Boolean descontinuado) {
		this.descontinuado = descontinuado;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Producto producto = (Producto) o;
		return Objects.equals(nombre, producto.nombre) &&
				Objects.equals(marca, producto.marca) &&
				Objects.equals(sku, producto.sku) &&
				Objects.equals(descontinuado, producto.descontinuado);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, marca, sku, descontinuado);
	}
}
