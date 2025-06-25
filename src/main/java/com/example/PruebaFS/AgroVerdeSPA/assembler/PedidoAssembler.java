package com.example.PruebaFS.AgroVerdeSPA.assembler;

import com.example.PruebaFS.AgroVerdeSPA.controller.PedidoController;
import com.example.PruebaFS.AgroVerdeSPA.model.Pedido;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class PedidoAssembler implements RepresentationModelAssembler<Pedido, EntityModel<Pedido>> {

    @Override
    public EntityModel<Pedido> toModel(Pedido pedido) {
        return EntityModel.of(pedido,
            linkTo(methodOn(PedidoController.class).listar()).withRel("pedidos"),
            linkTo(methodOn(PedidoController.class).actualizar(pedido.getId(), pedido)).withRel("actualizar"),
            linkTo(PedidoController.class).slash(pedido.getId()).withRel("eliminar")
        );
    }
}
