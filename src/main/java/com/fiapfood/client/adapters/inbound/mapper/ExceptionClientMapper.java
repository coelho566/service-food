package com.fiapfood.client.adapters.inbound.mapper;

import com.fiapfood.client.adapters.inbound.response.BaseResponse;
import com.fiapfood.client.adapters.inbound.response.ErrorResponse;
import com.fiapfood.client.application.core.exception.ClientException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ExceptionClientMapper implements ExceptionMapper<ClientException> {

    @Override
    public Response toResponse(ClientException e) {

        var errorResponse = new ErrorResponse();
        errorResponse.setCode("400");
        errorResponse.setMenssage(e.getMessage());

        return Response.status(Response.Status.BAD_REQUEST).entity(new BaseResponse<>(errorResponse)).build();
    }
}
