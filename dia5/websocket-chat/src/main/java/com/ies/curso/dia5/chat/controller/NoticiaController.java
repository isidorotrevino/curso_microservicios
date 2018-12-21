package com.ies.curso.dia5.chat.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.sse.Event;
import io.reactivex.Flowable;
import org.reactivestreams.Publisher;
import com.ies.curso.dia5.chat.dto.Noticia;
import java.time.LocalDateTime;

@Controller("/noticias")
public class NoticiaController {

    @Get("/")
    public Publisher<Event<Noticia>> index(){
        Integer cantidadNoticias=1000;

        return Flowable.generate(()-> 0,(i,emitter)->{
           if(i<=cantidadNoticias){
               Thread.sleep(3000);
                emitter.onNext(Event.of(new Noticia(LocalDateTime.now(),"La noticia numero "+i)));
           }
           else{
               emitter.onComplete();
           }
            return ++i;
        });
    }
}
