package com.example.PruebaFS.AgroVerdeSPA.controller;

import com.example.PruebaFS.AgroVerdeSPA.model.Producto;
import com.example.PruebaFS.AgroVerdeSPA.repository.ProductoRepository;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoRepository repo;

    public ProductoController(ProductoRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Producto> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Producto guardar(@RequestBody Producto producto) {
        return repo.save(producto);
    }

    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable Long id, @RequestBody Producto nuevoProducto) {
        Optional<Producto> productoExistente = repo.findById(id);
    if (productoExistente.isPresent()) {
        Producto producto = productoExistente.get();
        producto.setNombre(nuevoProducto.getNombre());
        producto.setTipo(nuevoProducto.getTipo());
        producto.setStock(nuevoProducto.getStock());
        producto.setPrecio(nuevoProducto.getPrecio());
        return repo.save(producto);
    } else {
        nuevoProducto.setId(id);
        return repo.save(nuevoProducto);
    }
}


    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
