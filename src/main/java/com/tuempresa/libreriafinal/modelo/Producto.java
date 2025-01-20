package com.tuempresa.libreriafinal.modelo;

import java.math.*;
import java.time.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.model.*;

import lombok.*;

@Entity @Getter @Setter
public class Producto extends Identifiable {

    @Column(length = 100) @Required
    String titulo;

    @Column(length = 50) @Required
    String autor;

    @Column(length = 30) @Required
    String genero;

    @Column(length = 13, unique = true) @Required
    String ISBN;
    
    @Column
    int nivelMinimoStock;

    @Required
    int cantidad;

    @Stereotype("MONEY")
    BigDecimal precio;

    @Required
    LocalDate fechaIngreso;

    @ManyToOne
    @DescriptionsList
    private CategoriaProducto categoria;

    @ManyToOne
    private Inventario inventario;
    
    @ManyToOne
    @DescriptionsList
    private Proveedor proveedor;


    public void modificarProducto(String nuevoTitulo, int nuevaCantidad) {
        this.titulo = nuevoTitulo;
        this.cantidad = nuevaCantidad;
    }
    
    public boolean esStockBajo() {
        return this.cantidad <= this.nivelMinimoStock;
    }
}
