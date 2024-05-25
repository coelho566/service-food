package com.fiapfood.client.adapters.inbound;

import com.fiapfood.client.adapters.inbound.request.ClientRequest;
import com.fiapfood.client.adapters.inbound.response.BaseResponse;
import com.fiapfood.client.adapters.inbound.response.ClientResponse;
import com.fiapfood.client.application.core.domain.Client;
import com.fiapfood.client.application.ports.in.ClientUseCasePort;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.reactive.RestResponse;

@Path("/client")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Client controller", description = "Client operations")
public class ClientController {

    ClientUseCasePort clientUseCasePort;

    public ClientController(ClientUseCasePort clientUseCasePort) {
        this.clientUseCasePort = clientUseCasePort;
    }

    @POST
    public RestResponse<?> insertClient(@Valid ClientRequest client) {
        clientUseCasePort.insertClient(client);
        return RestResponse.ok();
    }

    @GET
    public RestResponse<BaseResponse<ClientResponse>> getClient(@QueryParam("document") String document) {
        var cLientResponse = clientUseCasePort.getCLientByDocument(document);
        return RestResponse.ok(new BaseResponse<>(cLientResponse));
    }
}
