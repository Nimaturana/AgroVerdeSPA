package com.example.PruebaFS.AgroVerdeSPA.controller;

import com.example.PruebaFS.AgroVerdeSPA.assembler.EntregaAssembler;
import com.example.PruebaFS.AgroVerdeSPA.model.Entrega;
import com.example.PruebaFS.AgroVerdeSPA.repository.EntregaRepository;
import com.example.PruebaFS.AgroVerdeSPA.service.EntregaService;

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

@Tag(name = "Entregas", description = "Operaciones relacionadas con la logística y seguimiento de entregas")
@RestController
@RequestMapping("/api/entregas")
public class EntregaController {

    @Autowired
    private EntregaService entregaService;

    @Autowired
    private EntregaAssembler assembler;

    private final EntregaRepository repo;

    public EntregaController(EntregaRepository repo) {
        this.repo = repo;
    }

    @Operation(summary = "Listar entregas", description = "Devuelve una lista con todas las entregas registradas")
    @ApiResponse(responseCode = "200", description = "Listado obtenido correctamente")
    @GetMapping
    public CollectionModel<EntityModel<Entrega>> listar() {
        List<EntityModel<Entrega>> entregas = repo.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(entregas,
                linkTo(methodOn(EntregaController.class).listar()).withSelfRel());
    }

    @Operation(summary = "Crear entrega", description = "Registra una nueva entrega en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Entrega creada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping
    public EntityModel<Entrega> guardar(@RequestBody Entrega entrega) {
        Entrega guardada = repo.save(entrega);
        return assembler.toModel(guardada);
    }

    @Operation(summary = "Actualizar entrega", description = "Actualiza los datos de una entrega existente por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Entrega actualizada correctamente"),
            @ApiResponse(responseCode = "404", description = "Entrega no encontrada")
    })
    @PutMapping("/{id}")
    public EntityModel<Entrega> actualizar(@PathVariable Long id, @RequestBody Entrega nuevaEntrega) {
        nuevaEntrega.setId(id);
        Entrega actualizada = entregaService.guardar(nuevaEntrega);
        return assembler.toModel(actualizada);
    }

    @Operation(summary = "Eliminar entrega", description = "Elimina una entrega específica por ID")
    @ApiResponse(responseCode = "204", description = "Entrega eliminada correctamente")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
