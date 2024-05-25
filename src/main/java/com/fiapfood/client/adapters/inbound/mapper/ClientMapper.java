package com.fiapfood.client.adapters.inbound.mapper;

import com.fiapfood.client.adapters.inbound.entity.AddressEntity;
import com.fiapfood.client.adapters.inbound.entity.ClientEntity;
import com.fiapfood.client.adapters.inbound.response.AddressResponse;
import com.fiapfood.client.adapters.inbound.response.ClientResponse;
import com.fiapfood.client.application.core.domain.Client;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClientMapper {


    public ClientEntity clientToClientEntity(Client client) {
        return ClientEntity.builder()
                .name(client.name())
                .email(client.email())
                .document(client.document())
                .documentType(client.documentType())
                .allowNotification(client.allowNotification())
                .address(AddressEntity.builder()
                        .city(client.address().city())
                        .state(client.address().state())
                        .street(client.address().street())
                        .postalCode(client.address().postalCode())
                        .build())
                .build();
    }

    public ClientResponse clientEntityToClientResponse(ClientEntity client) {
        var addressResponse = new AddressResponse(client.getAddress().getPostalCode(),
                client.getAddress().getStreet(), client.getAddress().getState(), client.getAddress().getCity());
        return new ClientResponse(client.getName(), client.getPhone(), client.getEmail(), client.getDocument(), addressResponse);
    }
}
