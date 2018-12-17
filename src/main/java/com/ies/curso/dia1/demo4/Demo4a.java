package com.ies.curso.dia1.demo4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class Demo4a {

	public static void main(String args[]) {

		InputStream input = null;
		OutputStream output = null;
		
		System.out.println("Copiamos una página de internet a un archivo");
		
		try {
			// Abrimos un stream que va a leer el contenido de un sitio web
			input = new URL("http://micronaut.io/").openStream();
			// Abrimos un stream que va a escribir el resultado a un archivo
			output = new FileOutputStream("/tmp/micronaut.txt");
			int c;
			//Copiamos byte por byte 
			while ((c = input.read()) != -1) {
				output.write(c);
			}
		} catch (IOException ex) {
			/*
			 * Si ocurre algún problema, manda a terminal la pila de ejecución
			 */
			ex.printStackTrace();
		} finally {
			/* El bloque finally siempre se ejecuta
			 * En este caso siempre cerramos los streams para evitar cualquier fuga
			 */
			try {
				if (input != null) {
					input.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

}
