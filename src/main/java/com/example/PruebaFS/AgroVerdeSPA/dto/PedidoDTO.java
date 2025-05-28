package com.example.PruebaFS.AgroVerdeSPA.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {
    private Long idUsuario;
    private Long idProducto;
    private Integer cantidad;
    private String estado;
}
