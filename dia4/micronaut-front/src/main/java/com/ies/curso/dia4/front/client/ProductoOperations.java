package com.ies.curso.dia4.front.client;


import com.ies.curso.dia4.front.dto.Producto;

import io.reactivex.Flowable;

public interface ProductoOperations {

	Flowable<Producto> findAll();

	
}
