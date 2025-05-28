package com.example.PruebaFS.AgroVerdeSPA.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    private LocalDate fechaEntrega; // fecha y hora del -PEDIDO- entregado 

    private String direccionDestino; // Direccion donde se hizo la entrega del -PEDIDO-

    private String estadoEntrega; // PEDIDO "EN CAMINO", "ENTREGADO", "DEVUELTO", etc...

    @OneToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
}
