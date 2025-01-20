package com.tuempresa.libreriafinal.modelo;

import java.time.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.model.*;

import lombok.*;

@Entity @Getter @Setter
public class HistorialMovimientos extends Identifiable {

    @Required
    LocalDate fecha;

    @Column(length = 20) @Required
    String tipoMovimiento;

    @Required
    int idProducto;

    @Required
    int cantidad;

}
