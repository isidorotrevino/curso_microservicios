package com.ies.curso.dia5.gateway.client;

import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;
import io.micronaut.http.annotation.Header;
import io.reactivex.Single;

import javax.inject.Singleton;

import com.ies.curso.dia5.gateway.service.*;

@Requires(env = Environment.TEST)
@Singleton
public class UserEchoClientReplacement implements UsernameFetcher {

    @Override
    public Single<String> findUsername() {
        return Single.just("juan");
    }
}
