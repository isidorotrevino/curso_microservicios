package com.ies.curso.dia4.front.dto;

import java.util.ArrayList;
import java.util.List;

public class Paquete {

    private String nombre;
    private List<Producto> productos=new ArrayList<>();

    public Paquete(String nombre, List<Producto> productos) {
        this.nombre = nombre;
        this.productos = productos;
    }
    public Paquete(){

    }

    public void addProducto(Producto producto){
        this.productos.add(producto);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
