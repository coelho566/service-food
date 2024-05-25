package com.fiapfood.client.application.ports.in;

import com.fiapfood.client.adapters.inbound.request.ClientRequest;
import com.fiapfood.client.adapters.inbound.response.ClientResponse;

public interface ClientUseCasePort {
    void insertClient(ClientRequest client);
    ClientResponse getCLientByDocument(String document);
}
