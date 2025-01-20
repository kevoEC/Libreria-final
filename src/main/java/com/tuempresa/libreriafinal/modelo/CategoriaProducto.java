package com.tuempresa.libreriafinal.modelo;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.model.*;

import lombok.*;

@Entity @Getter @Setter
public class CategoriaProducto extends Identifiable {

    @Column(length = 50) @Required
    String nombreCategoria;

    @Column(length = 200)
    String descripcion;

    @OneToMany(mappedBy = "categoria")
    private java.util.List<Producto> productos;

    public void agregarCategoria(String nombre, String descripcion) {
        this.nombreCategoria = nombre;
        this.descripcion = descripcion;
    }
}
