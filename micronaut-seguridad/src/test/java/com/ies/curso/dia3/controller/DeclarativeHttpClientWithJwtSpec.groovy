package com.ies.curso.dia3.controller

import com.ies.curso.dia3.AppClient
import io.micronaut.context.ApplicationContext
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.security.authentication.UsernamePasswordCredentials
import io.micronaut.security.token.jwt.render.BearerAccessRefreshToken
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class DeclarativeHttpClientWithJwtSpec extends Specification {

    @Shared
    @AutoCleanup
    EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer)

    @Shared
    @AutoCleanup
    RxHttpClient client = embeddedServer.applicationContext.createBean(RxHttpClient, embeddedServer.getURL())

    def "Verificamos que la autenticacion JWT funciona con un cliente declarativo@Client"() {
        when:
        AppClient appClient = embeddedServer.applicationContext.getBean(AppClient)

        then:
        noExceptionThrown()

        when: 'Acceso a una URL segura sin autenticarse'
        client.toBlocking().exchange(HttpRequest.GET('/', ))

        then: 'Regresa 401 - sin autorización'
        HttpClientResponseException e = thrown(HttpClientResponseException)
        e.status == HttpStatus.UNAUTHORIZED

        when: 'El endpoint de login es invocado con credenciales validas'
        UsernamePasswordCredentials creds = new UsernamePasswordCredentials("juan", "perez")
        HttpRequest request = HttpRequest.POST('/login', creds) // <5>
        HttpResponse<BearerAccessRefreshToken> rsp = client.toBlocking().exchange(request, BearerAccessRefreshToken) // <6>

        then: 'El endpoint regresa un código válido'
        rsp.status == HttpStatus.OK
        rsp.body().accessToken

        when:
        String accessToken = rsp.body().accessToken
        String authorizationValue = "Bearer $accessToken"
        String msg = appClient.home(authorizationValue)

        then:
        msg == 'juan'
    }
}
