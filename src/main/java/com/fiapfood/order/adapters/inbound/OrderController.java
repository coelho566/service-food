package com.fiapfood.order.adapters.inbound;

import com.fiapfood.order.application.core.domain.Order;
import com.fiapfood.order.application.ports.in.OrderUseCasePort;
import com.fiapfood.product.adapters.inbound.response.BaseResponse;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.List;

@Path("/order")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Order controller", description = "Order operations")
public class OrderController {

    OrderUseCasePort orderUseCasePort;

    public OrderController(OrderUseCasePort orderUseCasePort) {
        this.orderUseCasePort = orderUseCasePort;
    }

    @POST
    @Path("/checkout")
    @Operation(summary = "Fazer checkout do pedido")
    public RestResponse<BaseResponse<String>> orderCheckout(@Valid Order order) {
        String checkoutOrder = orderUseCasePort.checkoutOrder(order);
        return RestResponse.ok(new BaseResponse<>(checkoutOrder));
    }

    @GET
    @Operation(summary = "Lista todos os pedidos")
    public RestResponse<List<Order>> getAllOrders() {
        var orders = orderUseCasePort.listOrder();
        return RestResponse.ok(orders);
    }
}

