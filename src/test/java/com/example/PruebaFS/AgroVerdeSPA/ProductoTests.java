package com.example.PruebaFS.AgroVerdeSPA;

import com.example.PruebaFS.AgroVerdeSPA.model.Producto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductoTests {

    @Test
    public void testCrearProducto() {
        Producto producto = new Producto();
        producto.setNombre("Manzanas");
        producto.setTipo("Fruta");
        producto.setStock(10);
        producto.setPrecio(1990.0);

        assertEquals("Manzanas", producto.getNombre());
        assertEquals("Fruta", producto.getTipo());
        assertEquals(10, producto.getStock());
        assertEquals(1990.0, producto.getPrecio());
    }
}
