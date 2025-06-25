package com.example.PruebaFS.AgroVerdeSPA.controller;

import com.example.PruebaFS.AgroVerdeSPA.assembler.UsuarioAssembler;
import com.example.PruebaFS.AgroVerdeSPA.model.Usuario;
import com.example.PruebaFS.AgroVerdeSPA.repository.UsuarioRepository;
import com.example.PruebaFS.AgroVerdeSPA.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Tag(name = "Usuarios", description = "Operaciones de administración de usuarios del sistema")
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioAssembler assembler;

    private final UsuarioRepository repo;

    public UsuarioController(UsuarioRepository repo) {
        this.repo = repo;
    }

    @Operation(summary = "Listar usuarios", description = "Obtiene una lista de todos los usuarios registrados")
    @ApiResponse(responseCode = "200", description = "Usuarios obtenidos correctamente")
    @GetMapping
    public CollectionModel<EntityModel<Usuario>> listar() {
        List<EntityModel<Usuario>> usuarios = repo.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(usuarios,
                linkTo(methodOn(UsuarioController.class).listar()).withSelfRel());
    }

    @Operation(summary = "Crear usuario", description = "Registra un nuevo usuario")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Usuario creado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos para crear usuario")
    })
    @PostMapping
    public EntityModel<Usuario> guardar(@RequestBody Usuario usuario) {
        Usuario creado = repo.save(usuario);
        return assembler.toModel(creado);
    }

    @Operation(summary = "Actualizar usuario", description = "Actualiza un usuario existente por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Usuario actualizado correctamente"),
        @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    @PutMapping("/{id}")
    public EntityModel<Usuario> actualizar(@PathVariable Long id, @RequestBody Usuario datos) {
        datos.setId(id);
        Usuario actualizado = usuarioService.guardar(datos);
        return assembler.toModel(actualizado);
    }

    @Operation(summary = "Eliminar usuario", description = "Elimina un usuario por su ID")
    @ApiResponse(responseCode = "204", description = "Usuario eliminado correctamente")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
