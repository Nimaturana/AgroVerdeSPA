package com.example.PruebaFS.AgroVerdeSPA.controller;

import com.example.PruebaFS.AgroVerdeSPA.model.Entrega;
import com.example.PruebaFS.AgroVerdeSPA.repository.EntregaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entregas")
public class EntregaController {

    private final EntregaRepository repo;

    public EntregaController(EntregaRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Entrega> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Entrega guardar(@RequestBody Entrega entrega) {
        return repo.save(entrega);
    }

    @PutMapping("/{id}")
    public Entrega actualizar(@PathVariable Long id, @RequestBody Entrega nuevaEntrega) {
    return repo.findById(id).map(entregaExistente -> {
        entregaExistente.setFechaEntrega(nuevaEntrega.getFechaEntrega());
        entregaExistente.setDireccionDestino(nuevaEntrega.getDireccionDestino()); 
        entregaExistente.setEstadoEntrega(nuevaEntrega.getEstadoEntrega()); 
        entregaExistente.setPedido(nuevaEntrega.getPedido());
        return repo.save(entregaExistente);
    }).orElseGet(() -> {
        nuevaEntrega.setId(id); // crearla si no existiera
        return repo.save(nuevaEntrega);
    });
}



    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
