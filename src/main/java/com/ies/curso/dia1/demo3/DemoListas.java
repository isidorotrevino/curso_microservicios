package com.ies.curso.dia1.demo3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DemoListas {

	public void mostrarDemo() {
		/* Entre las buenas prácticas tenemos:
		 * - Siempre es recomendable que la variable utilice la interface 
		 *   más generica requerida (List)
		 * - El término <String> es un "generic" y sirve para indicar en tiempo
		 * de compilación que tipo de objetos estaremos utilizando 
		 */
		List<String> lista = new ArrayList<>();
		//Para agregar elementos usamos add
		lista.add("Término 1");
		lista.add("Término 2");
		lista.add("Término 3");
		//Podemos iterar por medio de un simple for
		System.out.println("Iteración por medio de un for clásico");
		for(int i=0; i<lista.size();i++) {
			System.out.println("Elemento en el índice "+i+" => "+lista.get(i));
		}
		
		System.out.println("Iteración por medio de un 'Iterator'");
		Iterator<String> iter = lista.iterator();
		while(iter.hasNext()) {
			System.out.println("Elemento => "+iter.next());
		}
	}
	
}
