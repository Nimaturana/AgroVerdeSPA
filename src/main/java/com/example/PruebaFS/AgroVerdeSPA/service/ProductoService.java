package com.example.PruebaFS.AgroVerdeSPA.service;

import com.example.PruebaFS.AgroVerdeSPA.model.Producto;
import com.example.PruebaFS.AgroVerdeSPA.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository repo;

    public ProductoService(ProductoRepository repo) {
        this.repo = repo;
    }

    public List<Producto> listar() {
        return repo.findAll();
    }

    public Producto guardar(Producto producto) {
        return repo.save(producto);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    public Optional<Producto> obtenerPorId(Long id) {
        return repo.findById(id);
    }
}
