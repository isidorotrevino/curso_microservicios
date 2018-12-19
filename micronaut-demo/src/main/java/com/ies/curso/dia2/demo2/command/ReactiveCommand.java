package com.ies.curso.dia2.demo2.command;

public class ReactiveCommand {

    protected Long id;
    protected String identificador;

    public ReactiveCommand(){

    }

    public ReactiveCommand(Long id,String identificador){
        this.id=id;
        this.identificador=identificador;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
}
