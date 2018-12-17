package com.ies.curso.dia1.demo6;

import java.lang.reflect.Proxy;

public class Demo6 {

	public static void main(String args[]) {
		Saludo csp = new ClaseSinProxy();
		Saludo ccp = new ClaseConProxy();
		
		csp = (Saludo) Proxy.newProxyInstance(Demo6.class.getClassLoader(), 
				new Class[] {Saludo.class}, new ManejadorProxy(csp));
		ccp = (Saludo) Proxy.newProxyInstance(Demo6.class.getClassLoader(), 
				new Class[] {Saludo.class}, new ManejadorProxy(ccp));
		
		csp.saludar();
		ccp.saludar();
	}

}
