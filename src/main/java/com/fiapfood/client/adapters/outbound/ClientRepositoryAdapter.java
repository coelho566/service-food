package com.fiapfood.client.adapters.outbound;

import com.fiapfood.client.adapters.inbound.entity.ClientEntity;
import com.fiapfood.client.adapters.inbound.mapper.ClientMapper;
import com.fiapfood.client.adapters.outbound.repository.ClientRepository;
import com.fiapfood.client.application.core.domain.Client;
import com.fiapfood.client.application.ports.out.ClientRepositoryPort;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class ClientRepositoryAdapter implements ClientRepositoryPort {


    ClientRepository clientRepository;
    ClientMapper clientMapper;

    public ClientRepositoryAdapter(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public void saveClient(Client client) {
        clientRepository.persist(clientMapper.clientToClientEntity(client));
    }

    @Override
    public Optional<ClientEntity> getClientByDocument(String document) {
        return clientRepository.getClientByDocument(document);
    }
}
