package com.example.PruebaFS.AgroVerdeSPA.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private String nombre;
    private String correo;
    private String direccion;
    private String rol;
    private String telefono;
}
