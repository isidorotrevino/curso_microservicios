package com.ies.curso.dia2.demo2.controller;

import java.util.HashMap;
import java.util.Map;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller("/demo")
public class DemoController {

	@Get("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String index() {
		return "HOLA MUNDO";
	}
	
	@Get("/holaMundoJson")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String,String> holaMundoJson(){
		Map<String,String> mapa = new HashMap<>();
		mapa.put("llave1", "valor1");
		mapa.put("llave2", "valor2");
		mapa.put("llave3", "valor3");
		return mapa;
	}
}
