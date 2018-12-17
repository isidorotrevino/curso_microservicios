package com.ies.curso.dia1.demo6;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented // Permite ser documentado en Javadoc
@Target(ElementType.METHOD) //Permite anotar métodos
@Inherited //Permite que subclases hereden la anotación 
@Retention(RetentionPolicy.RUNTIME) /* La anotación se compila y queda
disponible en tiempo de ejecución*/ 
public @interface UsarProxy {

}
