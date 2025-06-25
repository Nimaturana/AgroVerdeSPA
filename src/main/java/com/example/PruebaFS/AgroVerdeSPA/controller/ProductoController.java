package com.example.PruebaFS.AgroVerdeSPA.controller;

import com.example.PruebaFS.AgroVerdeSPA.assembler.ProductoAssembler;
import com.example.PruebaFS.AgroVerdeSPA.model.Producto;
import com.example.PruebaFS.AgroVerdeSPA.repository.ProductoRepository;
import com.example.PruebaFS.AgroVerdeSPA.service.ProductoService;

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

@Tag(name = "Productos", description = "Operaciones relacionadas con el catálogo de productos orgánicos")
@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ProductoAssembler assembler;

    private final ProductoRepository repo;

    public ProductoController(ProductoRepository repo) {
        this.repo = repo;
    }

    @Operation(summary = "Listar productos", description = "Retorna todos los productos disponibles")
    @ApiResponse(responseCode = "200", description = "Productos listados correctamente")
    @GetMapping
    public CollectionModel<EntityModel<Producto>> listar() {
        List<EntityModel<Producto>> productos = repo.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(productos,
                linkTo(methodOn(ProductoController.class).listar()).withSelfRel());
    }

    @Operation(summary = "Crear producto", description = "Registra un nuevo producto")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Producto creado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping
    public EntityModel<Producto> guardar(@RequestBody Producto producto) {
        Producto creado = repo.save(producto);
        return assembler.toModel(creado);
    }

    @Operation(summary = "Actualizar producto", description = "Actualiza un producto por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Producto actualizado correctamente"),
        @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    @PutMapping("/{id}")
    public EntityModel<Producto> actualizar(@PathVariable Long id, @RequestBody Producto nuevoProducto) {
        nuevoProducto.setId(id);
        Producto actualizado = productoService.guardar(nuevoProducto);
        return assembler.toModel(actualizado);
    }

    @Operation(summary = "Eliminar producto", description = "Elimina un producto por ID")
    @ApiResponse(responseCode = "204", description = "Producto eliminado correctamente")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
