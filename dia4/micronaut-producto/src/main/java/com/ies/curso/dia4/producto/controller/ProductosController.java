package com.ies.curso.dia4.producto.controller;

import java.util.Arrays;
import java.util.List;


import com.ies.curso.dia4.producto.dto.Producto;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.tracing.annotation.ContinueSpan;

@Controller("/productos")
public class ProductosController {

	@Get("/")
	@ContinueSpan
	List<Producto> index() {
		Producto palomitas = new Producto("Palomitas", "Act One","PAL123",false);
		Producto papas = new Producto("Adobadas", "Sabritas","PAP123",false);
		Producto refresco = new Producto("Coca Light", "Coca Cola","COC123",false);
		return Arrays.asList(palomitas, papas, refresco);
	}
}
