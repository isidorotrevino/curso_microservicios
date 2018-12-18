package com.ies.curso.dia2.demo2.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.MediaType;
import io.micronaut.http.client.HttpClient;
import io.micronaut.runtime.server.EmbeddedServer;

public class DemoControllerTest {

	private static EmbeddedServer server;
    private static HttpClient client;

    @BeforeClass
    public static void setupServer() {
        server = ApplicationContext.run(EmbeddedServer.class); 
        client = server
                .getApplicationContext()
                .createBean(HttpClient.class, server.getURL());  
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
    public void testIndex() throws Exception {
        HttpRequest request = HttpRequest.GET("/demo"); 
        String body = client.toBlocking().retrieve(request);
        assertNotNull(body);
        assertEquals(
                body,
                "HOLA MUNDO"
        );
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public void testHolaMundoJson() throws Exception {
    	HttpRequest request = HttpRequest.GET("/demo/holaMundoJson").accept(MediaType.APPLICATION_JSON_TYPE);    	
    	String body = client.toBlocking().retrieve(request);
    	ObjectMapper mapper = new ObjectMapper();
    	Map<?,?> mapa = mapper.readValue(body, Map.class);
    	assertNotNull(mapa);
    	assertEquals("valor1",mapa.get("llave1"));
    	assertEquals("valor2",mapa.get("llave2"));
    	assertEquals("valor3",mapa.get("llave3"));
    }
	
}
