package com.ies.curso.dia1.demo6;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

public class ManejadorProxy implements InvocationHandler{

	private Saludo instancia;
	
	public ManejadorProxy(Saludo sal) {
		instancia = sal;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//Usamos la funcionalidad de collection streams para localizar una clase rápidamente
		//La clase Optional nos ayuda a manejar mejor los resultados vacíos para evitar 
		// excepciones de tipo NullPointerException
		
		/*
		 * Ubicamos el equivalente del método del proxy (basado en una interface) correspondiente
		 * a la clase que estamos decorando
		 */
		Optional<Method> instanceMethod = 
				Arrays.stream(instancia.getClass().getMethods())
				.filter(m -> m.getName().equals(method.getName())).findFirst();
		
		if(instanceMethod.isPresent()) {
			Annotation[] annotations  = instanceMethod.get().getDeclaredAnnotations();
		
			Optional<Annotation> ann = Arrays.stream(annotations).filter(a -> {
					return a instanceof UsarProxy;
				}).findFirst();
		
			/*
			 * Si localizamos nuestra anotación, entonces interceptamos la llamada
			 */
			if(ann.isPresent()) {
				System.out.println("Estamos interceptando este saludo");
			}
		}
		
		return method.invoke(instancia, args);
	}

}
