package com.ies.curso.dia1.demo5;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.ies.curso.dia1.demo2.Automovil;

public class Demo5 {

	public static void main(String args[]) {
		try {
			Automovil auto = new Automovil();
			auto.cargarCombustible(52.3, "Premium");
			Class<?> clase = auto.getClass();
			System.out.println("La clase que estamos revisando se llama " + clase.getName());

			Field[] fields = clase.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				System.out.println("Campo ->" + fields[i].getName());
				
				//Modificamos el atributo de private a public
				fields[i].setAccessible(true);
				
				System.out.println("Valor -> "+fields[i].get(auto));
				
			}
			
			Method[] metodos = clase.getDeclaredMethods();
			for (int i = 0; i < metodos.length; i++) {
				System.out.println("Metodo ->" + metodos[i].getName()+" con parametros "
						+ metodos[i].getParameterCount());
				if(metodos[i].getName().indexOf("Llanta")!=-1) {
					System.out.println("Llantas = " + metodos[i].invoke(auto));
				}
				Annotation[] annotations = metodos[i].getDeclaredAnnotations();
				for(int j=0;j<annotations.length;j++) {
					System.out.println("-- "+annotations[j].annotationType().getName());
				}
			}
			
			/*
			 * Cuando se arrojan diversos tipos de excepciones se pueden agrupar en un
			 * solo bloque catch
			 */
		} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
