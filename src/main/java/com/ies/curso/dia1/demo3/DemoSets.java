package com.ies.curso.dia1.demo3;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class DemoSets {

	public void mostrarDemo() {
		/*
		 * Utilizamos el set más usual
		 */
		SortedSet<String> set = new TreeSet<>();
		//No importa el orden en que se agreguen, internamente serán ordenados
		set.add("Elemento5");
		set.add("Elemento3");
		set.add("Elemento4");
		set.add("Elemento2");
		set.add("Elemento1");
		set.add("Elemento5");
		set.add("Elemento5");
		
		//Adicional a los métodos de iteración tradicionales, podemos utilizar Streams:
		System.out.println("Iteración por medio de stream");
		set.stream().forEach(e -> System.out.println("-> "+e));
		
		/*Se pueden construir streams más complejos para realizar procesamiento a las
		 * colecciones
		 * 
		 * En este caso mediante el método map, creamos una nueva colección con todos los 
		 * elementos en mayúscula
		 * 
		 * El método sorted reordena los elementos en el set
		 * 
		 * Finalmente el método collect transforma el stream en un nuevo set
		 */
		List<String> nuevaColeccion = set.stream().map(String::toUpperCase).sorted().collect(Collectors.toList());
		System.out.println("Nueva coleccion a partir de procesamiento de un stream");
		for(String s : nuevaColeccion) {
			System.out.println("=> "+s);
		}
		
		
	}
	
}
