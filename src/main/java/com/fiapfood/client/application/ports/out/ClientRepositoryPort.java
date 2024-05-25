package com.fiapfood.client.application.ports.out;

import com.fiapfood.client.adapters.inbound.entity.ClientEntity;
import com.fiapfood.client.application.core.domain.Client;

import java.util.Optional;

public interface ClientRepositoryPort {

    void saveClient(Client client);

    Optional<ClientEntity> getClientByDocument(String document);
}
