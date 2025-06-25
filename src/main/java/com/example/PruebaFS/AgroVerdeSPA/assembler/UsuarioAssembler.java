package com.example.PruebaFS.AgroVerdeSPA.assembler;

import com.example.PruebaFS.AgroVerdeSPA.controller.UsuarioController;
import com.example.PruebaFS.AgroVerdeSPA.model.Usuario;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class UsuarioAssembler implements RepresentationModelAssembler<Usuario, EntityModel<Usuario>> {

    @Override
    public EntityModel<Usuario> toModel(Usuario usuario) {
        return EntityModel.of(usuario,
            linkTo(methodOn(UsuarioController.class).listar()).withRel("usuarios"),
            linkTo(methodOn(UsuarioController.class).actualizar(usuario.getId(), usuario)).withRel("actualizar"),
            linkTo(UsuarioController.class).slash(usuario.getId()).withRel("eliminar")
        );
    }
}
