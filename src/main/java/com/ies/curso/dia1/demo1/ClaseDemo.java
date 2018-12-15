package com.ies.curso.dia1.demo1;

/**
 * El texto incluído entre la notación de /** y *\/  
 * se consideran "Comentarios" y no tienen ningún efecto
 * en la ejecución del programa, sin embargo, pueden servir
 * para generar documentación (javadoc)
 */
public class ClaseDemo {

	/**
	 * Se recomienda que el modificador de un atributo
	 * sea de tipo private o protected, para evitar modificaciones
	 * sin control por parte de otras clases
	 */
	private String nombre;
	
	/**
	 * El punto de inicio a un programa siempre será una función
	 * con esta definición
	 * 
	 * @param args Cualquier argumento proporcionado en línea de 
	 * comando caerá en esta variable
	 */
	public static void main(String args[]) {
		// Mandamos un mensaje a imprimir en la terminal
		System.out.println("Aquí comenzamos la ejecución");
		
		/* Los comentarios que comienzan con // o /* y *\/ solo sirven para proporcionar anotaciones al
		 programa y no tienen ningún efecto en la ejecución o en la generación de javadoc */
		
		//Creamos un objeto que sea una instancia de esta misma clase
		ClaseDemo demo = new ClaseDemo();
		
		//Asignamos un valor al atributo nombre
		demo.setNombre("Juan");
		
		System.out.println("El nombre que asignamos es "+demo.getNombre());
	}
	
	
	public void setNombre(String n) {
		nombre = n;
	}
	
	public String getNombre() {
		return nombre;
	}
	
}
