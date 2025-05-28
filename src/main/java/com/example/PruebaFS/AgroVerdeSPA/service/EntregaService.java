package com.example.PruebaFS.AgroVerdeSPA.service;

import com.example.PruebaFS.AgroVerdeSPA.model.Entrega;
import com.example.PruebaFS.AgroVerdeSPA.repository.EntregaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntregaService {

    private final EntregaRepository repo;

    public EntregaService(EntregaRepository repo) {
        this.repo = repo;
    }

    public List<Entrega> listar() {
        return repo.findAll();
    }

    public Entrega guardar(Entrega entrega) {
        return repo.save(entrega);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    public Optional<Entrega> obtenerPorId(Long id) {
        return repo.findById(id);
    }
}
