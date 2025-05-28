package com.example.PruebaFS.AgroVerdeSPA;

import com.example.PruebaFS.AgroVerdeSPA.model.Usuario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTests {

    @Test
    public void testCrearUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Nicolas M");
        usuario.setCorreo("nimaturana@agroverde.cl");
        usuario.setRol("Moderador");
        usuario.setDireccion("Calle falsa 123");
        usuario.setTelefono("+569 9999 9999");

        assertEquals("Nicolas M", usuario.getNombre());
        assertEquals("nimaturana@agroverde.cl", usuario.getCorreo());
        assertEquals("Moderador", usuario.getRol());
        assertEquals("Calle falsa 123", usuario.getDireccion());
        assertEquals("+569 9999 9999", usuario.getTelefono());
    }
}
