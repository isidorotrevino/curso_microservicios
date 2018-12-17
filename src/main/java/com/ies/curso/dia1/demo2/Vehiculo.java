package com.ies.curso.dia1.demo2;

public interface Vehiculo {

	public int getNumeroLlantas();
	
	public default String getTipoMotor() {
		return "Gasolina a 2 tiempos";
	}
	
	public void cargarCombustible(double cantidad,String tipo);
	
	public void cargarCombustible(double cantidad);
	
}
