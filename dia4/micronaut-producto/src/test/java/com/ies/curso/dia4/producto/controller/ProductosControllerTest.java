package com.ies.curso.dia4.producto.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import com.ies.curso.dia4.producto.dto.Producto;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


import io.micronaut.context.ApplicationContext;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.runtime.server.EmbeddedServer;

public class ProductosControllerTest {
	private static EmbeddedServer server;
	private static HttpClient client;

	@BeforeClass
	public static void setupServer() {
		server = ApplicationContext.run(EmbeddedServer.class);
		client = server.getApplicationContext().createBean(HttpClient.class, server.getURL());
	}

	@AfterClass
	public static void stopServer() {
		if (server != null) {
			server.stop();
		}
		if (client != null) {
			client.stop();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testConsultarProductos() {
		HttpRequest request = HttpRequest.GET("/productos");
		List productos = client.toBlocking().retrieve(request, Argument.of(List.class, Producto.class));
		assertEquals(3, productos.size());
		assertTrue(productos.contains(new Producto("Palomitas", "Act One","PAL123",false)));
		assertTrue(productos.contains(new Producto("Coca Light", "Coca Cola","COC123",false)));
	}
}
