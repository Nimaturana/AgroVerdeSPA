package com.example.PruebaFS.AgroVerdeSPA.assembler;

import com.example.PruebaFS.AgroVerdeSPA.controller.ProductoController;
import com.example.PruebaFS.AgroVerdeSPA.model.Producto;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ProductoAssembler implements RepresentationModelAssembler<Producto, EntityModel<Producto>> {

    @Override
    public EntityModel<Producto> toModel(Producto producto) {
        return EntityModel.of(producto,
            linkTo(methodOn(ProductoController.class).listar()).withRel("productos"),
            linkTo(methodOn(ProductoController.class).actualizar(producto.getId(), producto)).withRel("actualizar"),
            linkTo(ProductoController.class).slash(producto.getId()).withRel("eliminar")
        );
    }
}
