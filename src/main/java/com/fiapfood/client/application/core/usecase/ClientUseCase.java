package com.fiapfood.client.application.core.usecase;

import com.fiapfood.client.adapters.inbound.mapper.ClientMapper;
import com.fiapfood.client.adapters.inbound.request.ClientRequest;
import com.fiapfood.client.adapters.inbound.response.ClientResponse;
import com.fiapfood.client.application.core.domain.Client;
import com.fiapfood.client.application.core.exception.ClientException;
import com.fiapfood.client.application.ports.in.ClientUseCasePort;
import com.fiapfood.client.application.ports.out.ClientRepositoryPort;
import com.fiapfood.client.application.ports.out.GetAddressPort;

public class ClientUseCase implements ClientUseCasePort {

    private final GetAddressPort getAddressPort;
    private final ClientRepositoryPort clientRepositoryPort;
    private final ClientMapper clientMapper;

    public ClientUseCase(GetAddressPort getAddressPort, ClientRepositoryPort clientRepositoryPort, ClientMapper clientMapper) {
        this.getAddressPort = getAddressPort;
        this.clientRepositoryPort = clientRepositoryPort;
        this.clientMapper = clientMapper;
    }

    @Override
    public void insertClient(ClientRequest client) {
        var clientByDocument = clientRepositoryPort.getClientByDocument(client.document());

        if (clientByDocument.isEmpty()) {
            var address = getAddressPort.getAddress(client.postalCode());
            var newclient = new Client(
                    client.name(), client.phone(),
                    client.email(), client.document(),
                    client.documentType(), client.allowNotification(),
                    address);
            clientRepositoryPort.saveClient(newclient);
        } else {
            throw new ClientException("Customer already exists with this document");
        }
    }

    @Override
    public ClientResponse getCLientByDocument(String document) {
        var clientByDocument = clientRepositoryPort.getClientByDocument(document);

        if (clientByDocument.isPresent()) {
            return clientMapper.clientEntityToClientResponse(clientByDocument.get());
        } else {
            throw new ClientException("Customer not found with the document provided.");
        }
    }
}
