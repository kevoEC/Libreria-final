package com.tuempresa.libreriafinal.modelo;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.model.*;

import lombok.*;

@Entity @Getter @Setter
public class Usuario extends Identifiable {

    @Column(length = 50) @Required
    String nombre;

    @Column(length = 20) @Required
    String rol;

    @Column(length = 100) @Required
    String credenciales;

    @OneToMany(mappedBy = "usuario")
    @ListProperties("nombre, capacidadMaxima")
    private java.util.List<Inventario> inventarios;

    public boolean autentificarUsuario(String credencialesIngresadas) {
        return this.credenciales.equals(credencialesIngresadas);
    }

    public void gestionarInventario(Inventario inventario) {
        this.inventarios.add(inventario);
    }
}
