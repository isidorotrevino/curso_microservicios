package com.ies.curso.dia1.demo2;

public class Automovil implements Vehiculo {

	private double combustible;
	
	private String tipoCombustible;
	
	@Override
	public int getNumeroLlantas() {
		return 4;
	}

	@Override
	public String getTipoMotor() {
		return "Gasolina a 4 tiempos";
	}

	@Override
	public void cargarCombustible(double cantidad, String tipo) {
		System.out.println("Cargando "+cantidad+" litros de "+tipo);
		combustible = cantidad;
		tipoCombustible=tipo;
	}

	@Override
	public void cargarCombustible(double cantidad) {
		cargarCombustible(cantidad,"Magna");
	}

}
