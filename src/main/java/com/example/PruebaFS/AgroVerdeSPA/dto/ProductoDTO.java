package com.example.PruebaFS.AgroVerdeSPA.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {
    private String nombre;
    private String tipo;
    private Double precio;
    private Integer stock;
}
