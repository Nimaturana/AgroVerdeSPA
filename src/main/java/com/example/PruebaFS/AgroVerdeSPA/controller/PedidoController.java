package com.example.PruebaFS.AgroVerdeSPA.controller;

import com.example.PruebaFS.AgroVerdeSPA.model.Pedido;
import com.example.PruebaFS.AgroVerdeSPA.repository.PedidoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoRepository repo;

    public PedidoController(PedidoRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Pedido> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Pedido guardar(@RequestBody Pedido pedido) {
        return repo.save(pedido);
    }

    @PutMapping("/{id}")
    public Pedido actualizar(@PathVariable Long id, @RequestBody Pedido nuevoPedido) {
    return repo.findById(id).map(pedidoExistente -> {
        pedidoExistente.setFecha(nuevoPedido.getFecha());
        pedidoExistente.setEstado(nuevoPedido.getEstado());
        pedidoExistente.setCantidad(nuevoPedido.getCantidad());
        pedidoExistente.setUsuario(nuevoPedido.getUsuario());
        pedidoExistente.setProducto(nuevoPedido.getProducto());
        return repo.save(pedidoExistente);
    }).orElseGet(() -> {
        nuevoPedido.setId(id);      // si no existiera, lo crea con el ID ya dado
        return repo.save(nuevoPedido);
    });
}

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
