package com.ies.curso.dia3.controller

import com.nimbusds.jwt.JWTParser
import com.nimbusds.jwt.SignedJWT
import io.micronaut.context.ApplicationContext
import io.micronaut.http.HttpHeaders
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.security.authentication.UsernamePasswordCredentials
import io.micronaut.security.token.jwt.render.BearerAccessRefreshToken
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.HttpRequest

class JwtAuthenticationSpec extends Specification {

    @Shared
    @AutoCleanup // <1>
    EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer) // <2>

    @Shared
    @AutoCleanup
    RxHttpClient client = embeddedServer.applicationContext.createBean(RxHttpClient, embeddedServer.getURL()) // <3>

    def "Verificar que la autenticación JWT funciona"() {
        when: 'Ingreango a una URL segura sin autenticar'
        client.toBlocking().exchange(HttpRequest.GET('/', )) // <4>

        then: 'regresa Unauthorized'
        HttpClientResponseException e = thrown(HttpClientResponseException)
        e.status == HttpStatus.UNAUTHORIZED

        when: 'Se invoca el endpoint de login con credenciales válidas'
        UsernamePasswordCredentials creds = new UsernamePasswordCredentials("juan", "perez")
        HttpRequest request = HttpRequest.POST('/login', creds)
        HttpResponse<BearerAccessRefreshToken> rsp = client.toBlocking().exchange(request, BearerAccessRefreshToken)

        then: 'el endpoint es accesible'
        rsp.status == HttpStatus.OK
        rsp.body().username == 'juan'
        rsp.body().accessToken
        JWTParser.parse(rsp.body().accessToken) instanceof SignedJWT
        rsp.body().refreshToken
        JWTParser.parse(rsp.body().refreshToken) instanceof SignedJWT

        when:
        String accessToken = rsp.body().accessToken
        HttpRequest requestWithAuthorization = HttpRequest.GET('/' ).header(HttpHeaders.AUTHORIZATION, "Bearer $accessToken")
        HttpResponse<String> response = client.toBlocking().exchange(requestWithAuthorization, String)

        then:
        response.status == HttpStatus.OK
        response.body() == 'juan'
    }
}
