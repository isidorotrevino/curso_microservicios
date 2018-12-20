package com.ies.curso.dia4.front.controller;

import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ies.curso.dia4.front.dto.Paquete;
import io.micronaut.http.client.HttpClient;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.RxStreamingHttpClient;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.security.authentication.UsernamePasswordCredentials;
import io.micronaut.security.token.jwt.render.BearerAccessRefreshToken;
import io.reactivex.Flowable;

public class PaqueteControllerTest {
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
        if(server != null) {
            server.stop();
        }
        if(client != null) {
            client.stop();
        }
    }

    @SuppressWarnings("unchecked")
	@Test
    public void testObtenerPaquetes() throws Exception {

        String body = client.toBlocking().retrieve(HttpRequest.GET("/paquetes"));
        ObjectMapper mapper = new ObjectMapper();
        Paquete paquete = mapper.readValue(body,Paquete.class);
        assertEquals(paquete.getProductos().size(), 2);
        assertEquals(paquete.getProductos().get(0).getNombre(), "Adobadas");
    }
}