package com.tuempresa.libreriafinal.modelo;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.model.*;

import lombok.*;

@Entity @Getter @Setter
public class Inventario extends Identifiable {

    @Column(length = 50) @Required
    String nombre;

    @Required
    int capacidadMaxima;

    @ManyToOne
    private Usuario usuario;

    @OneToMany(mappedBy = "inventario")
    @ListProperties("titulo, cantidad, precio")
    private List<Producto> productos;

    public void agregarProducto(Producto producto) {
        if (productos.size() < capacidadMaxima) {
            productos.add(producto);
        }
    }

    public boolean verificarStock(Producto producto) {
        return producto.getCantidad() > 0;
    }

    public float calcularCostoTotal() {
        return productos.stream()
                .map(producto -> producto.getPrecio().floatValue() * producto.getCantidad())
                .reduce(0f, Float::sum);
    }
}
