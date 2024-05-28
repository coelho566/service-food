package com.fiapfood.product.adapters.inbound;

import com.fiapfood.product.adapters.inbound.response.BaseResponse;
import com.fiapfood.product.adapters.inbound.response.ProductResponse;
import com.fiapfood.product.application.core.domain.Product;
import com.fiapfood.product.application.ports.in.ProductUseCasePort;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.List;

@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Product controller", description = "Produto operations")
public class ProductController {

    ProductUseCasePort productUseCasePort;

    public ProductController(ProductUseCasePort productUseCasePort) {
        this.productUseCasePort = productUseCasePort;
    }

    @POST
    @Operation(summary = "Criar um novo produto")
    public RestResponse<?> insertProduct(@Valid Product product) {
        productUseCasePort.insertProduct(product);
        return RestResponse.ok();
    }

    @GET
    @Operation(summary = "Buscar produto por categoria")
    public RestResponse<BaseResponse<List<ProductResponse>>> getClient(@QueryParam("category") String category) {

        var productByCategory = productUseCasePort.getProductByCategory(category);
        return RestResponse.ok(new BaseResponse<>(productByCategory));
    }

    @PUT
    @Path("{productId}")
    @Operation(summary = "Editar produto por id")
    public RestResponse<BaseResponse<ProductResponse>> updateProduto(@PathParam("productId") String id, Product product) {

        var productByCategory = productUseCasePort.updateProduct(id, product);
        return RestResponse.ok(new BaseResponse<>(productByCategory));
    }

    @DELETE
    @Path("{productId}")
    @Operation(summary = "Deletar produto por id")
    public RestResponse<BaseResponse<String>> removeProduto(@PathParam("productId") String id) {
        productUseCasePort.deleteProduct(id);
        return RestResponse.accepted();
    }
}
