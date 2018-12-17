package com.ies.curso.dia1.demo4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Demo4b {

	public static void main(String args[]) {
		
		/* Podemos usar una sintaxis simplificada para
		 * automáticamente cerrar los streams al terminar el 
		 * bloque try
		 * 
		 */
		try(InputStream input = new FileInputStream("/tmp/micronaut.txt");
			/* Por regla general no tenemos permisos
			 * para el directorio /proc, por lo que debe
			 * lanzarse una excepción
			 */	
			OutputStream output = new FileOutputStream("/proc/micronaut.txt");){
			
			
			int c;
			//Copiamos byte por byte 
			while ((c = input.read()) != -1) {
				output.write(c);
			}
		} catch ( IOException e) {
			System.out.println("Ocurrió un error al escribir archivo");
			e.printStackTrace();
		}
		
	}
	
}
