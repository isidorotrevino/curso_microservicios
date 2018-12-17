package com.ies.curso.dia1.demo2;

public class Motocicleta implements Vehiculo {

	@Override
	public int getNumeroLlantas() {
		return 2;
	}

	@Override
	public void cargarCombustible(double cantidad, String tipo) {
		System.out.println("Cargando "+cantidad+" litros de "+tipo);
	}

	@Override
	public void cargarCombustible(double cantidad) {
		cargarCombustible(cantidad,"Magna");
	}

}
