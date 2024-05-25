package com.fiapfood.client.adapters.outbound.repository;

import com.fiapfood.client.adapters.inbound.entity.ClientEntity;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class ClientRepository implements PanacheMongoRepository<ClientEntity> {

    public Optional<ClientEntity> getClientByDocument(String document){
        return find("document", document).firstResultOptional();
    }
}
