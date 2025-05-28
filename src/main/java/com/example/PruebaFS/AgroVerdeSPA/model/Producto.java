package com.example.PruebaFS.AgroVerdeSPA.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre; // Nombre Producto 

    private String tipo; // Tipo de producto (Cajas de Mangos, Cajas de Manzanas, Cajas de frutillas, etc...)

    private Integer stock; 

    private Double precio; 
}
