package com.ies.curso.dia5.dto;

public class Filtro {

    private Long idInicial;
    private Long idFinal;
    private String identificador;

    public Long getIdInicial() {
        return idInicial;
    }

    public void setIdInicial(Long idInicial) {
        this.idInicial = idInicial;
    }

    public Long getIdFinal() {
        return idFinal;
    }

    public void setIdFinal(Long idFinal) {
        this.idFinal = idFinal;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
}
