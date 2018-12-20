package com.ies.curso.dia4.front.client;


import com.ies.curso.dia4.front.dto.Producto;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Flowable;

@Client("http://localhost:8081")
public interface ProductoClient extends ProductoOperations {

    @Get("/productos")
    Flowable<Producto> findAll();
}
