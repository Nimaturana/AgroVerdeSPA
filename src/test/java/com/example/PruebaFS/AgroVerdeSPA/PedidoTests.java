package com.example.PruebaFS.AgroVerdeSPA;

import com.example.PruebaFS.AgroVerdeSPA.model.Pedido;
import com.example.PruebaFS.AgroVerdeSPA.model.Usuario;
import com.example.PruebaFS.AgroVerdeSPA.model.Producto;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTests {

    @Test
    public void testCrearPedido() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);

        Producto producto = new Producto();
        producto.setId(1L);

        Pedido pedido = new Pedido();
        pedido.setUsuario(usuario);
        pedido.setProducto(producto);
        pedido.setCantidad(3);
        pedido.setEstado("PENDIENTE");
        pedido.setFecha(LocalDateTime.of(2025, 5, 26, 10, 30));

        assertEquals(1L, pedido.getUsuario().getId());
        assertEquals(1L, pedido.getProducto().getId());
        assertEquals(3, pedido.getCantidad());
        assertEquals("PENDIENTE", pedido.getEstado());
        assertEquals(LocalDateTime.of(2025, 5, 26, 10, 30), pedido.getFecha());
    }
}
