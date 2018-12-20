package com.ies.curso.dia4.front.controller;

import java.security.Principal;
import java.util.List;

import com.ies.curso.dia4.front.client.ProductoOperations;

import com.ies.curso.dia4.front.dto.Paquete;
import com.ies.curso.dia4.front.dto.Producto;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.tracing.annotation.NewSpan;
import io.reactivex.Single;


@Controller("/paquetes")
public class PaqueteController {

	private final ProductoOperations productoOperations;

	public PaqueteController(ProductoOperations productoOperations) {
		this.productoOperations = productoOperations;
	}

	@NewSpan()
	@Get("/")
	public Paquete index() {
		Paquete paquete = new Paquete();
		paquete.setNombre("Paquete Atasques");
		Single<List<Producto>> productos =	productoOperations.findAll()
				.toList();
		paquete.setProductos(productos.blockingGet());
		System.out.println("PRODUCTOS "+paquete.getProductos());
		return paquete;
	}

	@Get("/principal")
	String index(Principal principal) {
		return principal.getName();
	}
}
