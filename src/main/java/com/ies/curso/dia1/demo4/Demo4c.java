package com.ies.curso.dia1.demo4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;

public class Demo4c {

	/*
	 * En lugar de utilizar try/catch para manejar la excepción
	 * en el mismo método, se puede utilizar throws para que sea 
	 * el método superior el que la maneje
	 */
	public static void main(String args[])  {
		
		try {
			copiarArchivo();
			copiarArchivoConChannel();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected static void copiarArchivo() throws IOException {
		Files.copy(new File("/tmp/micronaut.txt").toPath(),new File("/tmp/copia.txt").toPath());
	}
	
	protected static void copiarArchivoConChannel()  {
		FileChannel sourceChannel = null;
	    FileChannel destChannel = null;
	    try {
			sourceChannel = new FileInputStream("/tmp/micronaut.txt").getChannel();
			destChannel = new FileOutputStream("/tmp/copia2.txt").getChannel();
	        destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
		} catch (IOException e) {
			throw new RuntimeException("Ocurrió un problema al procesar el archivo",e);
		}
        finally {
        	try {
				sourceChannel.close();
				destChannel.close();
				/*
				 * El utilizar Throwable nos sirve para capturar excepciones de
				 * tipo checked y unchecked 
				 */
			} catch (Throwable t) {
				//Podemos aventar una nueva excepción que englobe la anterior
				throw new RuntimeException("Ocurrió un problema al procesar el archivo",t);
			}
            
        }
        
	}
	
}
