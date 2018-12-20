package com.ies.curso.dia4.front.client;

import javax.inject.Singleton;

import com.ies.curso.dia4.front.dto.Producto;

import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;
import io.micronaut.retry.annotation.Fallback;
import io.reactivex.Flowable;

@Requires(env = Environment.TEST)
@Fallback
@Singleton
public class ProductoClientStub implements ProductoOperations {

    @Override
    public Flowable<Producto> findAll() {
        Producto palomitas = new Producto("PAL123","Palomitas", "Act One",false);
        Producto papas = new Producto("PAP123","Adobadas", "Sabritas",false);
        return Flowable.just(papas, palomitas);
    }
}