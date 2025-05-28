package com.example.PruebaFS.AgroVerdeSPA.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre; 

    private String correo;

    private String direccion;

    private String rol; // ADMIN, CLIENTE, INFLUENCER, etc...

    private String telefono;
}
