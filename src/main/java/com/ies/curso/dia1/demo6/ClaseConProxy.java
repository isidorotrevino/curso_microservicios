package com.ies.curso.dia1.demo6;

public class ClaseConProxy implements Saludo{

	/*
	 * Agregamos la anotación para procesar el método
	 * con posterioridad	 
	 */
	@UsarProxy
	public void saludar() {
		System.out.println("HOLA MUNDO CON PROXY!!!!");
	}
	
}
