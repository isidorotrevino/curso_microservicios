package com.ies.curso.dia5.gateway.service;

import io.reactivex.Single;

public interface UsernameFetcher {
    Single<String> findUsername();
}
