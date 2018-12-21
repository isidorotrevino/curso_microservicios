package com.ies.curso.dia5.service;

import com.ies.curso.dia5.dto.Filtro;
import com.ies.curso.dia5.dto.Registro;

import java.util.List;
import java.util.Map;

public interface PersistenceService {

    public List<Map<String,Object>> obtenerDatosPrueba();

    public List<Registro> obtenerRegistrosFiltrado(Long idInicial,Long idFinal);

    public List<Registro> obtenerRegistrosAvanzado(Filtro filtro);
}
