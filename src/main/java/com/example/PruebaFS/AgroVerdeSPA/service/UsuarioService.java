package com.example.PruebaFS.AgroVerdeSPA.service;

import com.example.PruebaFS.AgroVerdeSPA.model.Usuario;
import com.example.PruebaFS.AgroVerdeSPA.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    public List<Usuario> listar() {
        return repo.findAll();
    }

    public Usuario guardar(Usuario usuario) {
        return repo.save(usuario);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    public Optional<Usuario> obtenerPorId(Long id) {
        return repo.findById(id);
    }
}
