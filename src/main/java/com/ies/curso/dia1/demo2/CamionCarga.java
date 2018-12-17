package com.ies.curso.dia1.demo2;

public class CamionCarga implements Vehiculo{

	@Override
	public int getNumeroLlantas() {
		return 6;
	}

	@Override
	public String getTipoMotor() {
		return "Diesel";
	}

	@Override
	public void cargarCombustible(double cantidad, String tipo) {
		System.out.println("Cargando "+cantidad+" litros de "+tipo);
	}

	@Override
	public void cargarCombustible(double cantidad) {
		cargarCombustible(cantidad,"Diesel");
	}

}
