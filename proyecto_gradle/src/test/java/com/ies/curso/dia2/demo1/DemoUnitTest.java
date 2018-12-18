
package com.ies.curso.dia2.demo1;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DemoUnitTest {

	@Test
	public void probarMetodo() {
		String mensaje = "HOLA MUNDO";
		System.out.println(mensaje);
		int longitud = mensaje.length();
		assertEquals(10,longitud);
	}
	
}
