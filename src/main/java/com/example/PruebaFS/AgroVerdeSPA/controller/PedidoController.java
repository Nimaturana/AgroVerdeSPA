package com.example.PruebaFS.AgroVerdeSPA.controller;

import com.example.PruebaFS.AgroVerdeSPA.assembler.PedidoAssembler;
import com.example.PruebaFS.AgroVerdeSPA.model.Pedido;
import com.example.PruebaFS.AgroVerdeSPA.repository.PedidoRepository;
import com.example.PruebaFS.AgroVerdeSPA.service.PedidoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Tag(name = "Pedidos", description = "Operaciones relacionadas con la gestión de pedidos de clientes")
@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private PedidoAssembler assembler;

    private final PedidoRepository repo;

    public PedidoController(PedidoRepository repo) {
        this.repo = repo;
    }

    @Operation(summary = "Listar pedidos", description = "Retorna todos los pedidos realizados")
    @ApiResponse(responseCode = "200", description = "Pedidos listados correctamente")
    @GetMapping
    public CollectionModel<EntityModel<Pedido>> listar() {
        List<EntityModel<Pedido>> pedidos = repo.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(pedidos,
                linkTo(methodOn(PedidoController.class).listar()).withSelfRel());
    }

    @Operation(summary = "Crear pedido", description = "Registra un nuevo pedido")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Pedido creado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping
    public EntityModel<Pedido> guardar(@RequestBody Pedido pedido) {
        Pedido creado = repo.save(pedido);
        return assembler.toModel(creado);
    }

    @Operation(summary = "Actualizar pedido", description = "Actualiza un pedido por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Pedido actualizado correctamente"),
        @ApiResponse(responseCode = "404", description = "Pedido no encontrado")
    })
    @PutMapping("/{id}")
    public EntityModel<Pedido> actualizar(@PathVariable Long id, @RequestBody Pedido nuevoPedido) {
        nuevoPedido.setId(id);
        Pedido actualizado = pedidoService.guardar(nuevoPedido);
        return assembler.toModel(actualizado);
    }

    @Operation(summary = "Eliminar pedido", description = "Elimina un pedido por ID")
    @ApiResponse(responseCode = "204", description = "Pedido eliminado correctamente")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
