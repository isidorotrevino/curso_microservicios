package com.ies.curso.dia1.demo3;

import java.util.HashMap;
import java.util.Map;

public class DemoMapas {

	public void mostrarDemo() {
		/*
		 * Los mapas pueden utilizar dos "generics", uno para el tipo de objeto
		 * que se utilizará en la llave, y otro para el valor
		 * 
		 */
		Map<String,String> mapa = new HashMap<>();
		
		//Para asignar elementos se utiliza el método "put"
		mapa.put("llave1", "valor1");
		mapa.put("llave2", "valor2");
		mapa.put("llave3", "valor3");
				
		//Podemos iterar por medio de un "for each"
		//De manera interna, una colección puede apoyarse de otras para su funcionamiento
		//En el caso de los maps, podemos utilizar un "EntrySet" para iterar las duplas llave/valor
		System.out.println("Iteración por medio de foreach ");
		for(Map.Entry<String, String> elemento : mapa.entrySet()) {
			System.out.println("mapa["+elemento.getKey()+"]="+elemento.getValue());
		}
		
		//O podemos utilizar un keySet(), que nos devuelve una colección de llaves
		System.out.println("Iteración por medio de keyset");
		for(String llave : mapa.keySet()) {
			System.out.println("mapa["+llave+"]="+mapa.get(llave));
		}
		
		
	}
	
}
