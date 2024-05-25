package com.fiapfood.client.adapters.outbound.rest;

import com.fiapfood.client.application.core.domain.Address;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/ws")
@RegisterRestClient(baseUri = "https://viacep.com.br")
public interface GetAddressRest {

    @GET
    @Path("/{cep}/json")
    Address buscar(@PathParam("cep") String postCode);
}
