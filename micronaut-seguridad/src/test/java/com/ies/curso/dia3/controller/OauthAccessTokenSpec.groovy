package com.ies.curso.dia3.controller

import io.micronaut.context.ApplicationContext
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.RxHttpClient
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.security.authentication.UsernamePasswordCredentials
import io.micronaut.security.token.jwt.endpoints.TokenRefreshRequest
import io.micronaut.security.token.jwt.render.AccessRefreshToken
import io.micronaut.security.token.jwt.render.BearerAccessRefreshToken
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class OauthAccessTokenSpec extends Specification {

    @Shared
    @AutoCleanup
    EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer)

    @Shared
    @AutoCleanup
    RxHttpClient client = embeddedServer.applicationContext.createBean(RxHttpClient, embeddedServer.getURL())

    def "Verificar que el refrescado de JWT funciona"() {
        when: 'login endpoint se llama con credenciales válidas'
        UsernamePasswordCredentials creds = new UsernamePasswordCredentials("juan", "perez")
        HttpRequest request = HttpRequest.POST('/login', creds)
        HttpResponse<BearerAccessRefreshToken> rsp = client.toBlocking().exchange(request, BearerAccessRefreshToken)

        then: 'El endpoint es accesible'
        rsp.status == HttpStatus.OK

        when:
        sleep(1_000)
        String refreshToken = rsp.body().refreshToken
        String accessToken = rsp.body().accessToken

        HttpResponse<AccessRefreshToken> response = client.toBlocking().exchange(HttpRequest.POST('/oauth/access_token',
                new TokenRefreshRequest("refresh_token", refreshToken)), AccessRefreshToken)

        then:
        response.status == HttpStatus.OK
        response.body().accessToken
        response.body().accessToken != accessToken
    }
}
