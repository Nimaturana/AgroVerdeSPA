package com.example.PruebaFS.AgroVerdeSPA.assembler;

import com.example.PruebaFS.AgroVerdeSPA.controller.EntregaController;
import com.example.PruebaFS.AgroVerdeSPA.model.Entrega;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class EntregaAssembler implements RepresentationModelAssembler<Entrega, EntityModel<Entrega>> {

    @Override
    public EntityModel<Entrega> toModel(Entrega entrega) {
        return EntityModel.of(entrega,
            linkTo(methodOn(EntregaController.class).listar()).withRel("entregas"),
            linkTo(methodOn(EntregaController.class).actualizar(entrega.getId(), entrega)).withRel("actualizar"),
            linkTo(EntregaController.class).slash(entrega.getId()).withRel("eliminar")
        );
    }
}
