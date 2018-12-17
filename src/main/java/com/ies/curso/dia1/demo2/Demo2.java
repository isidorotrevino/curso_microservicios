package com.ies.curso.dia1.demo2;

public class Demo2 {

	public static void main(String args[]) {
		Demo2 demo = new Demo2();
		Vehiculo v = new Automovil();
		demo.analizarVehiculo(v);
		v = new CamionCarga();
		demo.analizarVehiculo(v);
		v = new Motocicleta();
		demo.analizarVehiculo(v);
		v = new Cuatrimoto();
		demo.analizarVehiculo(v);
		
	}
	
	public void analizarVehiculo(Vehiculo v) {
		System.out.println("El vehiculo es un "+v.getClass().getSimpleName());
		System.out.println("El vehículo tiene "+v.getNumeroLlantas()+" llantas");
		System.out.println("Tiene un motor de tipo "+v.getTipoMotor());
		v.cargarCombustible(25.34);
		System.out.println();
	}
}
