package com.ies.curso.dia2.demo1;

import java.util.Map;
import java.util.Properties;
import java.io.IOException;

public class Application {

	public static void main(String args[]) throws IOException{
		System.out.println("HOLA MUNDO");
		
		Properties properties = new Properties();
		properties.load(Application.class.getResourceAsStream("/configuracion.properties"));
		
		System.out.println("Iteramos sobre nuestro archivo de configuración");
		for(Map.Entry<Object, Object> prop : properties.entrySet()) {
			System.out.println("mapa["+prop.getKey()+"]="+prop.getValue());
		}
	}
	
}
