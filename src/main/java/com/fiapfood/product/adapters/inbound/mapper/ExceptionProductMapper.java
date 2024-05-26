package com.fiapfood.product.adapters.inbound.mapper;

import com.fiapfood.client.application.core.exception.ClientException;
import com.fiapfood.product.adapters.inbound.response.BaseResponse;
import com.fiapfood.product.adapters.inbound.response.ErrorResponse;
import com.fiapfood.product.application.core.exception.ProductException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ExceptionProductMapper implements ExceptionMapper<ProductException> {

    @Override
    public Response toResponse(ProductException e) {

        var errorResponse = new ErrorResponse();
        errorResponse.setCode("400");
        errorResponse.setMenssage(e.getMessage());

        return Response.status(Response.Status.BAD_REQUEST).entity(new BaseResponse<>(errorResponse)).build();
    }
}
