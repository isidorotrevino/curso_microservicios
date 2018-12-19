package com.ies.curso.dia2.demo2.controller;

import java.util.List;

import javax.validation.Valid;

import com.ies.curso.dia2.demo2.command.ProductoCommand;
import com.ies.curso.dia2.demo2.domain.Producto;
import com.ies.curso.dia2.demo2.service.ProductoService;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.annotation.Put;
import io.micronaut.validation.Validated;

@Validated
@Controller("/producto")
public class ProductoController {

	protected ProductoService productoService;

	public ProductoController(ProductoService productoService) {
		super();
		this.productoService = productoService;
	}
	
	@Get("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Producto> listarProductos(){
		return productoService.findAll();
	}
	
	@Get("/buscar/{marca}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Producto> listarProductos(String marca){
		return productoService.findAllByMarca(marca);
	}
	
	@Get("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Producto obtenerProductos(Long id){
		return productoService.find(id);
	}
	
	@Post("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Producto crearProducto(@Valid @Body ProductoCommand command) {
		Producto producto = productoService.save(command.getNombre(), command.getSku(), command.getMarca(), command.getDescontinuado());
		return producto;
	}
	
	@Put("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Producto crearProducto(Long id,@Valid @Body ProductoCommand command) {
		
		Producto producto = productoService.find(id);
		if(producto!=null) {
			producto.setNombre(command.getNombre());
			producto.setSku(command.getSku());
			producto.setMarca(command.getMarca());
			producto = productoService.saveProducto(producto);
		}
				
		return producto;
	}
	
}
