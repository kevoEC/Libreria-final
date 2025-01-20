package com.tuempresa.libreriafinal.modelo;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.model.*;

import lombok.*;

@Entity @Getter @Setter
public class Proveedor extends Identifiable {

    @Column(length = 100) @Required
    String nombre;

    @Column(length = 50) @Required
    String contacto;

    @Column(length = 200)
    String direccion;

    @OneToMany(mappedBy = "proveedor")
    private java.util.List<Producto> productos;

    public void registrarProveedor(String nombre, String contacto) {
        this.nombre = nombre;
        this.contacto = contacto;
    }
}
