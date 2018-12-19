package com.ies.curso.dia2.demo2.controller;

import com.ies.curso.dia2.demo2.command.ReactiveCommand;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Produces;
import io.reactiverse.reactivex.pgclient.PgPool;
import io.reactiverse.reactivex.pgclient.PgStream;
import io.reactiverse.reactivex.pgclient.Row;
import io.reactivex.Flowable;
import io.micronaut.http.annotation.Get;
import io.reactiverse.reactivex.pgclient.Tuple;

@Controller("/reactive")
public class ReactiveController {

    protected PgPool client;

    public ReactiveController(PgPool client){
        this.client = client;
    }

    @Get("/")
    @Produces(MediaType.APPLICATION_JSON_STREAM)
    public Flowable<Row> index(){
        Flowable<Row> flowable = client.rxBegin()
                .flatMapPublisher(tx -> tx.rxPrepare("SELECT id, identificador FROM prueba_reactive")
                    .flatMapPublisher(preparedQuery -> {
                        // Fetch 50 rows at a time
                        PgStream<Row> stream = preparedQuery.createStream(50, Tuple.tuple());
                        return stream.toFlowable();
                    })
                    // Commit the transaction after usage
                    .doAfterTerminate(tx::commit));
        return flowable;
    }
}
